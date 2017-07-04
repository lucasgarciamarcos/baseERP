package Model;

import Bean.ClienteJuridico;
import Bean.Venda;
import Bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DBClientesJuridicos {

    //Insere Cliente ao banco
    public boolean inserirCliente(ClienteJuridico cliente) throws SQLException {
        String sql = "INSERT INTO ClientesJuridicos(nome, email, telefone, cnpj, payment) VALUES(?, ?, ?, ?, ?)";
        Connection con = Connect.getConnection();
        try {
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, cliente.getNome());
            ptm.setString(2, cliente.getEmail());
            ptm.setString(3, cliente.getTelefone());
            ptm.setString(4, cliente.getCnpj());
            ptm.setString(5, cliente.getPayment());
            int row = ptm.executeUpdate();
            if (row == 1) {      //Verifica se uma linha foi alterada no banco
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.releaseCon();
        }
        return false;
    }

    //Exclui cliente do banco
    public boolean excluirCliente(ClienteJuridico cliente) throws SQLException {
        String sql = "DELETE FROM ClientesJuridicos WHERE Codigo= ?";
        Connection con = Connect.getConnection();
        try {
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, String.valueOf(cliente.getCodigo()));
            int row = ptm.executeUpdate();
            if (row == 1) {      //Verifica se uma linha foi alterada no banco
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.releaseCon();
        }
        return false;
    }

    //Lista Clientes do banco
    public Vector listarClientes() throws Exception {
        Vector clientes = new Vector();
        String sql = "SELECT * FROM ClientesJuridicos";
        Connection con = Connect.getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ClienteJuridico c = new ClienteJuridico();
                c.setCodigo(rs.getInt("Codigo"));
                c.setNome(rs.getString("Nome"));
                c.setEmail(rs.getString("Email"));
                c.setTelefone(rs.getString("Telefone"));
                c.setPayment(rs.getString("payment"));
                c.setCnpj(rs.getString("cnpj"));

                clientes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.releaseCon();
        }
        return clientes;
    }

    //Altera Cliente específico no banco
    public boolean alterarCliente(ClienteJuridico cliente) throws SQLException {
        String sql = "UPDATE Clientes SET Nome= ?, Email= ?, Telefone = ?,cnpj= ?,payment= ? WHERE Codigo= ?";
        Connection con = Connect.getConnection();
        try {
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, cliente.getNome());
            ptm.setString(2, cliente.getEmail());
            ptm.setString(3, cliente.getTelefone());
            ptm.setString(4, cliente.getCnpj());
            ptm.setString(5, cliente.getPayment());
            ptm.setInt(6, (cliente.getCodigo()));

            int row = ptm.executeUpdate();
            if (row == 1) {      //Verifica se uma linha foi alterada no banco
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.releaseCon();
        }
        return false;
    }
}
