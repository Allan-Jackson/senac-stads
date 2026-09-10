package faceis;

import java.util.Scanner;

public class SomaN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long sum = 0;

        System.out.println("Digite um número positivo: ");

        int n = input.nextInt();

        for(int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.printf("A soma de 1 até %d é %d", n, sum);
    }
}

