package base.producto.persistencia;

import base.producto.dominio.Producto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class ProductoDAOImp implements ProductoDAO {

    private List<Producto> productos;

    public ProductoDAOImp() {
        this.productos = new ArrayList<>();
    }

    @Override
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRANCE);
        Number numero;
        String lineaConDatos;
        String archivosProductos = "productos.txt";
        System.out.println();
        try ( BufferedReader archivo = Files.newBufferedReader(Paths.get(archivosProductos))) {
            while (archivo.readLine() != null) {
                //codigo
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineaConDatos);
                int codigo = numero.intValue();
                //nombre
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                String nombre = lineaConDatos;
                //descrip
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                String descripcion = lineaConDatos;
                //precio
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineaConDatos);
                double precio = numero.doubleValue();

                productos.add(new Producto(codigo, nombre, descripcion, precio));

            }
        } catch (ParseException e) {
            System.out.println("Error de formato de numero");

        } catch (IOException e) {
            System.out.println("Error de formato de Archivo");
        }
        this.productos = productos;
        return productos;

    }

    @Override
    public Producto getProductoPorCodigo(int codigo) {
        List<Producto> productos = leerProductos();
        for (Producto producto : productos) {
            if (codigo == producto.getCodigo()) {

                return producto;
            }
        }
        return null;
    }
     public boolean actualizarProducto() {
         return actualizarProducto(productos);
     }

    @Override
    public boolean actualizarProducto(List<Producto> productos) {

        String nombreArchivo = "productos.txt";
        Path rutaArchivo = Paths.get(nombreArchivo);

        try {
            BufferedWriter writer = Files.newBufferedWriter(rutaArchivo);
            Formatter salida = new Formatter(writer);

            for (Producto producto : productos) {
                salida.format("%s%n%s%n%d%n%s%n%s%n%s%n%s%n%s%n%.2f%n",
                        "[producto]", "[codigo]", producto.getCodigo(),
                        "[nombre]", producto.getNombre(), "[descripcion]", producto.getDescripcion(),
                        "[precio]", producto.getPrecio());

            }

            salida.close();
            writer.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
