package models;

import java.util.ArrayList;
import java.util.List;

public class SistemaVenta {

    int totalTickets = 100;
    List<HiloUsuario> poolUsuarios = new ArrayList();

    public String listarConexiones(){
        String listado = "";
        for(HiloUsuario hilo:poolUsuarios){
            listado = listado + hilo.toString() + "\n";
        }
        return listado;
    }

    public void subscribir(HiloUsuario hiloUsuario){
        poolUsuarios.add(hiloUsuario);
    }

    public void notificarUsuarios(){
        for(HiloUsuario hilo:poolUsuarios) {
            hilo.actualizar();
        }
    }

    public SistemaVenta() {
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public List<HiloUsuario> getPoolUsuarios() {
        return poolUsuarios;
    }
}
