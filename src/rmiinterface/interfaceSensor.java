package rmiinterface;

import java.io.Serializable;


public interface interfaceSensor extends Serializable {
    int medirTemperatura()throws Exception;
    int getIntervaloSeñal() throws Exception;
    void setIntervaloSeñal(int intervaloSeñal) throws Exception;
    int getTemperaturaActual() throws Exception;
    void run()throws Exception;

}
