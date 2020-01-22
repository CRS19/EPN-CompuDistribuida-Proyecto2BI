package Cliente;

import rmiinterface.interfaceHumo;

public class SensorHumo extends Thread implements interfaceHumo {

    public int intervaloSeñal;
    public int estadoActual;

    SensorHumo(int intervalo){
        this.intervaloSeñal=intervalo;
    }

    public int obtenerEstado() throws InterruptedException {
        int estado;
        int n = 3;
        int m = 1;
        Thread.sleep(intervaloSeñal*1000);
        if(2 == (int) Math.floor(Math.random()*(n-m+1)+m)){
            this.estadoActual=100;
            return estado = 100;
        }else{
            this.estadoActual=1;
            return estado = 1;
        }
    }
}
