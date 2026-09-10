package avancado;

import java.util.Scanner;

public class PerfeitosEAmigaveis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número: ");
        final int n = input.nextInt();
        System.out.println("\n----------------------------");

        for(int i = 2; i <= n; i++) {
            int sum = 0;

            //verifica os divisores próprios e soma
            //INFO: nenhum divisor próprio (exceto o próprio número) é maior que a sua metade.
            for(int c = i/2; c >= 1; c--) {
                if(i % c == 0) {
//                    System.out.println("c: " + c);
                    sum += c;
                }
            }

            //CLASSIFICAÇÃO DO NÚMERO
            String classification;
            if(sum == i) {
                classification = "Perfeito";
            }else if(sum > i) {
                classification = "Abundante";
            }else {
                classification = "Deficiente";
            }

            //CÁLCULO DE PAR AMIGÁVEL
            boolean amigavel = false;

            if(sum >= 2 && sum <= n && sum != i) { //verifica se a soma está no intervalo e se não é um número perfeito
                int sumOfSum = 0;

                //realiza a soma dos divisores própriOs da soma
                for(int c = sum/2; c >= 1; c--) {
                    if(sum % c == 0) {

                        sumOfSum += c;
                    }
                }

                if(sumOfSum == i) { //verifica se é um par amigável
                    amigavel = true;
                }
            }

            //EXIBE DADOS
            System.out.println("Número " + i);
            System.out.println("\nSoma: " + sum);
            System.out.println("Classificação: " + classification);
            System.out.println("Par amigável: " + (amigavel ? "Sim" : "Não"));
            System.out.println("----------------------------");
        }
    }
}
