package Control;

import Bean.Produto;
import Model.DBProdutos;
import java.util.Vector;
import java.sql.SQLException;

public class Estoque {

    private Vector produtos = new Vector(); //Memória do estoque
    private DBProdutos con = new DBProdutos();  //Conexão com DB

    public Vector listarProdutos() throws SQLException, Exception {
        Vector vec = con.listarProdutos();  //Listagem dos produtos para a view
        return vec;
    }

    public boolean removerProduto(Produto produto) throws SQLException {
        return con.excluirProduto(produto);    //Controle de remoção do produto
    }

    public boolean alterarProduto(Produto produto) throws SQLException {
        return con.alterarProduto(produto);    //Controle de alteração do produto
    }

    public boolean adicionarProduto(Produto produto) throws SQLException {
        return con.inserirProduto(produto);    //Controle de adição de produto
    }
}
