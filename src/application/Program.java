package application;

import entities.Hospede;
import entities.Quarto;
import entities.Reserva;
import entities.StatusReserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception{
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite quantos hospedes deseja incluir na reserva: ");
        int nHospedes = sc.nextInt();
        sc.nextLine();

        List<Hospede> hospedeList = new ArrayList<>();

        /// Realizando um loop para cadastrar os hospedes

        for (int i=0; i<nHospedes; i++) {
            System.out.println("Hospede #" + (i+1) + ":");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Documento: ");
            String documento = sc.nextLine();
            System.out.print("E-mail: ");
            String email = sc.nextLine();

            Hospede hospedes = new Hospede(nome, documento, email);
            hospedeList.add(hospedes);
        }

        System.out.print("Digite quantos quartos deseja criar: ");
        int nQuartos = sc.nextInt();
        sc.nextLine();

        List<Quarto> quartoList = new ArrayList<>();

        /// Realizando um loop para cadastrar os quartos

        for (int i=0; i<nQuartos; i++) {
            System.out.println("Quarto #" + (i+1) + ": ");
            System.out.print("Numero do quarto: ");
            Integer numero = sc.nextInt();
            sc.nextLine();
            System.out.print("Capacidade do quarto: ");
            Integer capacidade = sc.nextInt();
            sc.nextLine();
            System.out.print("Valor da diária: R$ ");
            Double valorDiaria = sc.nextDouble();
            sc.nextLine();

            Quarto quartos = new Quarto(numero, capacidade, valorDiaria);
            quartoList.add(quartos);
        }

        System.out.print("Digite quantas reservas gostaria de fazer: ");
        int nReservas = sc.nextInt();
        sc.nextLine();

        List<Reserva> reservaList = new ArrayList<>();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        /// Verificando se a quantidade de reservas é maior que a de hospedes informados
        /// Realizando um loop para cadastrar as reservas

        if (nReservas > nHospedes) {
            System.out.println("Não há hospedes o suficiente para realizar as reservas");
        } else {
            for (int i=0; i<nReservas; i++) {
                Hospede hospedeEscolhido = hospedeList.get(i);
                Quarto quartoEscolhido = quartoList.get(i);

                System.out.print("Digite a data do Check-In #" + (i+1) + ": ");
                String checkInString = sc.nextLine();
                LocalDate checkIn = LocalDate.parse(checkInString.trim(), fmt);
                System.out.print("Digite a data do Check-Out #" + (i+1) + ": ");
                String checkOutString = sc.nextLine();
                LocalDate checkOut = LocalDate.parse(checkOutString.trim(), fmt);

                if (checkOut.isBefore(checkIn)) {
                    System.out.println("O Check-Out não pode ser antes do Check-In");
                } else {
                    Reserva reservas = new Reserva(hospedeEscolhido, StatusReserva.ATIVA, checkIn, checkOut, quartoEscolhido);
                    reservaList.add(reservas);
                }

            }
        }

        /// Imprimindo o resumo das reservas

        System.out.println("Resumo das reservas: ");
        for (Reserva r : reservaList) {
            System.out.println(r.resumoReserva());
        }

        /// Testando os metodos das classes

        System.out.println("Qual o numero do quarto que deseja cancelar a reserva:");
        int buscaQuarto = sc.nextInt();
        sc.nextLine();

        for (Reserva r : reservaList) {
            if (buscaQuarto == r.getQuarto().getNumero()) {
                r.cancelarReserva();
            } else {
                System.out.println("Não foi encontrado nenhum quarto com esse número!");
            }
        }


        sc.close();
    }
}
