package base.empleado.persistencia;

import base.empleado.dominio.Empleado;
import java.util.List;

public interface EmpleadoDAO {

    List<Empleado> leerEmpleado();

    Empleado getEmpleadoPorCodigo(int codigo);

    boolean actualizarEmpleados(int codigo, String password);
}
