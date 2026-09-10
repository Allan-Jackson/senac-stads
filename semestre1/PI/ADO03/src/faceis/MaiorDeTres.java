package faceis;

import java.util.Scanner;

public class MaiorDeTres {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1, n2, n3;
        int max, min;
        boolean isEqual = false;

        System.out.println("Informe o 1º número: ");
        n1 = input.nextInt();
        System.out.println("Informe o 2º número: ");
        n2 = input.nextInt();
        System.out.println("Informe o 3º número: ");
        n3 = input.nextInt();

        if(n1 == n2 && n2 == n3) {
            System.out.println("Os números são iguais!");
        }else {

            max = n1;
            min = n1;

            //verifica o maior
            if(n2 > max) {
                max = n2;
            }
            if(n3 > max) {
                max = n3;
            }

            //verifica o menor
            if(n2 < min) {
                min = n2;
            }
            if(n3 < min) {
                min = n3;
            }

            //verifica se há dois iguais
            isEqual = (n1 == n2) || (n1 == n3) || (n2 == n3);

            System.out.println("Maior: " + max);
            System.out.println("Menor: " + min);
            if(isEqual){
                System.out.println("Há números iguais!");
            }
        }
    }
}
