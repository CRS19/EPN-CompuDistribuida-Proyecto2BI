package rmiinterface;

import java.rmi.Remote;

/**
 *
 * @author HP
 */
public interface RemoteInterface extends Remote {

    public int estadoTemp()throws  Exception;
    public boolean para() throws Exception;
    //public setTiempoTemp() throws Exception;

}