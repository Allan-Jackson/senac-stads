package faceis;

import java.util.Scanner;

public class ContagemRegressiva {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        do {
            System.out.print("Informe um número: ");
            n = input.nextInt();

            if(n < 0) {
                System.out.println("O número deve ser positivo!");
            }
        }while (n < 0);

        while(n>0) {
            System.out.print(n + "... ");
            n--;
        }
        System.out.println("0!");
    }
}
