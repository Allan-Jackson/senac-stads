import java.util.Scanner;

public class SomaNumeros {
    public static void main(String[] args) {

        long sum = 0;

        int i = 1;
        while(i <= 100) {
            sum += i;
            i++;
        }

        System.out.println("Resultado da soma de 1 até 100:");
        System.out.println("RESULTADO: " + sum);
    }
}
