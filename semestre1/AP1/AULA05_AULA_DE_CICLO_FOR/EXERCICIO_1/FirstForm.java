import java.util.*;

public class FirstForm {
    public static void main(String[] args) {
      var input = new Scanner(System.in);
      
      System.out.println("valor inicio: ");
      var start = input.nextInt();
      
      System.out.println("valor fim: ");
      var end = input.nextInt();
      
      if(start == end) {
        System.out.println("Os números informados são iguais! Por favor, insira números diferentes.");
      } else if(start < end) {
        //count even numbers in interval
        for(int n = start; n <= end; n++) {
          if(n % 2 == 0) {
            System.out.println("PAR " + n);
          }
        }
      } else {
        //count odd numbers in interval
        for(int n = end; n <= start; n++) {
          if(n % 2 == 1) {
            System.out.println("IMPAR " + n);
          }
        }
      }
    }
}