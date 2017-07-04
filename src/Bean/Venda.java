package Bean;

public class Venda {
    //Atributos de uma Venda
    private int quantidadeCompra;
    private int NF;
    private float valor;

    //Encapsulamento
    public int getQuantidadeVenda() {
        return quantidadeCompra;
    }

    public void setQuantidadeVenda(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    /**
     * @return the NF
     */
    public int getNF() {
        return NF;
    }

    /**
     * @param NF the NF to set
     */
    public void setNF(int NF) {
        this.NF = NF;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
}
