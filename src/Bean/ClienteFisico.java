package Bean;

public class ClienteFisico extends Cliente { //Herança

    private String CPF;     //Atributos de um Cliente físico
    private String creditCard;

    //Encapsulamento
    public String getCpf() {
        return CPF;
    }

    public void setCpf(String CPF) {
        this.CPF = CPF;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
