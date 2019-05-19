package base.empleado.persistencia;

import base.empleado.dominio.Empleado;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmpleadoDAOImp implements EmpleadoDAO {

    @Override
    public List<Empleado> leerEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        NumberFormat formatoNumero = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        Number numero;
        String lineaConDatos;
        String archivosEmpleados = "empleados.txt";
        System.out.println("");
        try ( var archivo = Files.newBufferedReader(Paths.get(archivosEmpleados))) {
            while (archivo.readLine() != null) {

                //codigo
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineaConDatos);
                int codigo = numero.intValue();

                //nombre
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                String nombre = lineaConDatos;

                //apellido
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                String apellido = lineaConDatos;

                //contraseña
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                String password = lineaConDatos;

                empleados.add(new Empleado(codigo, nombre, apellido, password));

            }
        } catch (ParseException e) {
            System.out.println("Error de formato de numero");

        } catch (IOException e) {
            System.out.println("Error de formato de Archivo");
        }

        return empleados;

    }
    
     @Override
    public Empleado getEmpleadoPorCodigo(int codigo) {
        List<Empleado>empleados = leerEmpleado();
        for (Empleado empleado : empleados) {
            if (codigo == empleado.getCodigo()){
                return empleado;
            }

        }
        return null;
    }

    @Override
    public boolean actualizarEmpleados(List<Empleado> empleados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
