package models;



public interface Observable {

    void notificarTodos();
    void agregarObserver(Observer obsever);
    void removerObserver(Observer observer);
}

