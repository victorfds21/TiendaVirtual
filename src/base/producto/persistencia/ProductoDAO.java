
package base.producto.persistencia;

import base.producto.dominio.Producto;
import java.util.List;


public interface ProductoDAO {
    
    List<Producto> leerProductos();
    
    boolean actualizarProducto(List<Producto>productos);
}
