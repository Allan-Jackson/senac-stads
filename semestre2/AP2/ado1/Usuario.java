public class Usuario {
    private String nome;
    private int senha;

    Usuario(String nome, int senha) {
        this.nome = nome;
        this.senha = senha;
    }
    

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}