import java.util.Scanner;

/**
 * Os descontos por litro nos preços do etanol e da gasolina em determinado posto é dado
 * conforme tabela abaixo:
 *
 * -----------------------------------------
 * Etanol
 * Até 5 litros, preço normal sem desconto.
 * De 5 litros em diante, desconto de 10%.
 * -----------------------------------------
 * Gasolina
 * Até 10 litros, desconto de 5%.
 * De 10 litros em diante, desconto de 7%.
 * -----------------------------------------
 *
 * Sabendo-se que o preço de um litro de gasolina é de R$ 5,79 e de etanol é R$ 3,65, desenvolver um
 * programa que leia o tipo e a quantidade de combustível comprada (número negativo não é permitido).
 * Se o combustível for gasolina, o usuário entra com o número 1; se for etanol, o usuário entra com o
 * número 2. O programa deve mostrar o valor pago pelo cliente ao final da operação. O programa de
 * permitir a realização de um novo abastecimento, caso o cliente opte por realiza-lo.
 */

public class ValorCombustivel {
    public static void main(String[] args) {
        final double PRECO_GASOLINA = 5.79;
        final double PRECO_ETANOL = 3.65;

        final double DESCONTO_PERCENTUAL_GASOLINA_COMUM = (double) 5 /100;
        final double DESCONTO_PERCENTUAL_GASOLINA_10 = (double) 7 /100;
        final double DESCONTO_PERCENTUAL_ETANOL = (double) 10 /100;

        Scanner entrada = new Scanner(System.in);

        int op;


        do {
            System.out.println("CALCULADORA DE IMPOSTO DE RENDA");
            System.out.println("-------------------------------");
            System.out.println("1. Realizar abastecimento");
            System.out.println("2. Sair");
            System.out.println("O que deseja fazer? ");
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    int tipo;
                    int qtdLitros;
                    double desconto = 0;

                    double total;
                    
                    do { //valida e guarda o tipo
                        System.out.println("\nTipo de combustível: ");
                        System.out.println("1. Gasolina");
                        System.out.println("2. Etanol");
                        System.out.print("Informe: ");
                        tipo = entrada.nextInt();


                        if(tipo != 1 && tipo != 2) {
                            System.out.println("Valor inválido!\n");
                        }
                    }while (tipo != 1 && tipo != 2);

                    do { //valida e guarda a quantidade
                        System.out.print("\nQuantidade de combustível:\n");
                        System.out.print("Quantos litros deseja colocar? ");
                        qtdLitros = entrada.nextInt();

                        if(qtdLitros < 0) {
                            System.out.println("Valor inválido!\n");
                        }
                    }while (qtdLitros < 0);


                    if(tipo == 1) { //gasolina
                        desconto = qtdLitros >= 10 ?
                                (qtdLitros * PRECO_GASOLINA) * DESCONTO_PERCENTUAL_GASOLINA_10 :
                                (qtdLitros * PRECO_GASOLINA) * DESCONTO_PERCENTUAL_GASOLINA_COMUM;
                        total = (qtdLitros * PRECO_GASOLINA) - desconto;
                    } else { //etanol
                        desconto = qtdLitros >= 5 ? (qtdLitros * PRECO_ETANOL) * DESCONTO_PERCENTUAL_ETANOL : 0;
                        System.out.println("calc desconto: " + (qtdLitros * PRECO_ETANOL));
                        System.out.println("litros: " + qtdLitros);
                        System.out.println("desconto: " + desconto);
                        total = (qtdLitros * PRECO_ETANOL) - desconto;
                    }

                    System.out.println("--------------------------------");
                    System.out.printf("Valor do abastecimento: R$ %.4f\n", total);
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
