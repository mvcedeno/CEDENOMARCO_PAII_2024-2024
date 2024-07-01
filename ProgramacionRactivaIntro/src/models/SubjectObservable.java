package models;

import java.util.ArrayList;
import java.util.List;

public class SubjectObservable implements Observable{

    int totalTickets = 100;
    List<Observer> poolObservers = new ArrayList();

    public String listarConexiones(){
        String listado = "";
        for(Observer observer:poolObservers){
            listado = listado + observer.toString() + "\n";
        }
        return listado;
    }

    public SubjectObservable() {
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public List<Observer> getPoolUsuarios() {
        return poolObservers;
    }

    @Override
    public void notificarTodos() {
        for(Observer observer:poolObservers) {
            observer.notificar();
        }
    }

    @Override
    public void agregarObserver(Observer obsever) {
        poolObservers.add(obsever);
    }

    @Override
    public void removerObserver(Observer observer) {
        poolObservers.remove(observer);
    }
}
