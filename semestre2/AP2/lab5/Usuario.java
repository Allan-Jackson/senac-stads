public class Usuario {
    private String nome;
    private String rg;
    private String email;

    Usuario(String nome, String rg, String email) {
        this.nome = nome;
        this.rg = rg;
        this.email = email;
    }
    

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getEmail() { return email;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setEmail(String email) { this.email = email;}
}