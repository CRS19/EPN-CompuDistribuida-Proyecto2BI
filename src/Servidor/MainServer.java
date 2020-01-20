package Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {
    public static void main (String args[]){
        try {
            //System.setProperty("java.rmi.server.hostname","192.168.43.48");
            Registry miRegistry = LocateRegistry.createRegistry(1234);
            ServerImplements a = new ServerImplements();
            miRegistry.rebind("Prueba", a);
            System.out.println("SERVIDOR ON My Nigga");
            a.condic();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


