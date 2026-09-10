import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Usuario[] usuarios = new Usuario[5];
        Scanner ler = new Scanner(System.in);

        int ultimaPosicao = -1;

        String  txtMenu =  "\n\n\n\n";
                txtMenu += "1. ler nome e senha numérica\n";
                txtMenu += "2. listar nomes e senhas (lado a lado)\n";
                txtMenu += "3. buscar um nome de forma sequencial \n";
                txtMenu += "4. buscar uma senha de forma sequencial (trazer a posição caso encontre) \n";
                txtMenu += "5. classificar por nome usando bubble sor \n";
                txtMenu += "6. classificar as senhas usando bubble sort \n";
                txtMenu += "7. finalizar \n";
        
        boolean executando = true;

        do{
            System.out.println(txtMenu);

            int opcao = ler.nextInt();

            switch(opcao) {
                case 1:
                    if(ultimaPosicao == usuarios.length - 1) {
                        System.out.println("\n\n");
                        System.out.println("Cadastros já realizados!");
                        continue;
                    }

                    System.out.println("\n\n");

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
                        }else{
                            opcao = 0;
                        }
                        
                    }while(opcao == 1);

                    break;
                case 2:
                    String saida = "\n\n";

                    //enhanced for
                    for(Usuario usuario : usuarios) {
                        if(usuario != null) {
                            saida += "Nome: %s | Senha: %d\n".formatted(usuario.getNome(), usuario.getSenha());
                        }
                    }

                    System.out.println(saida);
                    
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                case 7:                    
                    executando = false;
            }
        }while(executando);     

        System.out.println("Sistema encerrado");
        System.exit(0);
    }

}