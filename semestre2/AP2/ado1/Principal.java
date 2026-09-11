import javax.swing.*;
import java.util.Scanner;

public class Principal {
    static Usuario[] usuarios = new Usuario[5];
    static int ultimaPosicao = -1;

    public static void main(String[] args) {
        String  txtMenu =  "\n\n\n\n";
                txtMenu += "1. ler nome e senha numérica\n";
                txtMenu += "2. listar nomes e senhas (lado a lado)\n";
                txtMenu += "3. buscar um nome de forma sequencial \n";
                txtMenu += "4. buscar uma senha de forma sequencial (trazer a posição caso encontre) \n";
                txtMenu += "5. classificar por nome usando bubble sort \n";
                txtMenu += "6. classificar as senhas usando bubble sort \n";
                txtMenu += "7. finalizar \n";
        
        boolean executando = true;

        do{
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(txtMenu));

            switch(opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar(usuarios);
                    break;
                case 3:
                    buscarNome();
                    break;
                case 4:
                    buscarSenha();
                    break;
                case 5:
                    listarOrdenadoNome();
                case 6:
                    listarOrdenadoSenha();
                    break;
                case 7:                    
                    executando = false;
            }
        }while(executando);     

        JOptionPane.showMessageDialog(null, "Sistema encerrado");
        System.exit(0);
    }

    private static void buscarNome() {
        String nome = JOptionPane.showInputDialog("Digite o nome desejado: ");

        Usuario usuarioDesejado = null;

        for(Usuario u : usuarios) {
            if(u != null && u.getNome().equalsIgnoreCase(nome)) {
                usuarioDesejado = u;
                break;
            }
        }

        if(usuarioDesejado == null) {
            JOptionPane.showMessageDialog(null, "Usuário com nome " + nome + " não encontrado!");
        }else {
            JOptionPane.showMessageDialog(null, "Nome: %s | Senha: %d\n".formatted(usuarioDesejado.getNome(), usuarioDesejado.getSenha()));
        }
    }

    private static void buscarSenha() {
        int senha = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha desejada: "));

        Usuario usuarioDesejado = null;

        for(Usuario u : usuarios) {
            if(u != null && u.getSenha() == senha) {
                usuarioDesejado = u;
                break;
            }
        }

        if(usuarioDesejado == null) {
            JOptionPane.showMessageDialog(null, "Usuário com a senha " + senha + " não encontrado!");
        }else {
            JOptionPane.showMessageDialog(null, "Nome: %s | Senha: %d\n".formatted(usuarioDesejado.getNome(), usuarioDesejado.getSenha()));
        }
    }

    public static void cadastrar() {
        if(ultimaPosicao == usuarios.length - 1) {
            JOptionPane.showMessageDialog(null, "Cadastros já realizados!");
            return;
        }

        int opcao = 0;

        do {
            int i = ultimaPosicao + 1;

            String nome = JOptionPane.showInputDialog("Digite o nome do " + (i+1) + "º usuário: ").toLowerCase();
            nome = nome.substring(0, 1).toUpperCase() + nome.substring(1); //capitalize name

            int senha = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha do " + (i+1) + "º usuário: "));

            Usuario usuario = new Usuario(nome, senha);

            usuarios[i] = usuario;
            ultimaPosicao = i;

            if(ultimaPosicao < usuarios.length - 1) {
                String resposta = JOptionPane.showInputDialog("Deseja cadastrar outro usuário? [S/N] ");
                opcao = resposta.equalsIgnoreCase("S") ? 1 : 0;
            }

        }while(opcao == 1);

    }

    public static void listar(Usuario[] listaUsuarios) {
        String saida = "\n\n";

        //enhanced for
        for(Usuario usuario : listaUsuarios) {
            if(usuario != null) {
                saida += "Nome: %s | Senha: %d\n".formatted(usuario.getNome(), usuario.getSenha());
            }
        }

        JOptionPane.showMessageDialog(null, saida);
    }

    //TODO
    public static void listarOrdenadoNome() {
        String saida = "\n\n";

        //enhanced for
        for(Usuario usuario : usuarios) {
            if(usuario != null) {
                saida += "Nome: %s | Senha: %d\n".formatted(usuario.getNome(), usuario.getSenha());
            }
        }

        JOptionPane.showMessageDialog(null, saida);
    }

    public static void listarOrdenadoSenha() {
        Usuario[] lista = bubbleSortSenha(usuarios);

        listar(lista);
    }

    public static Usuario[] bubbleSortSenha(Usuario[] vetor) {
        Usuario[] mVetor = vetor.clone();

        boolean troca = true;
        while(troca) {
            troca = false;
            for(int i = 0;i < ultimaPosicao; i++) {
                if(mVetor[i].getSenha() > mVetor[i+1].getSenha()) {
                    trocar(mVetor, i, i+1);
                    troca = true;
                }
            }
        }

        return mVetor;
    }

    private static void trocar(Usuario[] vetor, int i1, int i2) {
        Usuario tmp = vetor[i1];
        vetor[i1] = vetor[i2];
        vetor[i2] = tmp;
    }

}