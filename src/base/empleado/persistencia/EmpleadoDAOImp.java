package base.empleado.persistencia;

import base.conexion.ConexionBD;
import base.empleado.dominio.Empleado;
import base.excepciones.CodigoError_Enum;
import base.excepciones.NombreArchivoIncorrectoExeption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImp implements EmpleadoDAO {

    private List<Empleado> empleados;

    public EmpleadoDAOImp() {
        empleados = new ArrayList();
    }

    @Override
    public List<Empleado> leerEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM empleados");

            while (resultado.next()) {
                var codigo = resultado.getInt("e_codigo");
                var nombre = resultado.getString("e_nombre");
                var apellidos = resultado.getString("e_apellidos");
                var contraseña = resultado.getString("e_contraseña");

                empleados.add(new Empleado(codigo, nombre, apellidos, contraseña));
            }

            // cerrar conexion
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al leer los empleados en la base de datos");
            System.exit(1);
        }
        this.empleados = empleados;
        return empleados;

    }

    @Override
    public Empleado getEmpleadoPorCodigo(int codigo) {
               Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        try {
            conexion = ConexionBD.conectar();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM empleados WHERE e_codigo = "+codigo);

                resultado.next();
                int codig = resultado.getInt("e_codigo");
                String nombre = resultado.getString("e_nombre");
                String apellido = resultado.getString("e_apellidos");
                String password = resultado.getString("e_password");


            resultado.close();
            sentencia.close();
            conexion.close();
               
               return new Empleado(codigo,nombre,apellido,password);
        } catch (Exception e) {
            System.out.println("Error al leer los empleados....");
            System.out.println(e.getMessage());
        }
        throw new NombreArchivoIncorrectoExeption(CodigoError_Enum.ERROR_USUARIO_NO_ENCONTRADO);
    }

    @Override
    public boolean actualizarEmpleados(int codigo, String password) {

        String query = "UPDATE  empleados SET e_password = " + codigo + " WHERE  = " + password;
        try ( Connection conexion = ConexionBD.conectar();  Statement setencia = conexion.createStatement()) {
            return setencia.executeUpdate(query) == 1;
        } catch (SQLException e) {
            return false;
        }

    }

}
