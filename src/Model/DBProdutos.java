package Model;

import Bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DBProdutos {

    public boolean inserirProduto(Produto produto) throws SQLException {    //Insere produto no banco
        String sql = "INSERT INTO Produtos(Nome, Quantidade, Preco) VALUES(?, ?, ?)";
        Connection con = Connect.getConnection();
        try {
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, produto.getNome());
            ptm.setInt(2, produto.getQuantidade());
            ptm.setString(3, String.valueOf(produto.getPreco()));
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

    public boolean excluirProduto(Produto produto) throws SQLException { //Exclui produto no banco
        String sql = "DELETE FROM Produtos WHERE Codigo= ?";
        Connection con = Connect.getConnection();
        try {
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setInt(1, produto.getCod());
            int row = ptm.executeUpdate();
            if (row == 1) {         //Verifica se uma linha foi alterada no banco
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.releaseCon();
        }
        return false;
    }

    public Vector listarProdutos() throws Exception {   //Lista os produtos do banco
        Vector produtos = new Vector();
        String sql = "SELECT * FROM Produtos";
        Connection con = Connect.getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Produto p = new Produto();
                p.setCod(rs.getInt("Codigo"));
                p.setNome(rs.getString("Nome"));
                p.setQuantidade(rs.getInt("Quantidade"));
                p.setPreco(rs.getFloat("Preco"));

                produtos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.releaseCon();
        }
        return produtos;
    }

    public boolean alterarProduto(Produto produto) throws SQLException {    //Altera um registro do banco
        String sql = "UPDATE Produtos SET Nome= ?, Quantidade= ?, Preco = ? WHERE Codigo= ?";
        Connection con = Connect.getConnection();
        try {
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, produto.getNome());
            ptm.setInt(2, (produto.getQuantidade()));
            ptm.setString(3, String.valueOf(produto.getPreco()));
            ptm.setInt(4, (produto.getCod()));

            int row = ptm.executeUpdate();
            if (row == 1) { //Verifica se uma linha foi alterada no banco
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
