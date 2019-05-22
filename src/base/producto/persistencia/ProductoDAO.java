package base.producto.persistencia;

import base.producto.dominio.Producto;
import java.util.List;

public interface ProductoDAO {

    List<Producto> leerProductos();

    Producto getProductoPorCodigo(int codigo);

    boolean actualizarNombre(int codigo, String nombre);

    boolean actualizarPrecio(int codigo, double precio);

    boolean actualizarCodigo(int codigo, int nuevoCodigo);
}
