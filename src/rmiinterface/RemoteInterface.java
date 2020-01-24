package rmiinterface;

import java.io.Serializable;
import java.rmi.Remote;

/**
 *
 * @author HP
 */
public interface RemoteInterface extends Remote {

    public int estadoTemp()throws  Exception;
    public boolean para() throws Exception;
    public void comenzarMonitoreo(interfaceSensor sensor) throws Exception;
    void clienteConectado(boolean conexion) throws Exception;
    public int getIntervaloSeñal() throws Exception;
    public void finalizarMonitoreo() throws Exception;
    public void comerzarMonitoreoHumo(interfaceHumo sensorHumo) throws Exception;


    //public setTiempoTemp() throws Exception;

}