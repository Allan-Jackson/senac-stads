package intermediario;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        int current = 1;
        int previous = 0;

        n = input.nextInt();

        if(n > 0) {
            System.out.print("Sequência: 1");
        }

        for(int i = 2; i <= n; i++) {
            int next = previous + current;
            previous = current;
            current = next;

            System.out.print(" " + current);
        }

        System.out.printf("\nO %dº termo da sequência é %s.\n", n, (n % 2 == 0) ? "par" : "ímpar");

    }
}
