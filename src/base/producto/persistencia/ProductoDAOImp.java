package base.producto.persistencia;

import base.producto.dominio.Producto;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductoDAOImp implements ProductoDAO {

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

    @Override
    public boolean actualizarProducto(List<Producto> productos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
