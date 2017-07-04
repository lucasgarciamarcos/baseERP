package Control;

import Bean.ClienteJuridico;
import java.util.Vector;
import Model.DBClientesJuridicos;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClientesJuridicos {

    private DBClientesJuridicos con = new DBClientesJuridicos();  //Conexão com a camada Model
    //Adiciona Cliente ao Model
    public boolean adicionarCliente(ClienteJuridico cliente) throws SQLException {
        Verificacao vr = new Verificacao();
        if(vr.verificarCNPJ(cliente.getCnpj())){
           return con.inserirCliente(cliente);
        }else{
         
         JOptionPane.showMessageDialog(null, "CNPJ INVALIDO!");
         return false;
        }
    }
    
    //Listar ClientesFisicos da Model para a View
    public Vector listarClientes() throws SQLException, Exception {
        Vector vec = con.listarClientes();
        return vec;
    }
    //Remover Cliente através da Model
    public boolean removerCliente(ClienteJuridico cliente) throws SQLException {
        return con.excluirCliente(cliente);
    }
    //Alterar Cliente através da Model
    public boolean alterarCliente(ClienteJuridico cliente) throws SQLException {
        return con.alterarCliente(cliente);
    }
}