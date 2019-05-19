
package base.tienda.control;

import base.empleado.control.EmpleadoControlador;
import base.producto.control.ControladorProducto;
import java.util.Scanner;


public class ControladorTienda {
    
    private EmpleadoControlador empleadoContorlador;
    private ControladorProducto productoControlador;

    public ControladorTienda() {
        this.empleadoContorlador = new EmpleadoControlador();
        this.productoControlador = new ControladorProducto();
    }
    
    
    public void start(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenidos a la tienda");
        while (true) {            
         //login
            empleadoContorlador.login();
            // imprimir menu
            System.out.println("-----Menu principal-------");
            System.out.println("1. Hacer pedido");
            System.out.println("2. Modificar un producto");
            System.out.println("3. Cambiar contraseña");
            System.out.println("4. Cerrar sesion");
            System.out.println("--------------------------");
            direccion(scan.nextInt());
        }
    }
    
    private void direccion(int opcion){
    
    switch(opcion){
        case 1: System.out.println("opcion 1");
        break;
        case 2: System.out.println("opcion 2");
        productoControlador.modificarProducto();
        break;
        case 3: System.out.println("opcion 3");
        empleadoContorlador.modificarContraseña();
        break;
        case 4: System.out.println("opcion 4");
        empleadoContorlador.cerrarSession();
        break;
        
    }
    }
}
