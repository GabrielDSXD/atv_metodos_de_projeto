public class Tape {
    public static final int NORMAL     = 0;
    public static final int LANCAMENTO = 1;
    public static final int INFANTIL   = 2;

    private String titulo;
    private Price price;

    public Tape(String titulo, int codigoDePreco) {
        this.titulo = titulo;
        setCodigoDePreco(codigoDePreco);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCodigoDePreco() {
        return price.getCodigoDePreco();
    }

    public void setCodigoDePreco(int codigoDePreco) {
        switch (codigoDePreco) {
            case LANCAMENTO: price = new Price.Lancamento(); break;
            case INFANTIL:   price = new Price.Infantil();   break;
            default:         price = new Price.Normal();     break;
        }
    }

    public double getValor(int diasAlugada) {
        return price.getValor(diasAlugada);
    }

    public int getPontosBonus(int diasAlugada) {
        return price.getPontosBonus(diasAlugada);
    }
}