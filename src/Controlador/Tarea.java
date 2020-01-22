package Controlador;

import Servidor.ServerImplements;
import Servidor.datosTemp;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;

import javax.sound.midi.SysexMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Tarea extends Thread {

    private final int  WINDOW_SIZE = 10;
    private boolean isActive = true;
    private LineChart<String, Number> chart;

    public XYChart.Series<String, Number> getSeries() {
        return series;
    }

    public XYChart.Series<String, Number> series = new XYChart.Series<>();
    private SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");

    @FXML
    private TextArea txtConsolaHab1;

    public int dato;
    public int datoHumo=1;
    ServerImplements aux;
    Controller GUI;

    @Override
    public void run() {

        while (isActive) {

            System.out.println(this.getName());

            if("Thread-2".equals(this.getName())){

                try {
                    // Simulate heavy processing stuff
                    Thread.sleep(aux.intervaloSeñal*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Integer random = ThreadLocalRandom.current().nextInt(10);

                Platform.runLater(()->{

                    Date now = new Date();

                    recibirDatos(aux.TemperaturaActual);

                    this.series.getData().add(new XYChart.Data<>(formateador.format(now),dato));



                    if (series.getData().size() > WINDOW_SIZE) {
                        series.getData().remove(0);
                    }

                    if(dato!=0){
                        GUI.cambiarTextArea2("Arieacondicionado: ON");
                        GUI.cambiarTextArea1("El cliente esta en la habitacion.");
                        System.out.println("se cambio el texto");
                    }

                    if(aux.clienteActivo == false && aux.esperandoCliente == false){
                        GUI.cambiarTextArea2("Arieacondicionado: OFF");
                        GUI.cambiarTextArea1("El cliente ha habandonado la habitacion");
                        dato=0;
                    }

                    if(dato>=25){
                        GUI.cambiarTextArea2("Arieacondicionado: ON");
                    }

                    if(dato<=22){
                        GUI.cambiarTextArea2("Arieacondicionado: OFF");
                    }
                });
            }

            if ("Thread-3".equals(this.getName())){
                System.out.println(this.getName()+": Sho me encargo del humo :'v");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.runLater(()->{

                    Date now = new Date();

                    recibirDatosHumo(aux.estadoHumo);

                    this.series.getData().add(new XYChart.Data<>(formateador.format(now),datoHumo));



                    if (series.getData().size() > WINDOW_SIZE) {
                        series.getData().remove(0);
                    }

                    if(datoHumo==1){
                        GUI.cambiarTextAreaHumo("OK");
                    }
                    if(datoHumo!=1){
                        try {
                            GUI.mataHermano("EMERGENCY","Aireacondicionado OFF\n !!!EMERGENCIA!!!","Habitacion on FIRE !!!");
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        GUI.lanzarAlarma();
                        this.kill();
                    }

                });

            }

        }
    }

    public void  kill(){
        isActive = false;
    }

    public void recibirDatos(int datos){
        this.dato=datos;
    }

    public void recibirDatosHumo(int datosHumo){
        this.datoHumo=datosHumo;
    }


    public void copiarServerIm(ServerImplements a){
        this.aux = a;
    }

    public void copiarGUI(Controller gui){
        this.GUI = gui;
    }

    public void cambiarFrecuenciaTemp(int frecuenciaTemp) throws Exception {
        this.aux.setIntervaloSeñal(frecuenciaTemp);
        System.out.println("El intervalo deberia ser:"+aux.intervaloSeñal);
    }
}