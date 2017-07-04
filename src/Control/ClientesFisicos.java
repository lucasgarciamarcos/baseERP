package Control;

import Bean.ClienteFisico;
import java.util.Vector;
import Model.DBClientesFisicos;
import java.sql.SQLException;
import Control.Verificacao;
import javax.swing.JOptionPane;
public class ClientesFisicos {
    

    private DBClientesFisicos con = new DBClientesFisicos();  //Conexão com a camada Model
    //Adiciona Cliente ao Model
    public boolean adicionarCliente(ClienteFisico cliente) throws SQLException {
        Verificacao vr = new Verificacao();
        if(vr.verificarCPF(cliente.getCpf())){
           return con.inserirCliente(cliente);      
        }else{
         
         JOptionPane.showMessageDialog(null, "CPF INVALIDO!");
         return false;
        }
    }
    //Listar ClientesFisicos da Model para a View
    public Vector listarClientes() throws SQLException, Exception {
        Vector vec = con.listarClientes();
        return vec;
    }
    //Remover Cliente através da Model
    public boolean removerCliente(ClienteFisico cliente) throws SQLException {
       return con.excluirCliente(cliente);
    }
    //Alterar Cliente através da Model
    public boolean alterarCliente(ClienteFisico cliente) throws SQLException {
        return con.alterarCliente(cliente);
    }
}
