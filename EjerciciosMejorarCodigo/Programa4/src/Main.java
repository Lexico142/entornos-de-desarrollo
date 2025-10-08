/*
 * Player's Journey
 * --------------------------
 * Este es un juego de aventura con puntos de vida, defensa y experiencia.
 * Se puede atacar, curarte, explorar o salir del juego.
 * El juego termina si tu vida llega a 0 o si se elige salir.
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Entrada de usuario y generador de números aleatorios
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Variables principales del jugador
        int vida = 30;            // Vida actual
        int vidaMaxima = 30;      // Vida máxima
        int defensa = 5;          // Nivel de defensa
        int experiencia = 0;      // Puntos de experiencia acumulados
        boolean jugando = true;   // Controla si el juego sigue activo

        // Instrucciones iniciales
        System.out.println("=== Player's Journey ===");
        System.out.println("Empiezas con " + vida + " de vida y " + defensa + " de defensa.");
        System.out.println("Acciones disponibles:");
        System.out.println("1 - Atacar a un enemigo");
        System.out.println("2 - Curarte (+10 de vida)");
        System.out.println("3 - Recuperar toda la vida");
        System.out.println("4 - Explorar el mundo");
        System.out.println("0 - Salir del juego");

        // Bucle principal del juego
        while (jugando) {
            System.out.print("\nElige una acción (0-4): ");
            int opcion = scanner.nextInt(); // acción del jugador

            // Salir del juego
            if (opcion == 0) {
                System.out.println("Has salido del juego. ¡Hasta pronto!");
                break;
            }

            // Atacar
            if (opcion == 1) {
                int danoRecibido = 3 + random.nextInt(5); // daño aleatorio
                int expGanada = 5 + random.nextInt(7);    // experiencia ganada

                // Cambios en los valores de vida y experiencia
                vida -= danoRecibido;
                experiencia += expGanada;

                // Print de la información de lo hecho por el jugador
                System.out.println("Atacaste y recibiste " + danoRecibido + " de daño.");
                System.out.println("Ganaste " + expGanada + " puntos de experiencia.");

                // Reintroducción de las opciones
                System.out.println("\nAcciones disponibles:");
                System.out.println("1 - Atacar a un enemigo");
                System.out.println("2 - Curarte (+10 de vida)");
                System.out.println("3 - Recuperar toda la vida");
                System.out.println("4 - Explorar el mundo");
                System.out.println("0 - Salir del juego");

                // Cada cierto rango de experiencia, aumenta la defensa
                if (experiencia >= 50 && experiencia % 50 < 10) {
                    defensa += 2;

                    //Reintroducción de las opciones
                    System.out.println("¡Tu defensa aumentó! Defensa actual: " + defensa);
                    System.out.println("\nAcciones disponibles:");
                    System.out.println("1 - Atacar a un enemigo");
                    System.out.println("2 - Curarte (+10 de vida)");
                    System.out.println("3 - Recuperar toda la vida");
                    System.out.println("4 - Explorar el mundo");
                    System.out.println("0 - Salir del juego");

                }
            }

            // Curarse parcialmente
            if (opcion == 2) {
                vida += 10;
                if (vida > vidaMaxima) vida = vidaMaxima;

                // Print de la información de lo hecho por el jugador
                System.out.println("Te curaste un poco. Vida actual: " + vida + "/" + vidaMaxima);

                // Reintroducción de las acciones
                System.out.println("\nAcciones disponibles:");
                System.out.println("1 - Atacar a un enemigo");
                System.out.println("2 - Curarte (+10 de vida)");
                System.out.println("3 - Recuperar toda la vida");
                System.out.println("4 - Explorar el mundo");
                System.out.println("0 - Salir del juego");

            }

            // Curarse completamente
            if (opcion == 3) {
                vida = vidaMaxima;
                // Print de información de lo hecho por el jugador
                System.out.println("Has recuperado toda tu vida (" + vida + ").");

                // Reintroducción de las opciones
                System.out.println("\nAcciones disponibles:");
                System.out.println("1 - Atacar a un enemigo");
                System.out.println("2 - Curarte (+10 de vida)");
                System.out.println("3 - Recuperar toda la vida");
                System.out.println("4 - Explorar el mundo");
                System.out.println("0 - Salir del juego");

            }

            // Explorar
            if (opcion == 4) {
                int expExploracion = 5 + random.nextInt(7); // experiencia ganada
                experiencia += expExploracion; // Cambio en el valor de la experiencia según exp ganada
                defensa += experiencia / 100; // mejora ligera según experiencia total

                // Prints de información de lo hecho por el jugador
                System.out.println("Exploraste el mundo y ganaste " + expExploracion + " de experiencia.");
                System.out.println("Experiencia total: " + experiencia + " | Defensa actual: " + defensa);

                //Reintroducción de las opciones
                System.out.println("\nAcciones disponibles:");
                System.out.println("1 - Atacar a un enemigo");
                System.out.println("2 - Curarte (+10 de vida)");
                System.out.println("3 - Recuperar toda la vida");
                System.out.println("4 - Explorar el mundo");
                System.out.println("0 - Salir del juego");

            }

            // Si la vida llega a 0, el jugador muere
            if (vida <= 0) {
                System.out.println("\nTu vida llegó a 0... Has muerto");
                jugando = false;
                System.out.println("¡Se acabó! Acabaste con: -> vida: " + vida + "/" + vidaMaxima +
                        " | Defensa: " + defensa + " | Experiencia: " + experiencia);
            } else {
                // Mostrar el estado actual del jugador
                System.out.println("Estado actual -> vida: 0" + "/" + vidaMaxima +
                        " | Defensa: " + defensa + " | Experiencia: " + experiencia);
            }
        }

        // Print final de finalización de juego
        System.out.println("Juego terminado.");
    }
}
