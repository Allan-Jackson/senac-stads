package avancado;

import java.util.Random;
import java.util.Scanner;

public class AdivinheONumero {
    public static void main(String[] args) {
        final int SECRET_MIN = 1;
        final int SECRET_MAX = 100;
        final int MAX_TRIES = 7;
        final int secret = new Random().nextInt((SECRET_MAX - SECRET_MIN) + 1) + SECRET_MIN;

        int remainingTries = MAX_TRIES;

        Scanner input = new Scanner(System.in);
        int guess;

        System.out.println("VAlOR DO SEGREDO: " + secret);

        while(true) {
            System.out.print("Qual o número: ");
            guess = input.nextInt();

            if (guess == secret) {
                System.out.println("Parabéns, você acertou!");
                System.out.printf("Sua pontuação: %d/%d\n", remainingTries, MAX_TRIES);
                break;
            } else {
                --remainingTries;

                if(remainingTries == 0) {
                    System.out.println("As chances acabaram, você não foi capaz de adivinhar o número secreto!");
                    System.out.println("\n\nGAME OVER!!!\n\n");
                    break;
                } else {
                    System.out.printf("Você errou!\nVocê possui %d tentativas restantes.\n\n", remainingTries);
                }
            }
        }
    }
}
