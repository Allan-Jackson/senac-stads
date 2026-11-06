import javax.swing.JOptionPane;

public class PilhaNotas { public int topo; public int max; public int tam;
    public Notas pil[];

    public PilhaNotas(int max) {
        this.max = max; this.topo = -1;
        pil = new Notas[max];
    }

    public void push(String nom, double med) {
        if (topo == max - 1) return;
        topo ++;
        pil[topo] = new Notas(); pil[topo].nome = nom;
        pil[topo].media = med; JOptionPane.showMessageDialog(null, "Dados empilhados !");
    }

    public void pop() {
        if (topo == -1) return;
        pil[topo].nome = null;
        pil[topo].media = '\0'; topo--;
    }

    public void plotar() {
        int temp = topo;
        String saida = "";
        while( temp > -1){ saida += "\n" + this.pil[temp].nome + " " + this.pil[temp].media;
            temp--; }
        JOptionPane.showMessageDialog(null, saida);
    }

    public void destrutor() {
        while (topo >= 0) pop();
    }
}