package Controlador;

import Servidor.Server;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private LineChart<String, Number> grapHab1;

    @FXML
    private TextArea txtConsolaHab1;

    @FXML
    private TextArea txtConsolaHab2;


    @FXML
    private LineChart<String, Number> grapHab2;

    @FXML
    private TextField txtCambioFrecuenciaTemp;

    Procesos procesoHab1;
  //  Procesos procesoHab2;

    @FXML
    public void initialize() {
        Server serverHab1 = new Server();
        procesoHab1 = new Procesos();
        //Construir la tarea
        procesoHab1.task.copiarServerIm(serverHab1.a);
        procesoHab1.task.copiarGUI(this);
        txtConsolaHab2.setText("Esperando cliente...");
        txtConsolaHab1.setText("Esperando cliente...");
  //      procesoHab2 = new Procesos();
        grapHab1.getData().add(procesoHab1.task.getSeries());
   //     grapHab2.getData().add(procesoHab2.task.getSeries());
        grapHab1.setAnimated(false);
    }

    @FXML
    public void start(javafx.event.ActionEvent actionEvent) {
        procesoHab1.start();
  //      procesoHab2.start();
    }

    @FXML
    public void stop(javafx.event.ActionEvent actionEvent) {
        procesoHab1.stop();
  //      procesoHab2.stop();
    }

    public void cambiarTextArea2(String msg){
        this.txtConsolaHab2.setText(msg);
    }
    public void cambiarTextArea1(String msg){
        this.txtConsolaHab1.setText(msg);
    }

    @FXML
    public void cambiarFrecuenciaTemp(javafx.event.ActionEvent actionEvent) throws Exception {

        procesoHab1.task.cambiarFrecuenciaTemp(
                Integer.parseInt(this.txtCambioFrecuenciaTemp.getText()
                ));
    }

}
