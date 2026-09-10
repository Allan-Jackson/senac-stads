import java.util.*;

public class CadastroComMedia {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.println("Digite o número de alunos: ");
        var nAlunos = input.nextInt();

        double nota1, nota2, media;
        double mediaGeral = 0.0;

        int aprovados = 0;
        int reprovados = 0;

        for(int i = 1; i <= nAlunos; i++) {
            input.nextLine(); // <--- LIMPA O BUFFER AQUI (Consome o Enter do nAlunos)
            System.out.println("CADASTRO ALUNO " + i);
            System.out.println("Digite o nome do aluno: ");
            input.nextLine();
            System.out.println("Digite a primeira nota: ");
            nota1 = input.nextDouble();
            System.out.println("Digite a segunda nota: ");
            nota2 = input.nextDouble();
            System.out.println("\nRESULTADO:");

            media = (nota1 + nota2) / 2;
            mediaGeral += media;

            if(media >= 6) {
                System.out.println("Aluno APROVADO");
                ++aprovados;
            }else {
                System.out.println("Aluno REPROVADO");
                ++reprovados;
            }
            System.out.println("---------------");
        }

        mediaGeral /= nAlunos;

        System.out.println("A média geral da turma foi: " + mediaGeral);
        System.out.println("Número de alunos APROVADOS: " + aprovados);
        System.out.println("Número de alunos REPROVADOS: " + reprovados);
    }
}