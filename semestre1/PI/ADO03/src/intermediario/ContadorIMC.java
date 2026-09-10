package intermediario;

import java.util.Scanner;

public class ContadorIMC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        double avg;
        double IMCSum = 0;
        int overweight = 0;
        int n = 0;

        //define o valor mínimo de cada classificação
        final int PESO_IDEAL = 19;
        final int SOBREPESO = 25;
        final int OBESIDADE_1 = 30;
        final int OBESIDADE_2 = 35;
        final int OBESIDADE_3 = 40;


        while(true){
            System.out.println("Calculador de IMC");
            System.out.println("[1] Calcular");
            System.out.println("[2] Sair");
            System.out.print("Selecione: ");
            choice = input.nextInt();

            if(choice == 2) {
                break;
            }

            if(choice == 1) {
                System.out.println("\n\n");
                System.out.print("Informe o peso (em quilos): ");
                double weight = input.nextDouble();

                System.out.print("Informe a altura (em metros): ");
                double height = input.nextDouble();

                //calcula o IMC e soma com os anteriores
                double IMC = weight/(Math.pow(height, 2));
                IMCSum += IMC;

                String label;
                //classifica o indivíduo
                if(IMC < PESO_IDEAL) {
                    label = "Abaixo do peso";
                }else if(IMC < SOBREPESO) {
                    label = "Peso ideal";
                }else if(IMC < OBESIDADE_1) {
                    label = "Sobrepeso";
                }else if(IMC < OBESIDADE_2) {
                    label = "Obesidade Grau I";
                }else if(IMC < OBESIDADE_3) {
                    label = "Obesidade Grau II";
                }else {
                    label = "Obesidade Grau III";
                }

                if(IMC >= SOBREPESO) {
                    overweight++;
                }

                System.out.printf("IMC: %.2f\n", IMC);
                System.out.println("Classificação: " + label);
                System.out.println("\n\n");
                n++;
            }else {
                System.out.println("Opção inválida!\n\n");
            }

        };

        if(n > 0) {
            avg = (IMCSum) / n;

            System.out.printf("\nA média geral foi de: %.2f\n", avg);
            System.out.println("Existem " + overweight + " indivíduos acima do peso.");
        }
    }
}
