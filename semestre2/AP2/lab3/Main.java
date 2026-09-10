import javax.swing.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        int numAlunos = 0;
        AlunosArray a1 = null;

        menu: while(true) {
            System.out.println("Quantidade máxima atual: " + numAlunos);
            int op = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n(1) Definir quantidade de alunos\n(2) Inserir aluno\n(3) Listar alunos\n(4) Sair"));

            switch (op) {
                case 1 -> {
                    int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos:"));

                    if(novaQuantidade <= 0) {
                        JOptionPane.showMessageDialog(null, "A quantidade máxima de alunos não pode ser negativa ou zero!");
                    }else if(a1 == null || novaQuantidade <= numAlunos && novaQuantidade >= a1.getNumAlunosAdicionados()) {
                        numAlunos = novaQuantidade;
                    } else if(novaQuantidade < a1.getNumAlunosAdicionados()){
                        JOptionPane.showMessageDialog(null, "A quantidade máxima de alunos não pode ser menor que o número de alunos já cadastrados!");
                    } else {
                        JOptionPane.showMessageDialog(null, "A quantidade máxima de alunos não pode ser maior que a atual!");
                    }
                }
                case 2 -> {
                    if(numAlunos <= 0) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira uma quantidade de alunos para registrar!");
                        break;
                    }

                    if(a1 == null) {
                      a1 = new AlunosArray(numAlunos);
                    }

                    if(a1.getNumAlunosAdicionados() == numAlunos) {
                        JOptionPane.showMessageDialog(null, "Limite de alunos alcançado!");
                        break;
                    }

                    String nome = JOptionPane.showInputDialog("Nome do aluno:");
                    double p1 = Double.parseDouble(JOptionPane.showInputDialog("Nota da P1:"));
                    double p2 = Double.parseDouble(JOptionPane.showInputDialog("Nota da P2:"));
                    double ado = Double.parseDouble(JOptionPane.showInputDialog("Nota da ADO:"));

                    a1.addAluno(nome, p1, p2, ado);
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null, a1.listar());
                    System.out.println(a1.listar());
                }
                case 4 -> {break menu;}
            }
        }

        System.exit(0);
    }
}
