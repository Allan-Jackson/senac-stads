import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.println("Digite um número:");
        int n = input.nextInt();

        System.out.println("\nTABUDA DO " + n + ":");

        int i = 1;
        while(i <= 10) {
            System.out.printf("%d x %d = %d\n", n, i, n*i);
            i++;
        }

    }
}
