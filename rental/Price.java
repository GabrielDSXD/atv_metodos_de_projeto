public abstract class Price {

    public abstract int getCodigoDePreco();

    public abstract double getValor(int diasAlugada);

    public int getPontosBonus(int diasAlugada) {
        return 1;
    }

    public static class Normal extends Price {

        @Override
        public int getCodigoDePreco() {
            return Tape.NORMAL;
        }

        @Override
        public double getValor(int diasAlugada) {
            double valor = 2;
            if (diasAlugada > 2) {
                valor += (diasAlugada - 2) * 1.5;
            }
            return valor;
        }
    }

    public static class Lancamento extends Price {

        @Override
        public int getCodigoDePreco() {
            return Tape.LANCAMENTO;
        }

        @Override
        public double getValor(int diasAlugada) {
            return diasAlugada * 3;
        }

        @Override
        public int getPontosBonus(int diasAlugada) {
            return diasAlugada > 1 ? 2 : 1;
        }
    }

    public static class Infantil extends Price {

        @Override
        public int getCodigoDePreco() {
            return Tape.INFANTIL;
        }

        @Override
        public double getValor(int diasAlugada) {
            double valor = 1.5;
            if (diasAlugada > 3) {
                valor += (diasAlugada - 3) * 1.5;
            }
            return valor;
        }
    }
}