import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Principal {
    static final int MAX = 5;
    static Usuario[] usuarios = new Usuario[MAX];
    static int ultimaPosicao = -1;

    public static void main(String[] args) {
        String  txtMenu =  "1. Inserir novo nome e senha\n";
                txtMenu += "2. listar nomes e senhas (lado a lado)\n";
                txtMenu += "3. ordenar por nome usando bubble sort\n";
                txtMenu += "4. buscar uma senha (por busca binária)\n";
                txtMenu += "5. finalizar \n\n\n";
        
        boolean executando = true;

        do{
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, txtMenu, "MENU INICIAL", JOptionPane.PLAIN_MESSAGE));

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar(usuarios);
                case 3 -> listarOrdenadoNome();
                case 4 -> buscaBinariaSenha();
                case 5 -> executando = false;
            }
        }while(executando);     

        JOptionPane.showMessageDialog(null, "Sistema encerrado");
        System.exit(0);
    }

    private static void buscaBinariaSenha() {
        int senha = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha desejada: "));

        Usuario[] usuariosOrdenados = bubbleSortSenha(usuarios);

        int pos = -1;

        //algoritmo de busca binária
        int pInicio = 0;
        int pFinal = ultimaPosicao;
        int pMeio = (pInicio + pFinal) / 2;

        while(pInicio <= pFinal) {
            if(senha == usuariosOrdenados[pMeio].getSenha()) {
                pos = pMeio;
                break;
            }else if(senha > usuariosOrdenados[pMeio].getSenha()) {
                pInicio = pMeio + 1; //descarta o meio
            }else {
                pFinal = pMeio - 1; //descarta o meio
            }

            pMeio = (pInicio + pFinal) / 2;
        }

        if(pos == -1) {
            JOptionPane.showMessageDialog(null, "Usuário com a senha " + senha + " não encontrado!");
        }else {
            Usuario u = usuariosOrdenados[pos];
            JOptionPane.showMessageDialog(null, "Posição no vetor ordenado por senha [%d] (Nome: %s | Senha: %d)\n".formatted(pos, u.getNome(), u.getSenha()));
        }
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
            }else {
                opcao = 0;
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

    public static void listarOrdenadoNome() {
        Usuario[] lista = bubbleSortNome(usuarios);

        listar(lista);
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

    public static Usuario[] bubbleSortNome(Usuario[] vetor) {
        Usuario[] mVetor = vetor.clone();

        boolean troca = true;
        while(troca) {
            troca = false;
            for(int i = 0;i < ultimaPosicao; i++) {
                if(ehMaior(mVetor[i].getNome(), mVetor[i+1].getNome())) {
                    trocar(mVetor, i, i+1);
                    troca = true;
                }
            }
        }

        return mVetor;
    }

    //devolve 'true' apenas se str1 é maior
    public static boolean ehMaior(String str1, String str2) {
        for(int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2;

            try {
                c2 = str2.charAt(i);
            }catch (IndexOutOfBoundsException e) { //a str2 é menor. ex: str1 = "abc" e str2 = "ab"
                return true;
            }

            if(c1 > c2) {
                return true;
            } else if(c2 > c1) {
                return false;
            }
        }

        return false; //as strings são iguais
    }

    private static void trocar(Usuario[] vetor, int i1, int i2) {
        Usuario tmp = vetor[i1];
        vetor[i1] = vetor[i2];
        vetor[i2] = tmp;
    }


//    public static int compare(String p1, String p2) {
//        for(int i = 0; i < p1.length(); i++) {
//            char c1 = p1.charAt(i);
//            char c2;
//
//            try {
//                c2 = p2.charAt(i);
//            }catch (IndexOutOfBoundsException e) { //a str2 é menor. ex: str1 = "abc" e str2 = "ab"
//                return 1;
//            }
//
//            if(c1 > c2) {
//                return 1;
//            } else if(c2 > c1) {
//                return -1;
//            }
//        }
//
//        return 0; //as strings são iguais
//    }
//
//    public static <T, A> T[] bubbleSort(T[] vetor, Metodo<A> metodo) {
//        T[] mVetor = vetor.clone();
//
//        A atributo = metodo.getAtributo();
//
//        System.out.println(atributo);
//
//        return mVetor;
////        boolean troca = true;
////        while(troca) {
////            troca = false;
////            for(int i = 0;i < ultimaPosicao; i++) {
////
////                if(compare(mVetor[i].getAttributo(), mVetor[i+1].getAttributo()) > 0) {
////                    trocar(mVetor, i, i+1);
////                    troca = true;
////                }
////            }
////        }
////        Function
////        return mVetor;
//    }


    private static void teste() {
        Usuario[] users = new Usuario[5];
        users[0] = new Usuario("Allan", 5);
        users[1] = new Usuario("Allana", 3);
        users[2] = new Usuario("abc", 2);
        users[3] = new Usuario("Abcd", 4);
        users[4] = new Usuario("etson", 0);

        ultimaPosicao = 4;
        usuarios = users;

        buscaBinariaSenha();

        System.out.println();
//        bubbleSort(users, Usuario::getNome);
    }
}