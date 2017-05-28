/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Bean.Produto;
import java.util.Vector;

/**
 *
 * @author Lucas
 */
public class Estoque {

    private Vector produtos = new Vector();

    public String listarProdutos() {
        String listaAux = "";

        for (int i = 0; i < produtos.size(); i++) {
            Produto prdtAux = (Produto) produtos.elementAt(i);
            listaAux += prdtAux.getCod() + ", " + prdtAux.getNome() + " - Qtd " + prdtAux.getQuantidade() + " - R$ " + prdtAux.getPreco() + "\n";
        }

        return listaAux;

    }

    public void removerProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto aux = (Produto) produtos.elementAt(i);
            int o = aux.getCod();
            if (produto.getCod() == o) {
                produtos.removeElementAt(i);
            }
        }
    }

    public void alterarProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto aux = (Produto) produtos.elementAt(i);
            int indice = aux.getCod();
            String novoNome = produto.getNome();
            float novoPreco = produto.getPreco();
            int novaQuantidade = produto.getQuantidade();
            if (produto.getCod() == indice) {
                Produto novoProduto = new Produto();
                novoProduto.setCod(indice);
                novoProduto.setNome(novoNome);
                novoProduto.setPreco(novoPreco);
                novoProduto.setQuantidade(novaQuantidade);
                produtos.setElementAt(novoProduto, i);
            }
        }
    }

    public void adicionarProduto(Produto produto) {
        produtos.addElement(produto);
    }
}
