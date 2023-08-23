final class Passeio extends Veiculo implements Calcular  {

    private int qtdPassageiros;

    public Passeio() {
        this.qtdPassageiros = 0;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    public double calcVel() {
        return getVelocMax() * 1000;
    }

    public int calcular() {
        int somaLetras = 0;

        somaLetras += getPlaca().length();
        somaLetras += getMarca().length();
        somaLetras += getModelo().length();
        somaLetras += getCor().length();

        return somaLetras;
    }
    
}