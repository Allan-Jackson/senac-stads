package intermediario;

import java.util.Scanner;

public class DetectorDePalindromo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isPalindrome = true;

        System.out.print("Digite uma palavra: ");
        String word = input.next().toLowerCase();

        //pega o tamanho da string sem espaços
        int len = word.trim().length();

        int iStart = 0;
        int iEnd = len-1;

        while(iStart<iEnd) {
            if(word.charAt(iStart) != word.charAt(iEnd)) {
                isPalindrome = false;
                break;
            }
            iStart++;
            iEnd--;
        }

        System.out.printf("A palavra %s é um palíndromo!", isPalindrome ? "" : "não");
    }
}
