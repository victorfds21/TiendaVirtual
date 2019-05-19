
package base.empleado.persistencia;

import base.empleado.dominio.Empleado;
import java.util.List;


public interface EmpleadoDAO {
    
    List<Empleado> leerEmpleado();
    
    boolean actualizarEmpleados(List<Empleado> empleados);
}
