package ahorcado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> diccionario = new ArrayList<>();

    public static void main(String[] args) {
        String rutaArchivo = "es-ES.txt";

        try {
            leerArchivo(rutaArchivo);

            int aleatorio = (int) (Math.random() * diccionario.size());
            String palabra = diccionario.get(aleatorio);

            gameplay(palabra);

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }

    public static void leerArchivo(String rutaArchivo) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
        diccionario.addAll(lineas);
    }

    public static void gameplay(String palabraSecreta) {
        Scanner scanner = new Scanner(System.in);

        palabraSecreta = palabraSecreta.toUpperCase();

        char[] palabraGuiones = new char[palabraSecreta.length()];

        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraGuiones[i] = '_';
        }

        int vidas = 6;
        String letrasUsadas = "";
        boolean haGanado = false;

        System.out.println("¡JUEGO DEL AHORCADO!");

        while (vidas > 0 && !haGanado) {

            System.out.println("\nPalabra: ");
            System.out.println(palabraGuiones);
            System.out.println("Vidas: " + vidas);
            System.out.println("Letras dichas: " + letrasUsadas);

            System.out.print("Pon una letra: ");
            String texto = scanner.next().toUpperCase();
            char letra = texto.charAt(0);

            letrasUsadas = letrasUsadas + letra + " ";

            boolean acierto = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraGuiones[i] = letra;
                    acierto = true;
                }
            }

            if (acierto) {
                System.out.println("¡Bien! La letra está.");
            } else {
                System.out.println("Fallo. Pierdes una vida.");
                vidas = vidas - 1;
            }

            boolean quedanGuiones = false;
            for (int i = 0; i < palabraGuiones.length; i++) {
                if (palabraGuiones[i] == '_') {
                    quedanGuiones = true;
                }
            }

            if (!quedanGuiones) {
                haGanado = true;
            }
        }

        if (haGanado) {
            System.out.println("\n¡GANASTE! La palabra era: " + palabraSecreta);
        } else {
            System.out.println("\nPERDISTE. Te quedaste sin vidas.");
            System.out.println("La palabra era: " + palabraSecreta);
        }
    }
}