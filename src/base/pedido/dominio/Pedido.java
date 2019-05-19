package base.pedido.dominio;

import base.producto.dominio.Producto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos ;
    private double precioTotal;
    private  String nombreEmpleado;

    public Pedido(String nombreEmpleado) {
        this.productos = new ArrayList<>();
        this.precioTotal = 0;
        this.nombreEmpleado = nombreEmpleado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
}
