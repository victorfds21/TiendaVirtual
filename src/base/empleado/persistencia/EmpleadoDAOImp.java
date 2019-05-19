package base.empleado.persistencia;

import base.empleado.dominio.Empleado;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class EmpleadoDAOImp implements EmpleadoDAO {

    private List<Empleado> empleados;

    public EmpleadoDAOImp() {
        empleados = new ArrayList();
    }

    @Override
    public List<Empleado> leerEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        String lineaConDatos;
        String archivosEmpleados = "empleados.txt";
        System.out.println("");
        try ( var archivo = Files.newBufferedReader(Paths.get(archivosEmpleados))) {
            while (archivo.readLine() != null) {

                //codigo
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                int codigo = Integer.parseInt(lineaConDatos);

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
        } catch (IOException e) {
            System.out.println("Error de formato de Archivo");
        }
        this.empleados = empleados;
        return empleados;

    }

    @Override
    public Empleado getEmpleadoPorCodigo(int codigo) {
        List<Empleado> empleados = leerEmpleado();
        for (Empleado empleado : empleados) {
            if (codigo == empleado.getCodigo()) {
                return empleado;
            }

        }
        return null;
    }

    public boolean actualizarEmpleados() {
        return actualizarEmpleados(this.empleados);
    }

    @Override
    public boolean actualizarEmpleados(List<Empleado> empleados) {
    
        String nombreArchivo = "empleados.txt";
        Path rutaArchivo = Paths.get(nombreArchivo);

        try {
            BufferedWriter writer = Files.newBufferedWriter(rutaArchivo);
            Formatter salida = new Formatter(writer);

            for (Empleado empleado : empleados) {
                salida.format("%s%n%s%n%d%n%s%n%s%n%s%n%s%n%s%n%s%n",
                        "[empleado]", "[codigo]", empleado.getCodigo(),
                        "[nombre]", empleado.getNombre(), "[apellidos]", empleado.getApellido(),
                        "[contraseña]", empleado.getPassword());

            }

            salida.close();
            writer.close();
            return true;

        } catch (IOException e) {
            return false;
        }

    }
    

}
