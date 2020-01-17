package sample;

public class Procesos {


    public Tarea getTask() {
        return task;
    }

    public Tarea task = new Tarea();

    public void start() {
        task.start();
    }

    public void stop() {
        task.kill();
    }
}