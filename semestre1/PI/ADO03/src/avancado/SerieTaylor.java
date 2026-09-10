package avancado;

import java.util.Scanner;

public class SerieTaylor {
    public static void main(String[] args) {
        double eTaylor = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Insira o valor de X: ");
        double x = input.nextDouble();

        //CÁLCULO COM SÉRIE DE TAYLOR
        /**
         * e^x é a somatória dos termos.
         * para quando o termo for < 10^-10
         */
        int k = 0;
        while(true) {

            //Cálculo do fatorial de k
            long fatorialK = 1;

            for(int n = k; n > 1 ;n--) {
                fatorialK *= n;
            }

            double t = Math.pow(x, k) / fatorialK;

            eTaylor += t;

            if(t < Math.pow(10, -10)) {
                break;
            }

            k++;
        }


        //SAÍDA
        System.out.println("CÁLCULO DE e^x:");
        System.out.println("e^x com 'Math.exp': " + Math.exp(x));
        System.out.println("e^x com série de Taylor: " + eTaylor);
    }
}
