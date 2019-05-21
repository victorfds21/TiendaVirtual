package base.tienda.control;

import base.empleado.control.EmpleadoControlador;
import base.pedido.control.ControladorPedido;
import base.producto.control.ControladorProducto;
import java.util.Scanner;

public class ControladorTienda {

    private EmpleadoControlador empleadoContorlador;
    private ControladorProducto productoControlador;
    private ControladorPedido controladorPedido;

    public ControladorTienda() {
        this.empleadoContorlador = new EmpleadoControlador();
        this.productoControlador = new ControladorProducto();
        this.controladorPedido = new ControladorPedido();
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("Bienvenidos a la tienda");
        System.out.println("***********************\n");
        while (true) {
            //login
            empleadoContorlador.login();
            // imprimir menu
            System.out.println("-----Menu principal---------------\n");
            System.out.println("  1. \tHacer pedido");
            System.out.println("  2. \tModificar un producto");
            System.out.println("  3. \tCambiar contraseña empleado");
            System.out.println("  4. \tCerrar sesion\n");
            System.out.println("----------------------------------\n");
            direccion(scan.nextInt());
        }
    }

    private void direccion(int opcion) {

        switch (opcion) {
            case 1:

                System.out.println("\tHacer pedido\n");
                controladorPedido.generarPedido(empleadoContorlador.getEmpleado());
                break;
            case 2:
                System.out.println("\tModificar un producto\n");
                productoControlador.modificarProducto();
                break;
            case 3:
                System.out.println(" Cambiar contraseña empleado");
                System.out.println("---------------\n");
                empleadoContorlador.modificarContraseña();
                break;
            case 4:
                System.out.println(" Cerrar sesion");
                System.out.println("---------------\n");
                empleadoContorlador.cerrarSession();
                break;

        }
    }
}
