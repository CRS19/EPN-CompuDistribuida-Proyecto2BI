package Servidor;

import rmiinterface.RemoteInterface;
import rmiinterface.interfaceSensor;

import java.io.FileWriter;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

public class ServerImplements extends UnicastRemoteObject implements RemoteInterface {

    String condi="0";
    public int intervaloSeñal=0;
    public int TemperaturaActual=0; //Aqui se guarda la temperatura
    public boolean clienteConectado = false;
    datosTemp datos;
    FileWriter salidaTemp = new FileWriter("temphab1.txt");

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

    @Override
    public void comenzarMonitoreo(interfaceSensor sensor) throws Exception {
            this.intervaloSeñal = sensor.getIntervaloSeñal();
            this.TemperaturaActual=sensor.medirTemperatura();
//            datos.setTemperaturaActual(this.TemperaturaActual);
            System.out.println(this.getTemperaturaActual());

    }

    @Override
    public void clienteConectado(boolean conexion) throws Exception {
        this.clienteConectado = conexion;
    }

    public void condic(){
        String condi =  JOptionPane.showInputDialog("Apagar aire acondicionado");
        this.condi = condi;
    }

    public datosTemp enviarDatos(){
        return datos;
    }

    //GETTERS Y SETTERS
    public String getCondi() {
        return condi;
    }

    public void setCondi(String condi) {
        this.condi = condi;
    }

    public int getIntervaloSeñal() {
        return intervaloSeñal;
    }

    public void setIntervaloSeñal(int intervaloSeñal) {
        this.intervaloSeñal = intervaloSeñal;
    }

    public int getTemperaturaActual() {
        return TemperaturaActual;
    }

    public void setTemperaturaActual(int temperaturaActual) {
        TemperaturaActual = temperaturaActual;
    }

    public boolean isClienteConectado() {
        return clienteConectado;
    }

    public void setClienteConectado(boolean clienteConectado) {
        this.clienteConectado = clienteConectado;
    }

}