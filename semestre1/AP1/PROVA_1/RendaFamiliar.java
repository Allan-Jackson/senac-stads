import java.util.Scanner;

/**
 * Desenvolver um programa em Java que leia o salário de um contribuinte e calcule o imposto
 * de renda (IR) a ser pago a partir do salário do contribuinte de acordo com a tabela abaixo:
 * a. Para renda familiar até 1.903,98 – isento
 * b. Para renda familiar entre 1.903,99 e 2.826,65 – alíquota de 7,5%
 * c. Para renda familiar entre 2.826,66 e 3.751,05 – alíquota de 15%
 * d. Para renda familiar entre 3.751,06 e 4.664,68 – alíquota de 22,5%
 * e. Para renda familiar entre acima de 4.664,68 – alíquota de 27,5%
 * O programa deve imprimir o salário bruto e líquido do contribuinte, além da alíquota paga por ele.
 * O programa deve permitir reiniciar a consulta, sem o encerramento do programa.
 */

public class RendaFamiliar {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double salarioBruto;
        double imposto;
        double aliquota;
        double salarioLiquido;
        int op;

        do {
            System.out.println("CALCULADORA DE IMPOSTO DE RENDA");
            System.out.println("-------------------------------");
            System.out.println("1. Calcular imposto");
            System.out.println("2. Sair");
            System.out.println("O que deseja fazer? ");
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    //cálculo do imposto
                    do {
                        System.out.print("Informe a renda familiar: R$ ");
                        salarioBruto = entrada.nextDouble();

                        if(salarioBruto < 0) {
                            System.out.println("Valor inválido!\n");
                        }
                    }while (salarioBruto < 0);

                    if (salarioBruto <= 1903.98) {
                        aliquota = 0;
                    } else if (salarioBruto <= 2826.65) {
                        aliquota = 7.5;
                    } else if (salarioBruto <= 3751.05) {
                        aliquota = 15;
                    } else if (salarioBruto <= 4664.68) {
                        aliquota = 22.5;
                    } else {
                        aliquota = 27.5;
                    }
                    imposto = salarioBruto * aliquota / 100;
                    salarioLiquido = salarioBruto - imposto;

                    System.out.println("\n");
                    System.out.printf("Salário Bruto: R$ %.2f\n", salarioBruto);
                    System.out.printf("Salário Líquido: R$ %.2f\n", salarioLiquido);
                    System.out.printf("Alíquota: %.2f%%\n", aliquota);
                    if(imposto != 0) {
                        System.out.printf("Imposto de Renda Devido: R$ %.2f\n", imposto);
                    }else {
                        System.out.println("--Isento do Imposto de Renda--\n");
                    }

                    System.out.println("\n\n");
                    break;
                case 2:
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Opção inválida!\n\n");
            }
        }while(op != 2);
    }
}
