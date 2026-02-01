package PracticaTryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Calculadora ===");

        try {
            // Pedimos los dos números primero
            System.out.print("Introduce el primer número entero: ");
            int numero1 = sc.nextInt();

            System.out.print("Introduce el segundo número entero: ");
            int numero2 = sc.nextInt();

            // Mostramos el menú de operaciones
            System.out.println("\nQué quieres hacer?");
            System.out.println("1. Sumar (+)");
            System.out.println("2. Restar (-)");
            System.out.println("3. Multiplicar (*)");
            System.out.println("4. Dividir (/)");
            System.out.print("Elige una opción: ");

            int operacion = sc.nextInt();
            int resultado = 0;

            // Hacemos la operación según lo elegido
            switch (operacion) {
                case 1: // Suma
                    resultado = numero1 + numero2;
                    System.out.println("Resultado: " + numero1 + " + " + numero2 + " = " + resultado);
                    break;
                case 2: // Resta
                    resultado = numero1 - numero2;
                    System.out.println("Resultado: " + numero1 + " - " + numero2 + " = " + resultado);
                    break;
                case 3: // Multiplicación
                    resultado = numero1 * numero2;
                    System.out.println("Resultado: " + numero1 + " * " + numero2 + " = " + resultado);
                    break;
                case 4: // División
                    // Aquí es donde puede saltar la ArithmeticException si numero2 es 0
                    resultado = numero1 / numero2;
                    System.out.println("Resultado: " + numero1 + " / " + numero2 + " = " + resultado);
                    break;
                default:
                    System.out.println("Error: La opción elegida no existe.");
            }

        } catch (InputMismatchException e) {
            // Salta si escribes letras en los números o en el menú
            System.out.println("ERROR: Has escrito texto en lugar de un número entero.");

        } catch (ArithmeticException e) {
            // Salta al dividir por cero en la opción 4
            System.out.println("ERROR: No se puede dividir por cero.");

        } catch (Exception e) {
            // Por si pasa cualquier otra cosa
            System.out.println("Ha ocurrido un error inesperado.");
        }

        System.out.println("Fin del programa.");
    }
}