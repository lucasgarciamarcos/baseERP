package Control;

import Bean.ClienteFisico;
import Bean.ClienteJuridico;
import Bean.Venda;
import Bean.Produto;
import Model.DBVendas;
import java.sql.SQLException;

public class Vender {

    private DBVendas con = new DBVendas();  //Conexão
    //Efetuar Venda

    public boolean venderProduto(Produto produto, Venda venda, ClienteFisico cliente) throws SQLException {
        String d1 = (String.valueOf((int) (Math.random() * 10)));
        String d2 = (String.valueOf((int) (Math.random() * 10)));      //Simulação de nota fiscal
        String d3 = (String.valueOf((int) (Math.random() * 10)));
        String d4 = (String.valueOf((int) (Math.random() * 10)));
        String d5 = (String.valueOf((int) (Math.random() * 10)));
        String nf = (d1 + d2 + d3 + d4 + d5);
        venda.setNF(Integer.parseInt(nf));
        return con.venderProduto(produto, venda, cliente);
    }
    
        public boolean venderProduto(Produto produto, Venda venda, ClienteJuridico cliente) throws SQLException {
        String d1 = (String.valueOf((int) (Math.random() * 10)));
        String d2 = (String.valueOf((int) (Math.random() * 10)));      //Simulação de nota fiscal
        String d3 = (String.valueOf((int) (Math.random() * 10)));
        String d4 = (String.valueOf((int) (Math.random() * 10)));
        String d5 = (String.valueOf((int) (Math.random() * 10)));
        String nf = (d1 + d2 + d3 + d4 + d5);
        venda.setNF(Integer.parseInt(nf));
        return con.venderProduto(produto, venda, cliente);
    }

    //Controle de total gerado na view
    public String getTotal(Produto produto, Venda venda) throws SQLException {
        String result = String.valueOf(con.getPrecoTotal(produto, venda));
        return result;
    }
}
