package avancado;

import java.util.Scanner;

public class FatoresPrimos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int n1;
        final int n2;

        System.out.print("Insira o primero número inteiro: ");
        n1 = input.nextInt();
        System.out.print("Insira o segundo número inteiro: ");
        n2 = input.nextInt();


        System.out.println("\nFatoração:");
        for(int i = 1; i <= 2; i++) {
            int n = i == 1 ? n1 : n2;
            int primo = 2;
            int cont = 0;

            System.out.print(n + " = ");
            if(n == 0 || n == 1) {
                System.out.print(n);
            } else {
                while (n != 1) {
                    if (n % primo == 0) {
                        while (n % primo == 0) {
                            n = n / primo;
                            cont++;
                        }
                        System.out.print(primo + "^" + cont + (n != 1 ? " . " : ""));
                        cont = 0;
                    }
                    primo++;
                }
            }
            System.out.println();
        }

        //cálculo do MDC
        final int mdc;
        int a = n1;
        int b = n2;

        if(a == 0) {
            mdc = b;
        } else if(b == 0) {
            mdc = a;
        } else {
            int resto = a % b;

            while(resto != 0) {
                a = b;
                b = resto;
                resto = a % b;
            }
            mdc = b;
        }

        System.out.println("\nMDC: " + mdc);

        //MMC
        final int mmc = n1 * n2 / mdc;
        System.out.println("\nMMC: " + mmc);
    }
}
