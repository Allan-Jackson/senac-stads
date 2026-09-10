import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        final int secretNumber = 10;
        int guess = 0;
        int attempts = 0;

        System.out.println("\nADIVINHE O NÚMERO\n");
        while(guess != secretNumber) {
            System.out.println("\nDigite um número entre 1 e 10: ");
            guess = input.nextInt();

            if(guess < 1 || guess > 10) {
                System.out.println("Por favor, digite um número válido!");
                continue;
            }

            attempts++;

            if(guess != secretNumber){
                System.out.println("Que pena, você errou!");

                if(guess > secretNumber) {
                    System.out.println("DICA: O número secreto é menor");
                }else {
                    System.out.println("DICA: O número secreto é maior");
                }

                System.out.println("Tente outra vez!");
            }

        }

        if(attempts == 1) {
            System.out.println("\nVocê acertou de primeira! Lucky!!!");
        } else{
            System.out.println("\nVocê acertou!");
            System.out.println("Nº de tentativas: " + attempts);
        }


    }
}
