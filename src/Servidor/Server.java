package Servidor;
import VistaGUI.Main;
import rmiinterface.interfaceSensor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Server {
    public  ServerImplements a;
    public Server(){
        try {
            //System.setProperty("java.rmi.server.hostname","192.168.43.48");
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            Registry miRegistry = LocateRegistry.createRegistry(1234);
             a = new ServerImplements();
            miRegistry.rebind("Prueba", a);
            System.out.println("SERVIDOR ON My Nigga");

             //a.condic();

           System.out.println(a.isClienteConectado());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
