package PracticaMetodos;

import java.util.Scanner;
import java.util.InputMismatchException;

public class corredor {
    // Scanner único
    public static Scanner sc = new Scanner(System.in);

    // Variables de estado del juego
    public static int pos = 16; // Empezamos últimos (ej. 16 corredores)
    public static int estres = 0; // Estrés actual (0-100)
    public static int turno = 0; // Turno actual
    public static boolean chocado = false; // Bandera para saber si ha habido accidente

    // Contadores para estadísticas
    public static int contPaciente = 0;
    public static int contAgresivo = 0;
    public static int contTemerario = 0;

    // Método principal
    public static void main(String[] args) throws InterruptedException {
        // Variable para controlar el menú principal
        boolean bucleInicial = true;
        boolean salir = false;

        System.out.println("==========================================");
        System.out.println("==== Bienvenido/a al Simulador de Carreras ===");
        System.out.println("==========================================\n");

        // Bucle del programa (se repite hasta que el usuario elija Salir)
        while (!salir) {
            bucleInicial = true; // Reiniciamos el menú para la siguiente vuelta

            while (bucleInicial) {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Empezar Carrera");
                System.out.println("2. Tutorial");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");

                try {
                    int opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            bucleInicial = false; // Salimos del menú
                            reiniciarJuego(); // Reiniciamos variables
                            juego(); // Entramos al juego
                            break;
                        case 2:
                            tutorial(); // Mostramos instrucciones
                            break;
                        case 3:
                            System.out.println("Saliendo del programa...");
                            Thread.sleep(500);
                            bucleInicial = false;
                            salir = true; // Rompemos el bucle principal
                            break;
                        default:
                            System.out.println("Por favor, elige 1, 2 o 3.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    sc.next(); // Limpiar el buffer si meten letras
                    System.out.println("Debes introducir un número (1, 2 o 3).");
                }
            }
        }

        sc.close();
        System.out.println("¡Hasta pronto!");
    }

    // Método para reiniciar las variables del juego
    static void reiniciarJuego() {
        pos = 16;
        estres = 0;
        turno = 0;
        chocado = false;
        contPaciente = 0;
        contAgresivo = 0;
        contTemerario = 0;
    }

    // Lógica de la carrera
    static void juego() throws InterruptedException {
        // Bucle de los 20 turnos
        for (int i = 1; i <= 20; i++) {
            // Si chocó en el turno anterior, paramos el bucle inmediatamente
            if (chocado) break;

            turno = i;
            // Limite de seguridad para el estrés visual
            if (estres > 100) estres = 100;

            // Información del turno
            System.out.println("\n---------------- TURNO " + turno + " / 20 ----------------");
            System.out.println("Posición actual: " + pos + " | Estrés: " + estres + "/100");

            // Aviso de peligro
            if (estres > 80) System.out.println("Cuidado! Estrés alto, peligro de choque");

            System.out.println("¿Qué orden das?");
            System.out.println("1- Ser paciente");
            System.out.println("2- Ser agresivo");
            System.out.println("3- Ser temerario");
            System.out.print("Tu elección: ");

            int opc = leerOpcion();

            // Ejecutar la acción seleccionada
            switch (opc) {
                case 1:
                    contPaciente++; // Sumamos al contador
                    paciente();
                    break;
                case 2:
                    contAgresivo++; // Sumamos al contador
                    agresivo();
                    break;
                case 3:
                    contTemerario++; // Sumamos al contador
                    temerario();
                    break;
            }

            // Pausa entre turnos
            Thread.sleep(800);
        }

        // Al terminar el bucle (o chocar), llamamos al final
        finalJuego();
    }

    // Método para leer opción con manejo de errores
    static int leerOpcion() {
        int opc = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opc = sc.nextInt();

                if (opc >= 1 && opc <= 3) {
                    entradaValida = true;
                } else {
                    System.out.print("Opción fuera de rango. Introduce 1, 2 o 3: ");
                }
            } catch (InputMismatchException e) {
                sc.next(); // Limpiar el buffer
                System.out.print("Debes introducir un número (1, 2 o 3): ");
            }
        }

