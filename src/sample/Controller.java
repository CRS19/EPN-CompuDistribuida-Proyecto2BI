package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    private LineChart<String, Number> grapHab1;

    Procesos proceso;

    @FXML
    public void initialize() {

        proceso = new Procesos();
        grapHab1.getData().add(proceso.task.getSeries());
    }

    public void start(javafx.event.ActionEvent actionEvent) {
        proceso.start();
    }

    public void stop(javafx.event.ActionEvent actionEvent) {
        proceso.stop();
    }
}
