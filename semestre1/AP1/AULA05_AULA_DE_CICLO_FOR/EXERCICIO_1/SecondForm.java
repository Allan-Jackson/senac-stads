import java.util.*;

/* sugestão da IA para melhor performance percebendo o primeiro par ou impar e imprimir de 2 em 2 */
public class SecondForm {
    public static void main(String[] args) {
      var input = new Scanner(System.in);
      
      System.out.println("valor inicio: ");
      var start = input.nextInt();
      
      System.out.println("valor fim: ");
      var end = input.nextInt();
      
      if(start == end) {
        System.out.println("Os números informados são iguais! Por favor, insira números diferentes.");
      } else if(start < end) {
        //pega primeiro par
        var firstEven = (start % 2 == 0 ? start : start + 1);
        //apenas printa de 2 em 2
        for(int n = firstEven; n <= end; n += 2) {
          System.out.println("PAR " + n);
        }
      } else {
        //pega primeiro impar
        var firstOdd = (start % 2 == 1 ? start : start + 1);
        //apenas printa de 2 em 2
        for(int n = firstOdd; n <= end; n += 2) {
          System.out.println("IMPAR " + n);
        }
      }
    }
}