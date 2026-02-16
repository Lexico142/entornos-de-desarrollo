package PracticaUM;

public class Cliente {
    private String nombre;
    private String email;
    String direccion;

    public Cliente(String nombre, String email, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;

    }
    public void setEmail(String email) {
        this.email = email;
    }

}
