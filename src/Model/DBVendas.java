package Model;

import Bean.ClienteFisico;
import Bean.ClienteJuridico;
import Bean.Produto;
import Bean.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBVendas {

    //Venda Efetuada no banco
    public boolean venderProduto(Produto produto, Venda venda, ClienteFisico cliente) throws SQLException {
        String sql = "SELECT Quantidade FROM Produtos";
        Connection con = Connect.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int i = rs.getInt(1);

            String sqlc = "SELECT COUNT(1) FROM Clientes WHERE codigo=" + cliente.getCodigo();
            Statement stmtc = con.createStatement();
            ResultSet rsc = stmtc.executeQuery(sqlc);

            if (rsc.getInt(1) > 0) {

                if (i - venda.getQuantidadeVenda() == 0) {
                    String sqli = "DELETE FROM Produtos WHERE Codigo= ?";

                    PreparedStatement ptm = con.prepareStatement(sqli);
                    ptm.setInt(1, produto.getCod());
                    int row = ptm.executeUpdate();      //Apenas deixando um inteiro por precaução
                } else if (i - (venda.getQuantidadeVenda()) >= 0) {
                    String sql2 = "UPDATE Produtos SET Quantidade=? WHERE Codigo=?";
                    PreparedStatement upstm = con.prepareStatement(sql2);
                    upstm.setInt(1, (i - (venda.getQuantidadeVenda())));
                    upstm.setInt(2, produto.getCod());
                    int row = upstm.executeUpdate();    //Apenas deixando um inteiro por precaução
                }
                String sqlv = "INSERT INTO Vendas(NF, Produto, Cliente, Valor) VALUES(?, ?, ?, ?)";
                PreparedStatement ptmv = con.prepareStatement(sqlv);
                ptmv.setInt(1, venda.getNF());
                ptmv.setInt(2, produto.getCod());
                ptmv.setInt(3, cliente.getCodigo());
                ptmv.setFloat(4, getPrecoTotal(produto, venda));

                int row = ptmv.executeUpdate();
                if (row == 1) {     //Verifica se uma linha foi alterada
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.releaseCon();
        }
        return false;
    }
    
    public boolean venderProduto(Produto produto, Venda venda, ClienteJuridico cliente) throws SQLException {
        String sql = "SELECT Quantidade FROM Produtos";
        Connection con = Connect.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int i = rs.getInt(1);

            String sqlc = "SELECT COUNT(1) FROM ClientesJuridicos WHERE codigo=" + cliente.getCodigo();
            Statement stmtc = con.createStatement();
            ResultSet rsc = stmtc.executeQuery(sqlc);

            if (rsc.getInt(1) > 0) {

                if (i - venda.getQuantidadeVenda() == 0) {
                    String sqli = "DELETE FROM Produtos WHERE Codigo= ?";

                    PreparedStatement ptm = con.prepareStatement(sqli);
                    ptm.setInt(1, produto.getCod());
                    int row = ptm.executeUpdate();      //Apenas deixando um inteiro por precaução
                } else if (i - (venda.getQuantidadeVenda()) >= 0) {
                    String sql2 = "UPDATE Produtos SET Quantidade=? WHERE Codigo=?";
                    PreparedStatement upstm = con.prepareStatement(sql2);
                    upstm.setInt(1, (i - (venda.getQuantidadeVenda())));
                    upstm.setInt(2, produto.getCod());
                    int row = upstm.executeUpdate();    //Apenas deixando um inteiro por precaução
                }
                String sqlv = "INSERT INTO VendasJuridicas(NF, Produto, Cliente, Valor) VALUES(?, ?, ?, ?)";
                PreparedStatement ptmv = con.prepareStatement(sqlv);
                ptmv.setInt(1, venda.getNF());
                ptmv.setInt(2, produto.getCod());
                ptmv.setInt(3, cliente.getCodigo());
                ptmv.setFloat(4, getPrecoTotal(produto, venda));

                int row = ptmv.executeUpdate();
                if (row == 1) {     //Verifica se uma linha foi alterada
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.releaseCon();
        }
        return false;
    }

    //Pega o preco do banco
    public float getPrecoTotal(Produto produto, Venda venda) throws SQLException {
        float total = 0;
        Connection con = Connect.getConnection();
        String sqlc = "SELECT Preco FROM Produtos WHERE codigo=" + produto.getCod();
        Statement stmtc = con.createStatement();
        ResultSet rsc = stmtc.executeQuery(sqlc);

        total = rsc.getFloat("Preco") * venda.getQuantidadeVenda();

        return total;
    }
}
