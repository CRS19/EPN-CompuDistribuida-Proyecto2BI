package Cliente;

import rmiinterface.RemoteInterface;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class MainCliente {
    public static void main(String args[]){
        try{

           // Registry miRegistro = LocateRegistry.getRegistry("172.29.64.213",1234);
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);

            RemoteInterface s = (RemoteInterface) miRegistro.lookup("Prueba");


            //sensor temp a enviar al servidor
       /*     SensorTemperatura sensorTemp = new SensorTemperatura(2);
            miRegistro.rebind("sensor",sensorTemp);*/



            do {
                System.out.println(s.estadoTemp());
            }while(s.para());





        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


