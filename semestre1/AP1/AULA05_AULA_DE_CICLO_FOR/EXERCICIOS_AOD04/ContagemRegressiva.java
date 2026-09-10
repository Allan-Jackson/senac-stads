import java.util.*;

public class ContagemRegressiva {
  public static void main(String[] args) {
    var input = new Scanner(System.in);
    
    System.out.println("Digite um número: ");
    var n = input.nextInt();
    
    for(;n >= 0; n--) {
      System.out.println(n);
    }
  }
}