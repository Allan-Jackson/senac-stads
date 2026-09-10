package faceis;

import java.util.Scanner;

public class ClassificacaoNotas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int GRADES_QTT = 5;
        double sum = 0;
        double avg;
        char classificacao;

        for(int i = 1; i <= GRADES_QTT; i++) {
            double grade;
            boolean repeat;

            do {
                repeat = false;

                System.out.printf("Digite a %dª nota: ", i);
                grade = input.nextDouble();

                if(grade < 0 || grade > 10) {
                    System.out.println("Insira uma nota de 0 a 10!");
                    repeat = true;
                }
            }while(repeat);

            sum += grade;
        }

        avg = sum/GRADES_QTT;

        if(avg < 5) {
            classificacao = 'D';
        }else if(avg < 7) {
            classificacao = 'C';
        }else if(avg < 9) {
            classificacao = 'B';
        }else {
            classificacao = 'A';
        }

        System.out.println("\nAluno classificado como " + classificacao);
    }
}
