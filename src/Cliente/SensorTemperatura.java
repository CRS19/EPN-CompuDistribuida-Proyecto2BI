package Cliente;

import rmiinterface.interfaceSensor;
import java.rmi.server.UnicastRemoteObject;

public class SensorTemperatura extends Thread implements interfaceSensor {

        public int intervaloSeñal;
        public boolean activo = false;
        public int temperaturaActual;

    public int getIntervaloSeñal() {
        return intervaloSeñal;
    }

    public void setIntervaloSeñal(int intervaloSeñal) {
        this.intervaloSeñal = intervaloSeñal;
    }

    SensorTemperatura(int intervalo)throws  Exception{
            super();
            this.intervaloSeñal=intervalo;
        }

        @Override
        public int medirTemperatura() throws InterruptedException {
            int medida;
            int n = 35;
            int m = 18;
            Thread.sleep(intervaloSeñal*1000);
            medida = (int) Math.floor(Math.random()*(n-m+1)+m);
            this.temperaturaActual = medida;
            return medida;
        }


        //GETTERS Y SETTERS


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(int temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }
}

