package Bean;

public class ClienteJuridico extends Cliente {  //Herança

    private String cnpj;    //Atributos de um Cliente Jurídico
    private String payment;
    //Encapsulamento
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
