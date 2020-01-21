package Cliente;

import rmiinterface.interfaceSensor;
import java.rmi.server.UnicastRemoteObject;

public class SensorTemperatura implements interfaceSensor {

        public int intervaloSeñal;

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
        public int medirTemperatura(){
            int medida;
            int n = 35;
            int m = 18;

            medida = (int) Math.floor(Math.random()*(n-m+1)+m);
            return medida;
          //  Thread.sleep(intervaloSeñal);
        }
}
