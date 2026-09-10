package faceis;

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int repeat;
        do {
            System.out.print("Informe um número: ");
            int n = input.nextInt();
            System.out.printf("O número é %s.\n", n % 2 == 0 ? "par" : "ímpar");

            System.out.print("\nDigite -1 para repetir a operação: ");
            repeat = input.nextInt();
        }while (repeat == -1);
    }
}
