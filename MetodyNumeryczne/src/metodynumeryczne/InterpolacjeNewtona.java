package metodynumeryczne;

import java.util.Scanner;

public class InterpolacjeNewtona {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj ilosc wezlow: ");
        int n = scan.nextInt();

        float[] wartosci = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.print("f(" + i + ") = ");
            wartosci[i] = scan.nextInt();
        }

        if (n <= 1) {
            System.out.println("N1 = " + wartosci[0]);
        }

        float b[][] = new float[wartosci.length][wartosci.length + 1];
        int[] x = new int[wartosci.length + 1];

        for (int i = 0; i < wartosci.length; i++) {
            b[0][i] = wartosci[i];
            x[i] = i;
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
                b[j][i] = (b[j - 1][i + 1] - b[j - 1][i]) / (x[i + j] - x[i]);
            } else {
                b[j][i] = (b[j - 1][i + 1] - b[j - 1][i]) / (x[i + j] - x[i]);
            }
        }

        System.out.print("N" + (n-1) + " = " + b[0][0] + " + " + b[1][0] + "x");
        for (int i = 2; i < wartosci.length; i++) {
            System.out.print(" + " + b[i][0]);
                for (int k = 0; k<i; k++) {
                    System.out.print("(x-" + (k) + ")");
                }
        }
    }
}
