package Sistema;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Reserva {
    String nomeHospede;
    String dataCheckIn;
    String dataCheckOut;
    ArrayList<Quarto> quartosReservados;

    public Reserva(String nomeHospede, String dataCheckIn, String dataCheckOut) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.quartosReservados = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        this.quartosReservados.add(quarto);
    }

    public long calcularDiasEstadia() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate checkIn = LocalDate.parse(this.dataCheckIn, formatter);
        LocalDate checkOut = LocalDate.parse(this.dataCheckOut, formatter);
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }
}
