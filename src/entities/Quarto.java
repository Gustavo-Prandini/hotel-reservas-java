package entities;

public class Quarto {

    private Integer numero;
    private Integer capacidade;
    private Double valorDiaria;


    public Quarto() {
    }

    public Quarto(Integer numero, Integer capacidade, Double valorDiaria) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.valorDiaria = valorDiaria;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(numero);
        sb.append(" | Capacidade: ").append(capacidade);
        sb.append(" | Valor da diária: R$").append(valorDiaria);

        return sb.toString();
    }
}