        return opc;
    }

    // Funciones de comportamiento

    static void agresivo() {
        checkChocar(); // Comprobamos riesgo antes de actuar
        if (chocado) return;

        // Lógica Math.random para AGRESIVO
        int nuevoEstres = (int) (Math.random() * 20) + 1;
        estres += nuevoEstres;

        int puestosGanados = (int) ((Math.random() * 2) + 1);
        pos -= puestosGanados;
        if (pos < 1) pos = 1; // No se puede ir mejor que 1º

        System.out.println("- Modo AGRESIVO: Aprietas el ritmo.");
        System.out.println("Estrés sube: +" + nuevoEstres);
        System.out.println("Has ganado " + puestosGanados + " puestos.");
    }

    static void temerario() {
        checkChocar(); // Comprobamos riesgo antes de actuar
        if (chocado) return;

        // Lógica Math.random para temerario
        int nuevoEstres = (int) (Math.random() * (40 - 20 + 1)) + 15;
        estres += nuevoEstres;

        int puestosGanados = (int) (Math.random() * (5 - 2 + 1)) + 1;
        pos -= puestosGanados;
        if (pos < 1) pos = 1;

        System.out.println("- Modo TEMERARIO: ¡Vas al límite!");
        System.out.println("Estrés se dispara: +" + nuevoEstres);
        System.out.println("Has ganado " + puestosGanados + " puestos.");
    }

    static void paciente() {
        // Lógica Math.random para paciente
        int recuperacion = (int) (Math.random() * (30 - 10 + 1)) + 10;
        estres -= recuperacion;
        if (estres < 0) estres = 0; // El estrés no baja de 0

        // Probabilidad de perder puesto
        int pierdePuesto = (int) (Math.random() * 2) + 1;
        int puestosPerdidos = 0;

        if (pierdePuesto == 1) { // 50% de probabilidad
            puestosPerdidos = (int) (Math.random() * 3);
            pos += puestosPerdidos;
        }

        System.out.println("- Modo PACIENTE: Te relajas.");
        System.out.println("Estrés baja: -" + recuperacion);
        System.out.println("Has perdido " + puestosPerdidos + " puestos.");
    }

    // Tutorial
    static void tutorial() {
        System.out.println("\n=== TUTORIAL ===");
        System.out.println("Eres el ingeniero y diriges a tu corredor.");
        System.out.println("- PACIENTE: Baja estrés, riesgo de perder posición.");
        System.out.println("- AGRESIVO: Sube algo de estrés, ganas posición moderada.");
        System.out.println("- TEMERARIO: Sube mucho estrés, ganas mucha posición.");
        System.out.println("\n* Si el estrés supera 80, puedes CHOCAR.");
        System.out.println("* Ganas si acabas en buena posición tras 20 turnos.\n");
    }

    static void checkChocar() {
        if (estres > 80) {
            int probabilidad = (int) (Math.random() * 10);
            // 30% de probabilidad de chocar (0, 1, 2)
            if (probabilidad < 3) {
                chocado = true;
                System.out.println("\nTu corredor ha perdido el control por el estrés.");
            } else {
                System.out.println("\nPELIGRO! El corredor está muy estresado, casi choca...");
            }
        }
    }

    // Pantalla final
    static void finalJuego() {
        System.out.println("\n==========================================");
        System.out.println("             FIN DE LA CARRERA            ");
        System.out.println("==========================================");

        // Verificar si chocó
        if (chocado) {
            System.out.println("Resultado: DNF (Did Not Finish).");
            System.out.println("Tu corredor ha chocado en el turno " + turno + ".");
            System.out.println("Consejo: Vigila el estrés la próxima vez.");
        } else {
            // Verificar posición final
            System.out.println("Posición final: " + pos);

            if (pos == 1) {
                System.out.println("HAS GANADO LA CARRERA!");
                System.out.println("Eres el mejor ingeniero del mundo.");
            } else if (pos <= 3) {
                System.out.println("PODIO!");
                System.out.println("Una carrera fantástica.");
            } else if (pos <= 10) {
                System.out.println("Has entrado en los puntos.");
                System.out.println("No está mal, pero podemos mejorar.");
            } else {
                System.out.println("Resultado decepcionante...");
                System.out.println("Has quedado en la cola del pelotón.");
            }
        }

        // Mostrar estadísticas de uso
        System.out.println("\n--- ESTADÍSTICAS DE ESTRATEGIA ---");
        System.out.println("Veces Paciente:  " + contPaciente);
        System.out.println("Veces Agresivo:  " + contAgresivo);
        System.out.println("Veces Temerario: " + contTemerario);
        System.out.println("==========================================\n");
    }
}