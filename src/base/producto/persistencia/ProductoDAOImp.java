package base.producto.persistencia;

import base.conexion.ConexionBD;
import base.producto.dominio.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImp implements ProductoDAO {

    private List<Producto> productos;

    public ProductoDAOImp() {
        this.productos = new ArrayList<>();
    }

    @Override
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM productos");

            // capturar resultados
            while (resultado.next()) {
                var codigo = resultado.getInt("p_codigo");
                var nombre = resultado.getString("p_nombre");
                var descripcion = resultado.getString("p_descripcion");
                var precio = resultado.getDouble("p_precio");

                productos.add(new Producto(codigo, nombre, descripcion, precio));
            }

            // cerrar conexion
            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al leer los productos en la base de datos");
            System.exit(1);
        }

        return productos;

    }

    @Override
    public Producto getProductoPorCodigo(int codigo) {
        Producto producto = null;
        String query = "SELECT * FROM productos WHERE p_codigo = " + codigo;
        try {
            Connection conexion = ConexionBD.conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(query);
            resultado.next();
            var code = resultado.getInt("p_codigo");
            var nombre = resultado.getString("p_nombre");
            var descripcion = resultado.getString("p_descripcion");
            var precio = resultado.getDouble("p_precio");
            producto = new Producto(code, nombre, descripcion, precio);
            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return producto;
    }

    @Override
    public boolean actualizarNombre(int codigo, String nombre) {
        String query = "UPDATE  productos SET p_nombre = " + nombre + " WHERE  p_codigo= " + codigo;
        try ( Connection conexion = ConexionBD.conectar();  Statement sentencia = conexion.createStatement()) {
            return sentencia.executeUpdate(query) == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean actualizarPrecio(int codigo, double precio) {
        String query = "UPDATE  productos SET p_precio = " + precio + " WHERE  p_codigo= " + codigo;
        try ( Connection conexion = ConexionBD.conectar();  Statement sentencia = conexion.createStatement()) {
            return sentencia.executeUpdate(query) == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean actualizarCodigo(int codigo, int nuevoCodigo) {
        String query = "UPDATE  productos SET p_codigo = " + nuevoCodigo + " WHERE  p_codigo= " + codigo;
        try ( Connection conexion = ConexionBD.conectar();  Statement sentencia = conexion.createStatement()) {
            return sentencia.executeUpdate(query) == 1;
        } catch (SQLException e) {
            return false;
        }
    }
}
