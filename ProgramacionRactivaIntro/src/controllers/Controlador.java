package controllers;

import models.HiloUsuario;
import models.SistemaVenta;

public class Controlador {

    int contadorHiloUsuario = 0;
    SistemaVenta sistemaVenta;

    public Controlador(){
        sistemaVenta = new SistemaVenta();
    }

    public void crearHiloUsuario(){
        sistemaVenta.subscribir(new HiloUsuario(contadorHiloUsuario++));
        sistemaVenta.getPoolUsuarios().getLast().start();
    }

    public String listarHiloUsuario(){
        return sistemaVenta.listarConexiones();
    }

    public void comprarTickets(int numeroTickets){
        HiloUsuario primerHilo = sistemaVenta.getPoolUsuarios().getFirst();
        primerHilo.actualizar();
        sistemaVenta.getPoolUsuarios().remove(primerHilo);
        sistemaVenta.setTotalTickets(sistemaVenta.getTotalTickets() - numeroTickets);
    }

    public void evaluarTickets(){
        if(sistemaVenta.getTotalTickets() <= 0){
            sistemaVenta.notificarUsuarios();
        }
    }

    public int getTotalTickets(){
        return sistemaVenta.getTotalTickets();
    }

}
