package avancado;

import java.util.Scanner;

public class CollatzRecordes {
    public static void main(String[] args) {
        long longestLength = 0;
        long longestNumber = 0;
        boolean overflowRisk = false;
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um inteiro N: ");
        final long n = input.nextLong();

        for(long i = 1; i <= n; i++) {
            long c = i;
            long length = 1;

            while(c > 1) {
                c = c % 2 == 0 ? c / 2 : 3L * c + 1;

                if(c > Long.MAX_VALUE / 3) { //verifica se há risco de overflow
                    overflowRisk = true;
                }
                length++;
            }

            if(longestLength < length) {
                longestLength = length;
                longestNumber = i;
            }
        }

        //VERIFICAR SE TEM RISCO DE OVERFLOW COM LONG.MAX_VALUE / 3
        if(overflowRisk) {
            System.out.println("AVISO: Houve risco de overflow durante o processamento!");
        }

        //SAIDA
        System.out.printf("O número que gerou a maior sequência entre 1 e N foi %d.\n", longestNumber);
        System.out.printf("Tamanho da sequência: %d", longestLength);
    }
}
