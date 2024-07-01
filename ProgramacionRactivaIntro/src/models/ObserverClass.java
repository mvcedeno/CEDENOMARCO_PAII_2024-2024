package models;

public class ObserverClass implements Runnable, Observer{

    int identificacion;
    boolean running = true;

    public ObserverClass(int identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public void run() {
        while(running)
            System.out.println("Hilo de usuario " + identificacion);
    }

    @Override
    public String toString() {
        return "Usuario " + identificacion;
    }

    @Override
    public void notificar() {
        running = false;
    }
}
