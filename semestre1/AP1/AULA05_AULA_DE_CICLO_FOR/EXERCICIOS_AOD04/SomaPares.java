import java.util.*;

public class SomaPares {
  public static void main(String[] args) {
    var input = new Scanner(System.in);
    
    System.out.println("Digite um número: ");
    var n = input.nextInt();
    
    if(n < 2) {
      System.out.println("Número deve ser maior ou igual a 2!");
      System.exit(1);
    }
    
    int sum = 2;
    String sumRecord = "2";
    
    for(int i = 4; i <= n; i += 2) {
      sum += i;
      sumRecord += " + " + i;
    }
    
    System.out.printf("%d (%s)", sum, sumRecord);
    
   
  }
}