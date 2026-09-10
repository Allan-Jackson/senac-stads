package poo.study.escola;
import javax.swing.JOptionPane;

public class CadCliente {
    public static int maxCli = 10;
    public static Cliente[] listaClientes = new Cliente[maxCli];
    private static int cont = 0;
    
    public static void main(String[] args) {
        int op;
        
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar cliente\n2 - Alterar dados"));
            
            switch(op) {
                case 1 -> cadastrar();
                case 2 -> alterar();
                default -> op = 3;
            }
        }while(op != 3);
        
        
        
    }
    
    public static void cadastrar() {
        if(cont >= maxCli) {
            JOptionPane.showMessageDialog(null, "Não é possível cadastrar novos clientes!");
            return;
        }

        Cliente cliente = new Cliente();
        
        cliente.setNome(JOptionPane.showInputDialog("Digite o nome do cliente:"));
        cliente.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:")));
        cliente.setEmail(JOptionPane.showInputDialog("Digite o email:"));
        cliente.setCpf(JOptionPane.showInputDialog("Digite o CPF:"));
         
        if(buscarClientePorNome(cliente.getNome()) != null) {
            JOptionPane.showMessageDialog(null, "Não é possível cadastrar cliente com mesmo nome!");
            return;
        }
        
        salvarCliente(cliente);
    }
    
    public static void alterar() {
        String clientesCadastrados = "";
        
        int i = 0;
        while(listaClientes[i] != null) {
            clientesCadastrados += listaClientes[i].getNome() + "\n";
            i++;
        }
        
        JOptionPane.showMessageDialog(null, clientesCadastrados);
        String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
        
        Cliente cliente = buscarClientePorNome(nomeCliente);
        if(cliente != null) {
            cliente.setNome(JOptionPane.showInputDialog("Digite o novo nome:"));
            cliente.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a nova idade:")));
            cliente.setEmail(JOptionPane.showInputDialog("Digite o novo email:"));
            cliente.setCpf(JOptionPane.showInputDialog("Digite o novo CPF:"));
        }else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }
    
    public static Cliente buscarClientePorNome(String nome) {
        for(int i= 0; i < listaClientes.length; i++) {
            if(listaClientes[i] == null) {
                continue;
            }
            if(listaClientes[i].getNome().equals(nome)) {
                return listaClientes[i];
            }
        }
        return null;
    }
    
    public static void salvarCliente(Cliente cliente) {
        if(buscarClientePorNome(cliente.getNome()) == null) {
            listaClientes[cont] = cliente;
            cont++;
        }
    }
}
