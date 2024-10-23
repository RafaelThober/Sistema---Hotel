package Sistema;
public class Quarto {
    int numero;
    String tipo;
    double precoDiario;
    boolean disponivel;

    public Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true;
    }

    public void ocupar() {
        this.disponivel = false;
    }

    public void desocupar() {
        this.disponivel = true;
    }
}