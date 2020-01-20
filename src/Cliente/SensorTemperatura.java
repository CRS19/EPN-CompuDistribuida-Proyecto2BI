package Cliente;

import rmiinterface.interfaceSensor;
import java.rmi.server.UnicastRemoteObject;

public class SensorTemperatura extends UnicastRemoteObject implements interfaceSensor {

        int intervaloSeñal;

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
        }
}
