package models;

public class HiloUsuario extends Thread implements Runnable{

    int identificacion;
    boolean running = true;

    public HiloUsuario(int identificacion) {
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

    public void actualizar(){
        running = false;
    }
}
