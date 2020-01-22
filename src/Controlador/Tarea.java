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
    ServerImplements aux;
    Controller GUI;

    @Override
    public void run() {

        while (isActive) {

            System.out.println("Hilo "+this.getName()+": Estoy ejecutando :'v");

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


            });

        }
    }

    public void  kill(){
        isActive = false;
    }

    public void recibirDatos(int datos){
        this.dato=datos;
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