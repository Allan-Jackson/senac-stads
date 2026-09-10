package expert;

import java.util.Scanner;

public class CaixaBancario {
    public static void main(String[] args) {
        final double WITHDRAW_TAX = 0.005; //taxa de saque
        final int MAX_NEGATIVE_WITHDRAW_TRIES = 3; //máximo de saques negativos consecutivos até bloquear
        final double MIN_DEPOSIT_VALUE_TO_UNLOCK = 500.0; //valor mínimo de depósito para desbloquear a conta

        int opCount = 0; //contador das operações realizadas
        int negativeConsecutiveWithdrawTries = 0; //contador de saques negativos consecutivos
		double balance = 0;
        boolean isAccountBlocked = false;
        double pendingUnlockAmount = MIN_DEPOSIT_VALUE_TO_UNLOCK; //quantidade restante para desbloquear
        double maxDeposited = 0;
        double totalWithdraw = 0;


        Scanner input = new Scanner(System.in);


        boolean leave = false;
        while (!leave) {
            System.out.println("\nMENU DE OPÇÕES:\n");
            System.out.println("1 Depositar");
            System.out.println("2 Sacar");
            System.out.println("3 Extrato");
            System.out.println("0 Sair");

            System.out.print("Digite a opção desejada: ");
            int op = input.nextInt();
            input.nextLine();

            switch (op) {
                case 1:
                    System.out.println("\nDEPÓSITO:\n");
                    System.out.print("Digite o valor que deseja depositar: ");
                    double deposit = input.nextDouble();
					input.nextLine(); //consome o '\n' para uma leitura posterior de string
					
                    if(deposit < 0) {
                        System.out.println("\nValor do depósito não pode ser negativo!");
                    }else {
						balance += deposit;
                        maxDeposited += deposit;
						
                        if(isAccountBlocked) {
                            pendingUnlockAmount -= deposit;
                            if(pendingUnlockAmount <= 0) {
                                isAccountBlocked = false; //desbloqueia a conta
								negativeConsecutiveWithdrawTries = 0;
                            }else {
								System.out.printf("Deposite mais R$ %.4f para desbloquear sua conta.\n", pendingUnlockAmount);
							}
                        }
						
						if(balance >= 0) { //verifica se a conta está saudável (positiva)
							negativeConsecutiveWithdrawTries = 0; //limpa o contador de risco
						}							
                    }
                    opCount++;
                    break;
                case 2:
                    System.out.println("\nSACAR:\n");
                    System.out.print("Digite o valor que deseja sacar: ");
                    double withdraw = input.nextDouble();
					input.nextLine(); //consome o '\n' para uma leitura posterior de string
					
                    if(withdraw < 0) {
                        System.out.println("\nValor do saque não pode ser negativo!");
                    }else {
						if(isAccountBlocked) { //impede saque se conta estiver bloqueada
							System.out.printf("Sua conta está bloqueada. Realize um depósito de R$ %.4f para desbloqueá-la!\n", pendingUnlockAmount);
							break;
                        }
						
                        double realWithdraw = withdraw + (withdraw * WITHDRAW_TAX);

                        if(realWithdraw > balance) { //saque negativo
                            negativeConsecutiveWithdrawTries++;
                            
							if(negativeConsecutiveWithdrawTries > MAX_NEGATIVE_WITHDRAW_TRIES) { //bloquea a conta
								isAccountBlocked = true;
								pendingUnlockAmount = MIN_DEPOSIT_VALUE_TO_UNLOCK;
								System.out.printf("Sua conta está bloqueada devido ao número excessivo de saques negativos consecutivos.\nRealize um depósito de R$ %.4f para desbloqueá-la!\n", pendingUnlockAmount);
								break;
							}
                        } else {
							negativeConsecutiveWithdrawTries = 0;
						}

                        balance -= realWithdraw;
                        totalWithdraw += withdraw;                        
                    }
                    opCount++;
                    break;
                case 3:
                    System.out.println("\nEXTRATO:\n");
					if(isAccountBlocked) {
						System.out.println("\nStatus: Conta Bloqueada:");
					}
                    System.out.printf("Saldo atual: R$ %.4f\n", balance);
                    opCount++;
                    break;
                case 0:
                    System.out.println("\n");
                    System.out.printf("Saldo final: %.4f\n", balance);
                    System.out.printf("Total depositado: %.4f\n", maxDeposited);
                    System.out.printf("Total sacado: %.4f\n", totalWithdraw);
                    System.out.printf("Total de operações realizadas: %d\n", opCount);
                    leave = true;
                    break;
                default:
                    System.out.println("\nOpção inválida!\n");
            }

            if(op != 0) {
                System.out.println("\n\nDigite Enter para continuar...");
                input.nextLine();
            }
        }

    }
}
