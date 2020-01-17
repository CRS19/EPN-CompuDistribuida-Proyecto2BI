package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

public class Controller {

    @FXML
    private LineChart<String, Number> grapHab1;

    @FXML
    private LineChart<String, Number> grapHab2;

    Procesos procesoHab1;
    Procesos procesoHab2;

    @FXML
    public void initialize() {

        procesoHab1 = new Procesos();
        procesoHab2 = new Procesos();
        grapHab1.getData().add(procesoHab1.task.getSeries());
        grapHab2.getData().add(procesoHab2.task.getSeries());
    }

    public void start(javafx.event.ActionEvent actionEvent) {
        procesoHab1.start();
        procesoHab2.start();
    }

    public void stop(javafx.event.ActionEvent actionEvent) {
        procesoHab1.stop();
        procesoHab2.stop();
    }
}
