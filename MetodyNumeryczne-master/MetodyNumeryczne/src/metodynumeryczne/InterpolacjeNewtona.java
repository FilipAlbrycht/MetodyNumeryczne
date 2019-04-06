package metodynumeryczne;

import java.util.Scanner;
import java.math.*;

public class InterpolacjeNewtona {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj ilosc wezlow: ");
        int n;
        try {
            n = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Zly format");
            return;
        }
        if (n<=0) {
            System.out.println("Podaj ilosc wezlow wieksza od 1");
            return;
        }

        float[] wartosci = new float[n];
        float[] argumenty = new float[n];

        for (int i = 0; i < n; i++) {
            try {
                System.out.print("x" + i + " = ");
                argumenty[i] = scan.nextInt();
                for (int j = 0; j < i; j++) {
                    if (argumenty[j] == argumenty[i]) {
                        System.out.println("Podales 2 takie same wezly");
                        return;
                    }
                }
                System.out.print("f(" + argumenty[i] + ") = ");
                wartosci[i] = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Wartosci i argumenty musza byc typu liczbowego");
                return;
            }
        }

        if (n <= 1) {
            System.out.println("N1 = " + wartosci[0]);
        }

        float b[][] = new float[wartosci.length][wartosci.length + 1];

        for (int i = 0; i < wartosci.length; i++) {
            b[0][i] = wartosci[i];
        }
        int j = 1;
        int length = wartosci.length;
        for (int i = 0;; i++) {
            if (j == wartosci.length - 1) {
                break;
            }

            if (i == wartosci.length - j) {
                j++;
                i = 0;
                b[j][i] = (b[j - 1][i + 1] - b[j - 1][i]) / (argumenty[i + j] - argumenty[i]);
            } else {
                b[j][i] = (b[j - 1][i + 1] - b[j - 1][i]) / (argumenty[i + j] - argumenty[i]);
            }
        }

        System.out.print("N" + (n-1) + " = ");
        for (int i = 0; i < wartosci.length; i++) {
            if (b[i][0] % b[i][0] == 0 && b[i][0] != 0.0) {
                System.out.print(" + " + b[i][0]);
                for (int k = 0; k < i; k++) {
                    if (argumenty[k] >= 0) {
                        System.out.print("(x-" + (argumenty[k]) + ")");
                    } else if (argumenty[k] < 0) {
                        System.out.print("(x+" + (-argumenty[k]) + ")");
                    } else {
                        System.out.print("(x)");
                    }
                }
            }
        }
    }
}
