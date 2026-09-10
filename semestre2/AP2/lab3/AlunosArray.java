public class AlunosArray {
    private int tamanho;
    private int i; //qtd de alunos adicionados

    Aluno[] vetAlunos;

    public AlunosArray(int qtdAlunos) {
        i = 0;
        tamanho = qtdAlunos;
        vetAlunos = new Aluno[tamanho];
    }

    public void addAluno(String nome, double p1, double p2, double ado) {
        if(i >= tamanho) return;

        vetAlunos[i] = new Aluno(nome, p1, p2, ado);
        i++; //atualiza o indice para próxima posição
    }

    public String listar() {
        String output = "";
        
        for(Aluno aluno : vetAlunos) {
            if(aluno != null)
                output += String.format("%s - P1: %.2f - P2: %.2f - ADO: %.2f - MÉDIA: %.2f\n", aluno.nome, aluno.p1, aluno.p2, aluno.ado, aluno.getMedia());
        }
        
        return output;
    }

    public int getNumAlunosAdicionados() {
        return i;
    }

    public int getTamanho() {
        return tamanho;
    }
}
