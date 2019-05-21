package base.pedido.persistencia;

import base.pedido.dominio.Pedido;
import java.nio.file.Files;
import java.nio.file.Paths;
import base.producto.dominio.Producto;

public class PedidoDAOImp implements PedidoDAO {

    @Override
    public boolean actualizarPedido(Pedido pedido) {
        String nombreArchivo = "factura.txt";
        try ( var archivo = Files.newBufferedWriter(Paths.get(nombreArchivo))) {
            archivo.write("Factura simplificada: ");
            archivo.newLine();
            archivo.write("-------------------------------------------");
            archivo.newLine();
            for (Producto producto : pedido.getProductos()) {

                archivo.write("codigo: " + producto.getCodigo());
                archivo.newLine();

                archivo.write("nombre: " + producto.getNombre());
                archivo.newLine();

                archivo.write("descripcion: " + producto.getDescripcion());
                archivo.newLine();

                archivo.write("precio: " + producto.getPrecio() + "\n");
                archivo.newLine();

            }
            archivo.write("-------------------------------------------");
            archivo.newLine();
            archivo.write("El precio total es: " + pedido.getPrecioTotal());
            archivo.newLine();
            archivo.write("Atendido por: " + pedido.getNombreEmpleado());
            archivo.newLine();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
