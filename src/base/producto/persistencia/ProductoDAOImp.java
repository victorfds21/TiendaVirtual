
package base.producto.persistencia;

import base.producto.dominio.Producto;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ProductoDAOImp {
    List<Producto> productos = new ArrayList<>();
    NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRANCE);
    Number numero;
    String lineaConDatos;
    String archivosProductos = "productos.txt";
    
}
