import java.util.*;

public class Tabuada {
  public static void main(String[] args) {
    var input = new Scanner(System.in);
    
    System.out.println("Digite um número: ");
    var n = input.nextInt();
    
    for(int i = 1; i <= 10; i++) {
      System.out.printf("%d x %d = %d\n", n, i, n * i);
    }
  }
}
