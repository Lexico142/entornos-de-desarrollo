package PracticaUM;

public class Producto {
    private String nombre;
    private int precio;
    int stock;

    public Producto(int precio, String nombre, int stock) {
        this.precio = precio;
        this.nombre = nombre;
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;

    }
}
