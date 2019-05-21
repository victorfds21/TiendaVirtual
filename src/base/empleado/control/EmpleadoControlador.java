package base.empleado.control;

import base.empleado.dominio.Empleado;
import base.empleado.persistencia.EmpleadoDAOImp;
import java.util.Scanner;

public class EmpleadoControlador {

    private Empleado empleado;
    private EmpleadoDAOImp empleadoDAOImp;

    public EmpleadoControlador() {
        this.empleadoDAOImp = new EmpleadoDAOImp();
    }

    public void login() {
        Scanner scan = new Scanner(System.in);
        while (this.empleado == null) {
            System.out.println("Ingrese codigo");
            int codigo = scan.nextInt();
            Empleado empleado = empleadoDAOImp.getEmpleadoPorCodigo(codigo);
            if (empleado != null) {

                System.out.println("Ingrese contraseña");
                String password = scan.next();
                System.out.println("");

                if (empleado.getPassword().equals(password)) {
                    System.out.println(empleado.getNombre() + " inició session\n");
                    this.empleado = empleado;
                } else {
                    System.out.println("Contaseña incorrecta");
                }
            } else {
                System.out.println("Codigo incorrecto");
            }

        }

    }

    public void cerrarSession() {

        empleado = null;
    }

    public void modificarContraseña() {
        Scanner scan = new Scanner(System.in);
        String contraseña;
        System.out.println("Ingrese la nueva contraseña");
        contraseña = scan.next();
        empleado.setPassword(contraseña);
        empleadoDAOImp.actualizarEmpleados();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

}
