public class Aluno {
    public String nome;
    public double p1;
    public double p2;
    public double ado;
    private double media;

    public Aluno(String nome, double p1, double p2, double ado) {
        this.nome = nome;
        this.p1 = p1;
        this.p2 = p2;
        this.ado = ado;
    }

    public double getMedia() {
        return p1 * 0.3 + p2 * 0.3 + ado * 0.4;
    }
}
