import java.util.Scanner;

public class Fechas {

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        boolean fechaOk = false;

        while (!fechaOk) {
            System.out.println("Introduce fecha todo junto (ej: 26112025):");
            String entrada = src.next();

            if (entrada.length() == 8) {

                boolean esNumero = true;
                for (int i = 0; i < 8; i++) {
                    if (!Character.isDigit(entrada.charAt(i))) {
                        esNumero = false;
                    }
                }

                if (esNumero) {
                    String sDia = entrada.substring(0, 2);
                    String sMes = entrada.substring(2, 4);
                    String sAnio = entrada.substring(4, 8);

                    int dia = Integer.parseInt(sDia);
                    int mes = Integer.parseInt(sMes);
                    int anio = Integer.parseInt(sAnio);

                    if (anio >= 1900 && anio <= 2100) {

                        if (mes >= 1 && mes <= 12) {

                            int maxDias = 31;
                            switch (mes) {
                                case 4: case 6: case 9: case 11:
                                    maxDias = 30;
                                    break;
                                case 2:
                                    maxDias = 28;
                                    break;
                            }

                            if (dia > 0 && dia <= maxDias) {
                                System.out.println("-------------------------");
                                System.out.println("Fecha Válida: " + dia + "/" + mes + "/" + anio);
                                System.out.println("-------------------------");
                                fechaOk = true;
                            } else {
                                System.out.println("Error: Ese dia no vale para ese mes.");
                            }

                        } else {
                            System.out.println("Error: El mes esta mal (1-12).");
                        }
                    } else {
                        System.out.println("Error: El año esta fuera de rango.");
                    }

                } else {
                    System.out.println("Error: Solo puedes poner numeros.");
                }

            } else {
                System.out.println("Error: Faltan o sobran numeros (tienen que ser 8).");
            }
        }
    }
}