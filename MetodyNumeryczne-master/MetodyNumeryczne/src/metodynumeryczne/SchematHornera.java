package metodynumeryczne;

import java.util.Scanner;

public class SchematHornera {
    
    public static int horner(int wsp[],int st, int x)
{
	if(st==0)
		return wsp[0];
	
	return x*horner(wsp,st-1,x)+wsp[st];
}

    public static void main(String[] args) {
        int stopien, argument;
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj stopień wielomianu: ");
        stopien = scan.nextInt();

        int[] wspolczynniki = new int[stopien + 1];

        for (int i = 0; i <= stopien; i++) {
            System.out.println("Podaj współczynnik stojący przy potędze " + (stopien-i) + ": ");
            wspolczynniki[i] = scan.nextInt();
        }
        System.out.println("Podaj x");
        argument = scan.nextInt();
        System.out.println("W(" + argument + ") = " + horner(wspolczynniki,stopien,argument));
    }
}
