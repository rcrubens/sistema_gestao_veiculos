final class Carga extends Veiculo implements Calcular {

    private int cargaMax;
    private int tara;

    public Carga() {
        this.cargaMax = 0;
        this.tara =0;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public double calcVel() {
        return getVelocMax() * 100000;
    }

    public int calcular() {
        int somaNum = 0;

        somaNum += getMotor().getQtdPist();
        somaNum += getMotor().getPotencia();
        somaNum += getQtdRodas();
        somaNum += getVelocMax();
        somaNum += getTara();
        somaNum += getCargaMax();
    

        return somaNum;
    }
    
}