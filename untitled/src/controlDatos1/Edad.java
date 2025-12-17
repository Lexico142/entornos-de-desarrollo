package controlDatos1;

import java.util.Scanner;

public class Edad {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        int edad = -1;

        while (edad < 0 || edad > 110) {
            System.out.println("Por favor, introduce una edad (entre 0 y 110):");

            if (src.hasNextInt()) {
                edad = src.nextInt();

                if (edad < 0 || edad > 110) {
                    System.out.println("Error: Esa edad no es posible.");
                }
            } else {
                System.out.println("Error: Tienes que poner un numero.");
                src.next();
            }
        }
        System.out.println("edad guardada: " + edad);
    }
}