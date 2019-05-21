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
            System.out.println("");
            System.out.println("¿Que producto desea modificar?");
            int codigo = scan.nextInt();
            Producto producto = productoDAOImp.getProductoPorCodigo(codigo);
            if (producto != null) {
                datosCorrectos = modificarAtributo(producto);
            } else {
                System.out.println("El producto no existe");
            }
        } while (!datosCorrectos);

    }

    private boolean modificarAtributo(Producto producto) {
        System.out.println("1.\tModificar nombre");
        System.out.println("2.\tModificar descripcion");
        System.out.println("3.\tModificar codigo");

        Scanner scan = new Scanner(System.in);

        int opcion = scan.nextInt();

        switch (opcion) {

            case 1:
                System.out.println("Ingrese el nuevo nombre");
                String nombre = scan.next();
                producto.setNombre(nombre);
                break;
            case 2:
                System.out.println("Ingrese el nuevo precio");
                double precio = scan.nextDouble();
                producto.setPrecio(precio);
                break;
            case 3:
                System.out.println("Ingrese el nuevo codigo");
                int codigo = scan.nextInt();
                producto.setCodigo(codigo);
                break;
        }

        return productoDAOImp.actualizarProducto();
    }

}
