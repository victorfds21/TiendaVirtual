package base.pedido.persistencia;

import base.pedido.dominio.Pedido;
import java.nio.file.Files;
import java.nio.file.Paths;
import base.producto.dominio.Producto;


public class PedidoDAOImp implements PedidoDAO{

  
    
    @Override
    public boolean actualizarPedido(Pedido pedido) {
        String nombreArchivo = "pedido.txt";
        try (var archivo = Files.newBufferedWriter(Paths.get(nombreArchivo))){
          archivo.write("Factura simplificada: ");
          archivo.write("-------------------------------------------");
            for (Producto producto : pedido.getProductos()) {
            archivo.write("codigo: " + producto.getCodigo());
            archivo.write("");
            archivo.write("nombre: " + producto.getNombre());
            archivo.write("");
            archivo.write("descripcion: " + producto.getDescripcion());
            archivo.write("");
            archivo.write("precio: " + producto.getPrecio());
            archivo.write("");
            
            }
            archivo.write("-------------------------------------------");
            archivo.write("El precio total es: " + pedido.getPrecioTotal());
            archivo.write("Atendido por: " + pedido.getNombreEmpleado());
             return true;
        } catch (Exception e) {
            return false;
        }
       
    }

}
