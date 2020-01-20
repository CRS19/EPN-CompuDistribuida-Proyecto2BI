package Servidor;

import rmiinterface.RemoteInterface;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

public class ServerImplements extends UnicastRemoteObject implements RemoteInterface {

    String condi="0";

    public ServerImplements() throws Exception{
        super();
    }


    @Override
    public int estadoTemp(){
        int x;
        int n = 35;
        int m = 18;

        x = (int) Math.floor(Math.random()*(n-m+1)+m);
        return x;
    }
    @Override
    public boolean para() throws InterruptedException{

        if (Integer.parseInt(condi)== 1) {
            return false;
        }else{
            Thread.sleep(2000);
            return  true;
        }
    }

    public void condic(){
        String condi =  JOptionPane.showInputDialog("Apagar aire acondicionado");
        this.condi = condi;
    }


}