package base.pedido.control;

import base.empleado.dominio.Empleado;
import base.pedido.dominio.Pedido;
import base.pedido.persistencia.PedidoDAOImp;
import base.pedido.vista.VistaPedido;
import base.producto.dominio.Producto;
import base.producto.persistencia.ProductoDAOImp;
import java.util.List;
import java.util.Scanner;

public class ControladorPedido {

    private Pedido pedido;
    private ProductoDAOImp productoDAOImp;

    public ControladorPedido() {

        this.productoDAOImp = new ProductoDAOImp();
    }

    public void generarPedido(Empleado empleado) {
        this.pedido = new Pedido(empleado.getNombre());
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        boolean pedidoTerminado = false;
        int numeroProductos;
        System.out.println("¿Cuantos productos desea comprar?\n");
        numeroProductos = scan.nextInt();

        do {
            System.out.println("--------Menu pedido---------------------\n");
            VistaPedido.menuPedido();
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    if (numeroProductos > 0) {
                        List<Producto> productos = productoDAOImp.leerProductos();
                        for (Producto producto : productos) {
                            System.out.println(producto);
                        }
                        System.out.println("");
                        System.out.println("¿Que producto desea añadir?");
                        int codigoProducto = scan.nextInt();
                        Producto producto = productoDAOImp.getProductoPorCodigo(codigoProducto);
                        pedido.agregarProducto(producto);
                        numeroProductos--;
                        System.out.println("Se ha añadido exitosamente\n");
                    } else {
                        System.out.println("No puedes agregar mas productos\n");
                    }
                    break;
                case 2:
                    System.out.println("2. Visualizar precio total de la cesta");
                    System.out.println("Precio :" + pedido.getPrecioTotal());
                    break;
                case 3:
                    System.out.println("3. Imprimir factura\n");
                    new PedidoDAOImp().actualizarPedido(pedido);
                    System.out.println("Factura simplificada: ");
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("");
                    for (Producto producto : pedido.getProductos()) {

                        System.out.println("codigo: \t" + producto.getCodigo());
                        System.out.println("nombre: \t" + producto.getNombre());
                        System.out.println("descripcion: \t" + producto.getDescripcion());
                        System.out.println("precio: \t" + producto.getPrecio() + "\n");

                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("El precio total es: " + pedido.getPrecioTotal());
                    System.out.println("Atendido por: " + pedido.getNombreEmpleado());
                    System.out.println("");
                    ;
                    break;
                case 4:
                    System.out.println("4. Terminar pedido");
                    System.out.println("---------------------------------------");
                    pedidoTerminado = true;
                    break;
            }
        } while (pedidoTerminado == false);
    }
}
