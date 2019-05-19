
package base.producto.dominio;


public class Producto {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double contraseña;

    public Producto(int codigo, String nombre, String descripcion, double contraseña) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contraseña = contraseña;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getContraseña() {
        return contraseña;
    }

    public void setContraseña(double contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
