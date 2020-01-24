package Cliente;

import rmiinterface.RemoteInterface;
import rmiinterface.interfaceHumo;
import rmiinterface.interfaceSensor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    public interfaceSensor sensor;
    public interfaceHumo sensorHumo;

    public Cliente() {

        try{

            //Registry miRegistro = LocateRegistry.getRegistry("172.29.65.64",1234);
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            RemoteInterface s = (RemoteInterface) miRegistro.lookup("Prueba");


            //sensor temp a enviar al servidor
       /*    SensorTemperatura sensorTemp = new SensorTemperatura(2);
             miRegistro.rebind("sensor",sensorTemp);*/


            sensor = (interfaceSensor) new SensorTemperatura(2);
            sensorHumo = (interfaceHumo) new SensorHumo(5);
            do {
                sensor.setIntervaloSeñal(s.getIntervaloSeñal());
                s.comenzarMonitoreo(sensor);
                s.comerzarMonitoreoHumo(sensorHumo);
                sensor.setIntervaloSeñal(s.getIntervaloSeñal());
            }while (estaCliente());

            s.finalizarMonitoreo();

            System.out.println("Ya no hace nada mas");

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean estaCliente(){
        int x;
        int n = 5;
        int m = 0;

        x = (int) Math.floor(Math.random()*(n-m+1)+m);
        if(x==3){
            return false;
        }   else {
            return true;
        }
    }
}
