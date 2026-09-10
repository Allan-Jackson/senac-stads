package intermediario;

import java.math.BigInteger;
import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Calculador de Fatorial");
        System.out.println("----------------------");
        System.out.print("Digite um número para calcular: ");
        int n = input.nextInt();

        var f = new BigInteger(Integer.toString(n));

        //calculo do fatorial
        while(n > 2) {
            --n;
            f = f.multiply(BigInteger.valueOf(n));
        }

        System.out.println("O fatorial é " + f.toString());
    }
}
