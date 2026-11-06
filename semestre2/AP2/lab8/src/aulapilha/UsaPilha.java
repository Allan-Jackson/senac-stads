package aulapilha;

import javax.swing.*;

public class UsaPilha {
    public static void main(String[] args) {
        String strn = JOptionPane.showInputDialog(null, "Deseja iniciar uma pilha com qual tamanho ?");
        int n = Integer.parseInt(strn);
        Pilha p1 = new Pilha(n);
        String menu = "*** Pilha Estática ***\n1 push\n2 listar\n3 pop\n4 destruir\n5 sair\nitem:";
        while (true) {
            String item = JOptionPane.showInputDialog(null, menu);
            switch (item) {
                case "1":
                    String strDado = JOptionPane.showInputDialog(null, "Digite alguma coisa para empilhar:");
                    p1.push(strDado);
                    break;
                case "2":
                    p1.print();
                    break;
                case "3":
                    p1.pop();
                    break;
                case "4":
                    p1.destrutor(p1.topo);
                    break;
                case "5":
                    System.exit(0);
            }
        }
    }
}