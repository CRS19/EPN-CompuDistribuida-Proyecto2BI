package Controlador;

public class Procesos {

    public Tarea task = new Tarea();

    public Tarea getTask() {
        return task;
    }

    public void start() {
        task.start();
    }

    public void stop() {
        task.kill();
    }
}