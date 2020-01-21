package Servidor;

import java.io.Serializable;

public class datosTemp implements Serializable {
    public int temperaturaActual=0;

    public int getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(int temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }
}
