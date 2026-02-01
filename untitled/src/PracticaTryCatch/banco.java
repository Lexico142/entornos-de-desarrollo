package PracticaTryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 1000.0;
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Cajero Automático===");
            System.out.println("Saldo actual: " + saldo + "€");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Sacar dinero");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1: // Ingresar
                        System.out.print("¿Cuánto quieres ingresar?: ");
                        double ingreso = sc.nextDouble();

                        // Controlar números negativos
                        if (ingreso < 0) {
                            System.out.println("ERROR: No puedes ingresar cantidades negativas.");
                        } else {
                            saldo = saldo + ingreso;
                            System.out.println("Has ingresado " + ingreso + "€. Nuevo saldo: " + saldo);
                        }
                        break;

                    case 2: // Sacar
                        System.out.print("¿Cuánto quieres sacar?: ");
                        double retiro = sc.nextDouble();

                        // Controlar números negativos
                        if (retiro < 0) {
                            System.out.println("ERROR: No puedes retirar cantidades negativas.");
                        }
                        // Controlar que no saque más de lo que tiene
                        else if (retiro > saldo) {
                            System.out.println("ERROR: Saldo insuficiente. Solo tienes " + saldo + "€.");
                        }
                        else {
                            saldo = saldo - retiro;
                            System.out.println("Has retirado " + retiro + "€. Nuevo saldo: " + saldo);
                        }
                        break;

                    case 3: // Salir
                        salir = true;
                        System.out.println("Gracias por usar nuestro banco.");
                        break;

                    default:
                        System.out.println("Opción no válida. Elige 1, 2 o 3.");
                }

            } catch (InputMismatchException e) {
                // Si el usuario escribe letras en el menú o en la cantidad
                System.out.println("ERROR: Debes introducir un número, no texto.");

                sc.close();
            }
        }
    }
}
