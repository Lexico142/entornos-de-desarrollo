package practicaDocGrafos;

import java.util.Scanner;

/**
 * Clase para la gestion de acceso de usuarios al Campus Digitech
 * @see java.util.Scanner
 */
public class practicaDocGrafos {
    public static Scanner src = new Scanner(System.in);
    public static String[] usuarios = {"Lexico","cargol.","hide.afk","agente.bcn","sindsiefertig","admin"};
    public static String[] contrasena = {"lexico123","67","696969","donpollo","no","123"};
    public static String nombreUsuario = "";
    public static String contrasenaUsuario = "";

    /**
     * Metodo de entrada que arranca la aplicacion.
     */
    static void main(String[] args) {
        while (true) {
            menu();
            if (validacion()) {
                menuPrincipal();
            }
        }
    }

    /**
     * Compara las credenciales ingresadas ({@code nombreUsuario} y {@code contrasenaUsuario})
     * con los registros almacenados en los arrays del sistema.
     * @return {@code true} si las credenciales coinciden con algún usuario registrado;
     * {@code false} en caso contrario.
     */
    private static boolean validacion() {
        for (int i = 0; i < usuarios.length; i++) {
            if (nombreUsuario.equals(usuarios[i]) && contrasenaUsuario.equals(contrasena[i])) {
                System.out.println("Acceso concedido");
                return true;
            }
        }
        System.out.println("Nombre de usuario o contraseña incorrecta, vuelve a intentarlo.\n");
        return false;
    }

    /**
     * Muestra el formulario de login por consola.
     * Solicita al usuario que introduzca su nombre y contraseña y actualiza las
     * variables globales {@code nombreUsuario} y {@code contrasenaUsuario}.
     */
    static void menu(){
        System.out.println("==== Campus Digitech ====");
        System.out.print("Por favor introduzca su nombre de usuario: ");
        nombreUsuario = src.nextLine();
        System.out.print("Por favor introduzca su contraseña: ");
        contrasenaUsuario = src.nextLine();
        System.out.println();
    }

    /**
     * Muestra las opciones disponibles tras el login.
     * Permite navegar entre tareas, cerrar sesion o salir.
     */
    static void menuPrincipal(){
        while (true) {
            System.out.println("==== Bienvenido, " + nombreUsuario + " ====");
            System.out.println("1. Ver tareas pendientes (WIP)");
            System.out.println("2. Entregar tareas pendientes (WIP)");
            System.out.println("3. Volver a la pantalla de registro");
            System.out.println("4. Salir del programa");

            int opc = src.nextInt();
            src.nextLine();

            if (opc == 3) {
                nombreUsuario = "";
                contrasenaUsuario = "";
                break;
            } else if (opc == 4) {
                System.out.println("Hasta pronto!");
                System.exit(0);
            } else {
                System.out.println("Estamos trabajando en ello!\n");
            }
        }
    }
}