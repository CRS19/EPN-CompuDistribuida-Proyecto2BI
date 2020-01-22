package Cliente;

import rmiinterface.RemoteInterface;
import rmiinterface.interfaceSensor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    public interfaceSensor sensor;

    public Cliente() {

        try{

            //Registry miRegistro = LocateRegistry.getRegistry("172.29.65.64",1234);
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            RemoteInterface s = (RemoteInterface) miRegistro.lookup("Prueba");


            //sensor temp a enviar al servidor
       /*    SensorTemperatura sensorTemp = new SensorTemperatura(2);
             miRegistro.rebind("sensor",sensorTemp);*/



/*            do {
                System.out.println(s.estadoTemp());
            }while(s.para());*/
           // s.clienteConectado(true);

            sensor = (interfaceSensor) new SensorTemperatura(2);
            do {
                sensor.setIntervaloSeñal(s.getIntervaloSeñal());
                s.comenzarMonitoreo(sensor);
                sensor.setIntervaloSeñal(s.getIntervaloSeñal());
            }while (s.para());

            System.out.println("Ya no hace nada mas");

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
