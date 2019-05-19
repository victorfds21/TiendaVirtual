package base.producto.control;

import base.producto.dominio.Producto;
import base.producto.persistencia.ProductoDAOImp;
import java.util.Scanner;

public class ControladorProducto {
    
    private ProductoDAOImp productoDAOImp;
    
    public ControladorProducto() {
        this.productoDAOImp = new ProductoDAOImp();
    }
    
    public void modificarProducto() {
        Scanner scan = new Scanner(System.in);
        for (Producto producto : productoDAOImp.leerProductos()) {
            System.out.println(producto);
        }
        
        boolean datosCorrectos = false;
        do {
            System.out.println("Que producto desea modificar?");
            int codigo = scan.nextInt();
            Producto producto = productoDAOImp.getProductoPorCodigo(codigo);
            if (producto != null) {
                datosCorrectos = modificarAtributo(producto);
            }else{
                System.out.println("El producto no existe");
            }
        } while (!datosCorrectos);
        
    }
    
    private boolean modificarAtributo(Producto producto) {
        System.out.println("Modificar nombre");
        System.out.println("Modificar descripcion");
        System.out.println("Modificar codigo");
        
        Scanner scan = new Scanner(System.in);
        
        int opcion = scan.nextInt();
        
        switch (opcion) {
            
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                String nombre = scan.next();
                producto.setNombre(nombre);
                break;
            case 2:
                System.out.println("Ingrese el nuevo nombre");
                double precio = scan.nextDouble();
                producto.setPrecio(precio);
                break;
            case 3:
                System.out.println("Ingrese el nuevo nombre");
                int codigo = scan.nextInt();
                producto.setCodigo(codigo);
                break;
        }
        
        return productoDAOImp.actualizarProducto();
    }
}
