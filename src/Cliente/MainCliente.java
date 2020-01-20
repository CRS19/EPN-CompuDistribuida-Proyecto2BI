package Cliente;

import rmiinterface.RemoteInterface;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class MainCliente {
    public static void main(String args[]){
        try{

            //Registry miRegistro = LocateRegistry.getRegistry("192.168.43.48",1234);
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);

            RemoteInterface s = (RemoteInterface) miRegistro.lookup("Prueba");

            do {
                System.out.println(s.estadoTemp());
            }while(s.para());


        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


