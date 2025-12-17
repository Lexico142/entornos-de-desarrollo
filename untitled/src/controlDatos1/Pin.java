package controlDatos1;

import java.util.Scanner;

public class Pin {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Crea tu nuevo PIN (4 dígitos):");
            String texto = src.next();

            if (texto.length() == 4) {

                boolean sonNumeros = true;
                for (int i = 0; i < texto.length(); i++) {
                    if (!Character.isDigit(texto.charAt(i))) {
                        sonNumeros = false;
                    }
                }

                if (sonNumeros) {
                    System.out.println("Escribelo otra vez para confirmar:");
                    String confirmacion = src.next();

                    if (texto.equals(confirmacion)) {
                        System.out.println("¡PIN Creado correctamente!");
                        salir = true;
                    } else {
                        System.out.println("Error: Los numeros no son iguales.");
                    }
                } else {
                    System.out.println("Error: Tienen que ser numeros, no letras.");
                }

            } else {
                System.out.println("Error: Tienen que ser 4 digitos exactos.");
            }
        }
    }
}