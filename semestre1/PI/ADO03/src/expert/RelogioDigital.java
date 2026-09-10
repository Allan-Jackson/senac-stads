package expert;

import java.util.Scanner;

public class RelogioDigital {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int contaPalindromos = 0;
		
		for(int h = 0; h < 23; h++) {
			for(int m = 0; m < 59; m++) {
				for(int s = 0; s < 59; s++) {
					/*
					 * 1. Gerar a string hhmmss 
					 * 2. Verificar se a string forma um palíndromo 053350
					 * 3. Verificar se o número hhmmss é primo
					 * 4. Somar os dígitos do número hhmmss e ver se é divisível por 7
					 * 5. verificar se todos os critérios foram atendidos, se sim, contar e exibir
					 */
					boolean palindromo = true;
					String hhmmss = String.format("%02d%02d%02d", h, m, s);
					
					for(int i = 0; i < hhmmss.length()/2; i++) {
						if(hhmmss.charAt(i) != hhmmss.charAt(hhmmss.length()-i-1)) {
							palindromo = false;
							break;
						}
					}
					
					System.out.println(hhmmss);
					if(palindromo) {
						contaPalindromos++;
						System.out.println("palindromo");
					}
					System.out.println("\n---------\n");
					
					if(h == 4) {
						System.out.println("\nTotal de palíndromos: " + contaPalindromos);
						System.exit(0);
					}
				}
			}
		}
		
		
	}
}
	