package Sistema;
import java.util.Scanner;

public class SistemaHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        int opcao = 0;
        do {
            System.out.println("\nSeja bem-vindo ao Gerenciador de Hotel! Escolha uma opção:\n");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Check-in");
            System.out.println("4. Check-out");
            System.out.println("5. Relatório de Ocupação de Quartos");
            System.out.println("6. Histórico de Reservas");
            System.out.println("0. Sair\n");
            System.out.print("");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de quarto (solteiro, casal, suite): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double preco = scanner.nextDouble();
                    hotel.cadastrarQuarto(numero, tipo, preco);
                }
                case 2 -> {
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Data de Check-in (dd/mm/aaaa): ");
                    String checkIn = scanner.nextLine();
                    System.out.print("Data de Check-out (dd/mm/aaaa): ");
                    String checkOut = scanner.nextLine();
                    System.out.print("Tipo de quarto (solteiro, casal, suite): ");
                    String tipoQuarto = scanner.nextLine();
                    hotel.cadastrarReserva(nomeHospede, checkIn, checkOut, tipoQuarto);
                }
                case 3 -> {
                    System.out.print("Nome do hóspede para Check-in: ");
                    String nomeCheckIn = scanner.nextLine();
                    hotel.checkIn(nomeCheckIn);
                }
                case 4 -> {
                    System.out.print("Nome do hóspede para Check-out: ");
                    String nomeCheckOut = scanner.nextLine();
                    hotel.checkOut(nomeCheckOut);
                }
                case 5 -> hotel.relatorioOcupacao();
                case 6 -> {
                    System.out.print("Nome do hóspede para histórico de reservas: ");
                    String nomeHistorico = scanner.nextLine();
                    hotel.historicoReservas(nomeHistorico);
                }
                case 0 -> System.out.println("Obrigado por utilizar nosso sistema!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
