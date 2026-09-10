import java.util.Scanner;

/**
 * Desenvolver um programa que efetue a leitura de n valores inteiros positivos (incluindo zero)
 * até que um valor negativo seja informado. Ao final, deverão ser apresentados o maior e o menor valor
 * positivo (incluindo zero) informado pelo usuário.
 */


public class MaiorMenor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double max;
        double min;
        double n;

        /* A primeira chamada é isolada para
         * setar o max e min e sair com erro
         * caso não seja informado número válido
         */
        n = input.nextDouble();

        if(n < 0) {
            System.out.println("Nenhum valor válido informado!");
            System.exit(1);
        }

        max = n;
        min = n;

        while(n >= 0) {
            n = input.nextDouble();

            if(n >= 0) {
                max = n >= max ? n : max;
                min = n <= min ? n : min;
            }
        }

        System.out.println("Maior valor inserido foi: " + max);
        System.out.println("O menor valor inserido foi: " + min);

    }
}