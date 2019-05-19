
package base.producto.persistencia;

import base.producto.dominio.Producto;
import java.util.List;


public interface ProductoDAO {
    
    List<Producto> leerProductos();
    
     Producto getProductoPorCodigo(int codigo);
    
    boolean actualizarProducto(List<Producto>productos);
}
