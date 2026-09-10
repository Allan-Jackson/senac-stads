import java.util.Scanner;

public class SomaEntrada {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        long sum = 0;
        boolean repeat = true;

        while(repeat) {
            System.out.print("Digite um número: ");
            int n = input.nextInt();

            if(n == 0)
                repeat = false;

            sum += n;
        }

        System.out.println("\nA soma dos números digitados é: " + sum);
    }
}
