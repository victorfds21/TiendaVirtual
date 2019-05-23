package base.empleado.control;

import base.empleado.dominio.Empleado;
import base.empleado.persistencia.EmpleadoDAOImp;
import base.excepciones.CodigoError_Enum;
import base.excepciones.NombreArchivoIncorrectoExeption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmpleadoControlador {

    private Empleado empleado;
    private EmpleadoDAOImp empleadoDAOImp;

    public EmpleadoControlador() {
        this.empleadoDAOImp = new EmpleadoDAOImp();
    }

    public void login() {
        Scanner sc = new Scanner(System.in);

        while (this.empleado == null) {
            try {
                System.out.println("Ingrese su codigo:");
                int codigo = sc.nextInt();

                Empleado empleado = empleadoDAOImp.getEmpleadoPorCodigo(codigo);
                if (empleado != null) {
                    System.out.println("Ingrese su Contraseña:");
                    String pass = sc.next();

                    controlarPassword(empleado, pass);

                } else {
                    System.out.println("Codigo incorrecto" );
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo se adminten numeros");
                sc.next();
            } catch (NombreArchivoIncorrectoExeption e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void controlarPassword(Empleado empleado, String pass)throws NombreArchivoIncorrectoExeption {
        if (empleado.getPassword().equals(pass)) {
            System.out.println("");
            System.out.println(empleado.getNombre() + " inició session\n");
            this.empleado = empleado;
        } else {
            throw new NombreArchivoIncorrectoExeption(CodigoError_Enum.ERROR_PASSWORD_ERRADO);
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
        empleadoDAOImp.actualizarEmpleados(empleado.getCodigo(), contraseña);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

}
