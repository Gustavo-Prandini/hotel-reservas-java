package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private Hospede hospede;
    private Quarto quarto;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private StatusReserva statusReserva;

    public Reserva() {
    }

    public Reserva(Hospede hospede, StatusReserva statusReserva, LocalDate checkIn, LocalDate checkOut, Quarto quarto) {
        this.hospede = hospede;
        this.statusReserva = statusReserva;
        this.checkOut = checkOut;
        this.checkIn = checkIn;
        this.quarto = quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }

    public long calculoDuracaoEstadia() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public double valorTotalReserva() {
       return calculoDuracaoEstadia() * quarto.getValorDiaria();
    }

    public void cancelarReserva() {
        if (statusReserva == StatusReserva.ATIVA) {
            System.out.println("Reserva cancelada!");
            statusReserva = StatusReserva.CANCELADA;
        } else {
            System.out.println("A reserva já foi finalizada ou cancelada!");
        }
    }

    public String resumoReserva() {
        StringBuilder sb = new StringBuilder();

        sb.append("Hospede: ").append(hospede).append("\n");
        sb.append("Quarto: ").append(quarto).append("\n");
        sb.append("Check-in: ").append(checkIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        sb.append("Check-out: ").append(checkOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        sb.append("Status da reserva: ").append(statusReserva).append("\n");
        sb.append("Valor total da reserva: ").append(valorTotalReserva()).append("\n");
        sb.append("Duração da estadia: ").append(calculoDuracaoEstadia()).append(" dias");

        return sb.toString();
    }
}
