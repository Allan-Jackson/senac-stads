import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String msg = "MENU\n1.Soma iterativa\n2.Soma recurssiva\n3.Potenciacao iterativa\n4.Potenciacao recurssiva\n5.Soma iterativa real\n6.Soma recurssiva real\n7.Fatorial duplo\n8.Fibonacci\n0.Sair";

        while(true) {
            var entrada = Integer.parseInt(JOptionPane.showInputDialog(msg));

            switch (entrada) {
                case 1 -> {
                    int n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro para o inicio:"));
                    int n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro para o final:"));

                    int res = somaIterativa(n1, n2);

                    JOptionPane.showMessageDialog(null, "A soma é " + res);
                }
                case 2 -> {
                    int n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro para o inicio:"));
                    int n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro para o final:"));

                    int res = somaRecursiva(n1, n2);

                    JOptionPane.showMessageDialog(null, "A soma é " + res);
                }
                case 3 -> {
                    int n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro para o inicio:"));
                    int n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro para o final:"));

                    int res = somaIterativa(n1, n2);

                    JOptionPane.showMessageDialog(null, "A soma é " + res);
                }
                case 4 -> {
                    int n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro para o inicio:"));
                    int n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe um inteiro para o final:"));

                    int res = somaIterativa(n1, n2);

                    JOptionPane.showMessageDialog(null, "A soma é " + res);
                }
                case 0 -> {
                    JOptionPane.showMessageDialog(null, "Finalizando programa...");
                    System.exit(0);
                }
            }
        }

    }

    //EXERCICIO 1
    //Função iterativa do exemplo 3
    public static int potenciacaoIterativa(int base, int exp) {
        int res = 1;

        for(int i = 0; i < exp; i++) {
            res *= base;
        }

        return res;
    }

    //Função recursiva do exemplo 3
    public static int potenciacaoRecursiva(int base, int exp) {
        int res = 1;

        if(exp == 1) {
            return base;
        }

        res = base * potenciacaoRecursiva(base, exp-1);

        return res;
    }

    //Função iterativa do exemplo 4
    public static int somaIterativa(int first, int last) {
        int res = first;

        for(int i = first; i < last; i++) {
            res += i + 1;
        }

        return res;
    }

    //Função recursiva do exemplo 4
    public static int somaRecursiva(int first, int last) {
        int res = 0;

        if(first == last) {
            return first;
        }

        res = first  + somaRecursiva(first+1, last);

        return res;
    }

    //EXERCICIO 2
    public static void somaIt(int x, int y){
        int soma = 0;
        for(int i = x; i <= y; i++){
            soma = soma + i;
        }
        System.out.println(soma);
    }

    public static int somaRe(int x,int y){
        if(x == y) return y;
        return x + somaRe(x+1,y);
    }


    //EXERCICIO 3
    public static int fatorial(int n){
        if(n <= 1) return 1;
        return n * fatorial(n-2);
    }

    //EXERCICIO 4
    public static int fibonacci(int pos) {
        if(pos<=2) {
            return 1;
        }

        int ant1 = fibonacci(pos-1);
        int ant2 = fibonacci(pos-2);

        return ant1 + ant2;
    }
}