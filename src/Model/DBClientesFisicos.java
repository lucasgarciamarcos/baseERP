package Model;

import Bean.ClienteFisico;
import Bean.Venda;
import Bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DBClientesFisicos {

    //Insere Cliente ao banco
    public boolean inserirCliente(ClienteFisico cliente) throws SQLException {
        String sql = "INSERT INTO Clientes(Nome, Email, Telefone, CPF, Card) VALUES(?, ?, ?, ?, ?)";
        Connection con = Connect.getConnection();
        try {
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, cliente.getNome());
            ptm.setString(2, cliente.getEmail());
            ptm.setString(3, cliente.getTelefone());
            ptm.setString(4, cliente.getCpf());
            ptm.setString(5, cliente.getCreditCard());
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
    public boolean excluirCliente(ClienteFisico cliente) throws SQLException {
        String sql = "DELETE FROM Clientes WHERE Codigo= ?";
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
        String sql = "SELECT * FROM Clientes";
        Connection con = Connect.getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ClienteFisico c = new ClienteFisico();
                c.setCodigo(rs.getInt("Codigo"));
                c.setNome(rs.getString("Nome"));
                c.setEmail(rs.getString("Email"));
                c.setTelefone(rs.getString("Telefone"));
                c.setCreditCard(rs.getString("Card"));
                c.setCpf(rs.getString("CPF"));

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
    public boolean alterarCliente(ClienteFisico cliente) throws SQLException {
        String sql = "UPDATE Clientes SET Nome= ?, Email= ?, Telefone = ?,CPF= ?,Card= ? WHERE Codigo= ?";
        Connection con = Connect.getConnection();
        try {
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, cliente.getNome());
            ptm.setString(2, cliente.getEmail());
            ptm.setString(3, cliente.getTelefone());
            ptm.setString(4, cliente.getCpf());
            ptm.setString(5, cliente.getCreditCard());
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
