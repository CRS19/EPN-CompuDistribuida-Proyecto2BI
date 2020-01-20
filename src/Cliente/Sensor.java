package Cliente;

public abstract class Sensor {

    int intervaloSeñal;
    String name;

    public Sensor(int intervalo) {
        this.intervaloSeñal=intervalo;
    }

    public int getIntervaloSeñal() {
        return intervaloSeñal;
    }

    public void setIntervaloSeñal(int intervaloSeñal) {
        this.intervaloSeñal = intervaloSeñal;
    }
}
