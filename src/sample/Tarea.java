package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.awt.*;
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




        @Override
        public void run() {

            while (isActive) {

                System.out.println("Hilo "+this.getName()+": Estoy ejecutando :'v");

                try {
                    // Simulate heavy processing stuff
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Integer random = ThreadLocalRandom.current().nextInt(10);

                Platform.runLater(()->{

                    Date now = new Date();

                    this.series.getData().add(new XYChart.Data<>(formateador.format(now),random));

                    if (series.getData().size() > WINDOW_SIZE) {
                        series.getData().remove(0);
                    }
                });

            }
        }

        public void  kill(){
            isActive = false;
        }

}

