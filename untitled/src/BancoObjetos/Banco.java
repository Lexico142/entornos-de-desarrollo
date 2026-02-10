package BancoObjetos;

import java.util.InputMismatchException;
import java.util.Scanner;

class Usuario {
    private String nombre;
    private String dni;
    private int edad;
    private double saldo;

    public Usuario(String nombre, String dni, int edad, int saldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.saldo = saldo;

    }
    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
    public int getEdad() {
        return edad;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}

public class Banco {
    static void main(String[] args) {

        Usuario usuario1 = new Usuario("Ana", "12345678A", 30, 67);
        Usuario usuario2 = new Usuario("Luis", "87654321B", 45, 500);

        Scanner src = new Scanner(System.in);

        Usuario usuarioActual = null;

        System.out.println("¿Quién va a operar?");
        System.out.println("1. " + usuario1.getNombre());
        System.out.println("2. " + usuario2.getNombre());
        int seleccion = src.nextInt();

        if (seleccion == 1) {
            usuarioActual = usuario1;
        } else {
            usuarioActual = usuario2;
        }

        System.out.println("Bienvenido/a " + usuarioActual.getNombre());

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Cajero Automático ===");

            System.out.println("Saldo actual: " + usuarioActual.getSaldo() + "€");

            System.out.println("1. Ingresar dinero");
            System.out.println("2. Sacar dinero");
            System.out.println("3. Mostrar datos usuario");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            try {
                int opcion = src.nextInt();

                switch (opcion) {
                    case 1: 
                        System.out.print("¿Cuánto quieres ingresar?: ");
                        double ingreso = src.nextDouble();

                        if (ingreso < 0) {
                            System.out.println("ERROR: No puedes ingresar cantidades negativas.");
                        } else {

                            double nuevoSaldo = usuarioActual.getSaldo() + ingreso;
                            usuarioActual.setSaldo(nuevoSaldo);

                            System.out.println("Ingreso correcto. Nuevo saldo: " + usuarioActual.getSaldo());
                        }
                        break;

                    case 2:
                        System.out.print("¿Cuánto quieres sacar?: ");
                        double retiro = src.nextDouble();

                        if (retiro < 0) {
                            System.out.println("ERROR: No puedes retirar cantidades negativas.");
                        }
                        else if (retiro > usuarioActual.getSaldo()) {
                            System.out.println("ERROR: Saldo insuficiente. Solo tienes " + usuarioActual.getSaldo() + "€.");
                        }
                        else {
                            double nuevoSaldo = usuarioActual.getSaldo() - retiro;
                            usuarioActual.setSaldo(nuevoSaldo);

                            System.out.println("Retirada correcta. Nuevo saldo: " + usuarioActual.getSaldo());
                        }
                        break;
                    case 4:
                        salir = true;
                        System.out.println("Gracias por usar nuestro banco.");
                        break;
                    case 3:
                        System.out.println("=== Datos del usuario ===");
                        System.out.println("Nombre: " + usuarioActual.getNombre());
                        System.out.println("DNI: " + usuarioActual.getDni());
                        System.out.println("Edad: " + usuarioActual.getEdad());
                        System.out.println("Saldo: " + usuarioActual.getSaldo() + "€");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes introducir un número.");
                src.nextLine();
            }
        }
    }
}
