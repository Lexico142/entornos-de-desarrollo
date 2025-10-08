import java.util.Scanner;

/**
 * Juego de gestión de recursos. Dependiendo de la jugada
 * que se haga, se ganarán puntos. Se dispone de una
 * cantidad limitada de dinero, el cual es necesario para las jugadas.
 */
public class Main {
    public static void main(String[] args) {

        // Creación del lector de entrada
        Scanner scanner = new Scanner(System.in);

        // Variables del programa
        int dinero = 50;      // Valor inicial del dinero
        int puntos = 0;       // Puntos que aumentan con cada operación
        int jugadaTipo1 = 0;  // Contador de la acción 1
        int jugadaTipo2 = 0;  // Contador de la acción 2
        int jugadaTipo3 = 0;  // Contador de la acción 3
        boolean continuar = true;    // Control del bucle principal

        // Explicación del juego
        System.out.println("Bienvenido/a a este juego de gestión de recursos. Tu objetivo es conseguir la mayor cantidad de puntos con el dinero dado.");
        // Bucle principal
        while (continuar) {
            // Mostrar menú de opciones
            System.out.println("\nSeleccione una opción:");
            System.out.println("1 - Ejecutar jugada tipo 1 (-10 dinero, +5 puntos)");
            System.out.println("2 - Ejecutar jugada tipo 2 (-7 dinero, +3 puntos)");
            System.out.println("3 - Ejecutar jugada tipo 3 (-20 dinero, +10 puntos");
            System.out.println("4 - Mostrar valores actuales");
            System.out.println("5 - Finalizar ejecución");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();

            // Evaluación de las opciones
            if (opcion == 1) {
                if (dinero >= 10) {
                    dinero -= 10;
                    puntos += 5;
                    jugadaTipo1++;
                    System.out.println("Has gastado 10 de dinero y has ganado 5 puntos.");
                } else {
                    System.out.println("No hay suficiente dinero para realizar esta operación.");
                }

            } else if (opcion == 2) {
                if (dinero >= 7) {
                    dinero -= 7;
                    puntos += 3;
                    jugadaTipo2++;
                    System.out.println("Has gastado 7 de dinero y has ganado 5 puntos.");

                } else {
                    System.out.println("No hay suficiente dinero para realizar esta operación.");
                }

            } else if (opcion == 3) {
                if (dinero >= 20) {
                    dinero -= 20;
                    puntos += 10;
                    jugadaTipo3++;
                    System.out.println("Has gastado 20 de dinero y has ganado 5 puntos.");
                } else {
                    System.out.println("No hay suficiente dinero para realizar esta operación.");
                }

            } else if (opcion == 4) {
                // Mostrar el estado actual de todas las variables
                System.out.println("\nEstado actual:");
                System.out.println("Dinero: " + dinero);
                System.out.println("Puntos: " + puntos);
                System.out.println("Jugadas tipo 1 realizadas: " + jugadaTipo1);
                System.out.println("Jugadas tipo 2 realizadas: " + jugadaTipo2);
                System.out.println("Jugadas tipo 3 realizadas: " + jugadaTipo3);

            } else if (opcion == 5) {
                // Finalizar el programa

                continuar = false;
                System.out.println("\nResultados:");
                System.out.println("Dinero: " + dinero);
                System.out.println("Puntos: " + puntos);
                System.out.println("Jugadas tipo 1 realizadas: " + jugadaTipo1);
                System.out.println("Jugadas tipo 2 realizadas: " + jugadaTipo2);
                System.out.println("Jugadas tipo 3 realizadas: " + jugadaTipo3);
                System.out.println("Ejecución finalizada.");


            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }

            // Verificar si el dinero es negativo o 0
            if (dinero <= 0) {
                System.out.println("El dinero se ha agotado. Fin de la ejecución.");
                System.out.println("\nResultados:");
                System.out.println("Dinero: " + dinero);
                System.out.println("Puntos: " + puntos);
                System.out.println("Jugadas tipo 1 realizadas: " + jugadaTipo1);
                System.out.println("Jugadas tipo 2 realizadas: " + jugadaTipo2);
                System.out.println("Jugadas tipo 3 realizadas: " + jugadaTipo3);
                System.out.println("Ejecución finalizada.");
                continuar = false;
            }
        }

        // Cierre del Scanner
        scanner.close();
    }
}
