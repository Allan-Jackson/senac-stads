import javax.swing.*;

public class Main {
    public static void main(String args[]) {

        PilhaNotas p1 = new PilhaNotas(2);

        while (true) { String menu = "1 Push\n2 pop\n3 listar\n4 sair\nitem:";
            String item = JOptionPane.showInputDialog(null, menu);
            switch (item) {
                case "1":
                    String nome = JOptionPane.showInputDialog(null, "Digite o nome:");
                    double media = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a média:"));
                    p1.push ( nome, media ); break;
                case "2": p1.pop(); break;
                case "3": p1.plotar(); break;
                case "4":
                    p1.destrutor();
                    JOptionPane.showMessageDialog(null, "Destruida!");
                    System.exit(0);
                    break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
}
