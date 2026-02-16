package PracticaUM;

public class Pedido {
    private String fecha;

    private Cliente cliente;
    Producto[] productos;

    public Pedido(String fecha, Cliente cliente, Producto[] productos) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }


}