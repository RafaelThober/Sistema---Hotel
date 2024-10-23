package Sistema;
import java.util.ArrayList;

public class Hotel {
    ArrayList<Quarto> quartos;
    ArrayList<Reserva> reservas;

    public Hotel() {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        Quarto quarto = new Quarto(numero, tipo, precoDiario);
        quartos.add(quarto);
        System.out.println("\nQuarto cadastrado com sucesso!\n");
    }

    public void cadastrarReserva(String nomeHospede, String dataCheckIn, String dataCheckOut, String tipoQuarto) {
        Reserva reserva = new Reserva(nomeHospede, dataCheckIn, dataCheckOut);
        for (Quarto quarto : quartos) {
            if (quarto.tipo.equals(tipoQuarto) && quarto.disponivel) {
                reserva.adicionarQuarto(quarto);
                quarto.ocupar();
                System.out.println("\nReserva realizada com sucesso para o hóspede " + nomeHospede);
                reservas.add(reserva);
                return;
            }
        }
        System.out.println("Nenhum quarto disponível do tipo solicitado.");
    }
    public void checkIn(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.nomeHospede.equals(nomeHospede)) {
                System.out.println("Check-in realizado para o hóspede " + nomeHospede);
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    public void checkOut(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.nomeHospede.equals(nomeHospede)) {
                double custoTotal = 0;
                long dias = reserva.calcularDiasEstadia();
                for (Quarto quarto : reserva.quartosReservados) {
                    quarto.desocupar();
                    custoTotal += quarto.precoDiario * dias;
                }
                System.out.println("Check-out realizado para o hóspede " + nomeHospede);
                System.out.println("Custo total da estadia: R$ " + custoTotal);
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    public void relatorioOcupacao() {
        System.out.println("Relatório de ocupação de quartos:");
        for (Quarto quarto : quartos) {
            String status = quarto.disponivel ? "Disponível" : "Ocupado";
            System.out.println("Quarto " + quarto.numero + " - Tipo: " + quarto.tipo + " - Preço: R$ " + quarto.precoDiario + " - Status: " + status);
        }
    }

    public void historicoReservas(String nomeHospede) {
        System.out.println("Histórico de reservas para o hóspede " + nomeHospede + ":");
        for (Reserva reserva : reservas) {
            if (reserva.nomeHospede.equals(nomeHospede)) {
                System.out.println("Data de Check-in: " + reserva.dataCheckIn + " - Check-out: " + reserva.dataCheckOut);
                for (Quarto quarto : reserva.quartosReservados) {
                    System.out.println("Quarto " + quarto.numero + " - Tipo: " + quarto.tipo + " - Preço diário: R$ " + quarto.precoDiario);
                }
            }
        }
    }
}
