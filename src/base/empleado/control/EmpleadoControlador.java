package base.empleado.control;

import base.empleado.dominio.Empleado;
import base.empleado.persistencia.EmpleadoDAOImp;
import base.exepciones.CodigoError_Enum;
import base.exepciones.NombreArchivoIncorrectoExeption;
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
            try {
                System.out.println("Ingrese codigo");
                int codigo = scan.nextInt();
                Empleado empleado = empleadoDAOImp.getEmpleadoPorCodigo(codigo);

                System.out.println("Ingrese contraseña");
                String password = scan.next();
                System.out.println("");

                if (empleado.getPassword().equals(password)) {
                    System.out.println(empleado.getNombre() + " inició session\n");
                    this.empleado = empleado;
                } else {
                    throw new NombreArchivoIncorrectoExeption(CodigoError_Enum.ERROR_PASSWORD_ERRADO);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
