import javax.swing.*;
import java.util.Scanner;

public class Principal {
    static Usuario[] usuarios = new Usuario[5];
    static Scanner ler = new Scanner(System.in);
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
            System.out.println(txtMenu);

            int opcao = ler.nextInt();

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

        System.out.println("Sistema encerrado");
        System.exit(0);
    }

    private static void buscarNome() {
        System.out.println("Digite o nome desejado: ");

        String nome = ler.next();

        Usuario usuarioDesejado = null;

        for(Usuario u : usuarios) {
            if(u != null && u.getNome().equalsIgnoreCase(nome)) {
                usuarioDesejado = u;
                break;
            }
        }

        if(usuarioDesejado == null) {
            System.out.println("Usuário com nome " + nome + " não encontrado!");
        }else {
            System.out.printf("Nome: %s | Senha: %d\n", usuarioDesejado.getNome(), usuarioDesejado.getSenha());
        }
    }

    private static void buscarSenha() {
        System.out.println("Digite a senha desejada: ");

        int senha = ler.nextInt();

        Usuario usuarioDesejado = null;

        for(Usuario u : usuarios) {
            if(u != null && u.getSenha() == senha) {
                usuarioDesejado = u;
                break;
            }
        }

        if(usuarioDesejado == null) {
            System.out.println("Usuário com a senha " + senha + " não encontrado!");
        }else {
            System.out.printf("Nome: %s | Senha: %d\n", usuarioDesejado.getNome(), usuarioDesejado.getSenha());
        }
    }

    public static void cadastrar() {
        if(ultimaPosicao == usuarios.length - 1) {
            System.out.println("\n\n");
            System.out.println("Cadastros já realizados!");
            return;
        }

        System.out.println("\n\n");

        int opcao = 0;

        do {
            int i = ultimaPosicao + 1;

            System.out.println("Digite o nome do " + (i+1) + "º usuário: ");
            String nome = ler.next();
            System.out.println("Digite a senha do " + (i+1) + "º usuário: ");
            int senha = ler.nextInt();

            Usuario usuario = new Usuario(nome, senha);

            usuarios[i] = usuario;
            ultimaPosicao = i;

            if(ultimaPosicao < usuarios.length - 1) {
                System.out.println("Deseja cadastrar outro usuário? [S/N] ");
                opcao = ler.next().equalsIgnoreCase("S") ? 1 : 0;
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

        System.out.println(saida);
    }

    public static void listarOrdenadoNome() {
        String saida = "\n\n";

        //enhanced for
        for(Usuario usuario : usuarios) {
            if(usuario != null) {
                saida += "Nome: %s | Senha: %d\n".formatted(usuario.getNome(), usuario.getSenha());
            }
        }

        System.out.println(saida);
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