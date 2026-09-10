import java.util.Scanner;

public class ContaParesImpares {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Primeiro número: ");
        int start = input.nextInt();

        System.out.print("Segundo número: ");
        int end = input.nextInt();

        if(start == end) {
            System.out.println("Os números são iguais!");
        } else{
            int execCount = 0;
            int evenAndOddCount = 0;
            boolean even = true;

            if(start > end) {
                //change values for start and end
                var tmp = start;
                start = end;
                end = tmp;
                even = false;
            }

            while(start <= end) {
                if(even) {
                    if(start % 2 == 0) {
                        evenAndOddCount++;
                    }
                }else {
                    if(start % 2 == 1) {
                        evenAndOddCount++;
                    }
                }
                execCount++;
                start++;
            }

            System.out.println("Qtde de " + (even ? "pares" : "impares") + ": " + evenAndOddCount);
            System.out.println("Qtde execuções: " + execCount);
        }
    }
}
