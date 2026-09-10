package intermediario;

import java.util.Scanner;

public class TrianguloDeNumeros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int n = input.nextInt();

        for(int l = 1; l <= n; l++) {
            for(int c = 1; c <= l; c++) {
                System.out.printf("%d ", c);
            }
            System.out.println(); //quebra a linha
        }
    }
}
