package entities;

public class Hospede extends Pessoa {

    private String email;

    public Hospede() {
        super();
    }

    public Hospede(String nome, String documento, String email) {
        super(nome, documento);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getNome());
        sb.append(" | Documento: ").append(getDocumento());
        sb.append(" | E-mail: ").append(getEmail());

        return sb.toString();
    }
}
