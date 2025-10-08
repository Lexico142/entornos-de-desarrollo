import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int x = (int)(Math.random() * 10 + 1);
    int y = 0;
    while (y != x) {
        y = s.nextInt();
        if (y == x)
            System.out.println("i");
        else if (y > x)
            System.out.println("e");
        else
            System.out.println("a");
    }
}}