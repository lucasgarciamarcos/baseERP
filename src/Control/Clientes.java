/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Bean.Cliente;
import java.util.Vector;



/**
 *
 * @author arthu
 */
public class Clientes {
    
    private Vector clientes = new Vector();
    
    public void adicionarCliente(Cliente cliente) {
        clientes.addElement(cliente);
    }
    
        public String listarClientes() {
        String listaAux = "";

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = (Cliente) clientes.elementAt(i);
            listaAux += cliente.getNome() + ", " + cliente.getCpf() + " - Cartão " + cliente.getCreditCard() + " - Email " + cliente.getEmail() + " - Telefone - " + cliente.getTelefone() + "\n";
        }

        return listaAux;

    }

    public void removerCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = (Cliente) clientes.elementAt(i);
            String o = aux.getNome();
            if (cliente.getNome().equals(o)) {
                clientes.removeElementAt(i);
            }
        }
    }

    public void alterarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = (Cliente) clientes.elementAt(i);
            String ref = aux.getNome();
            String novoNome = cliente.getNome();
            String novoCpf = cliente.getCpf();
            String novoCartao = cliente.getCreditCard();
            String novoEmail = cliente.getEmail();
            String novoTelefone = cliente.getTelefone();
            if (cliente.getNome().equals(ref)) {
                Cliente novoCliente = new Cliente();
                novoCliente.setNome(novoNome);
                novoCliente.setCreditCard(novoCartao);
                novoCliente.setCpf(novoCpf);
                novoCliente.setEmail(novoEmail);
                novoCliente.setTelefone(novoTelefone);
                clientes.setElementAt(novoCliente, i);
            }
        }
    }
}
