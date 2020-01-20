package rmiinterface;

import java.rmi.Remote;

public interface interfaceSensor extends Remote {
    int medirTemperatura()throws Exception;
}
