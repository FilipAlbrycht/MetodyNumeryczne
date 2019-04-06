package metodynumeryczne;

import java.util.Scanner;

public class Kwadratura {
    private static double func(double x) {
        return x*x+3;
    }

    public static void main(String[] args) {
        double xp, xk, dx, calka;
        int n;
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj poczatek przedzialu calkowania");
        xp = scan.nextDouble();

        System.out.println("Podaj koniec przedzialu calkowania");
        xk = scan.nextDouble();

        System.out.println("Podaj dokladnosc calkowania");
        n = scan.nextInt();

        dx = (xk - xp) / (double)n;

        calka = 0;
        for (int i=1; i<n; i++) {
            calka += func(xp + i * dx);
        }
        calka += (func(xp) + func(xk)) / 2;
        calka *= dx;

        System.out.println("Wartość całki wynosi w przyblizeniu " + calka);

    }

}

