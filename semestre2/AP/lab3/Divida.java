public class Divida {

    private static final double JUROS_DIARIO = 0.00033;
    private static final double TAXA_MULTA = 0.02;

    private String nomeDevedor;
    private double valorDivida;
    private double valorMulta;
    private double valorJuros;
    private double valorAPagar;
    private int diasEmAtraso;

    public Divida(String nomeDevedor, double valorDivida, int diasEmAtraso) {
        this.nomeDevedor = nomeDevedor;
        this.valorDivida = valorDivida;
        this.diasEmAtraso = diasEmAtraso;
        atualizarValoresCalculados();
    }

    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
        atualizarValoresCalculados();
    }

    public double getValorJuros() {
        return valorJuros;
    }

    private void setValorJuros() {
        valorJuros = JUROS_DIARIO * diasEmAtraso * valorDivida;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    private void setValorMulta() {
        valorMulta = TAXA_MULTA * valorDivida;
    }

    public double getValorAPagar() {
        return valorMulta;
    }

    private void setValorAPagar() {
        valorAPagar = valorMulta + valorJuros + valorDivida;
    }

    public int getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setDiasEmAtraso(int diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
        atualizarValoresCalculados();
    }

    //centraliza as chamadas de setter dos campos calculados
    private void atualizarValoresCalculados() {
        setValorJuros();
        setValorMulta();
        setValorAPagar();
    }
}
