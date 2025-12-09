package EstructurasAlgoritmos.Lista;

public class Nodo <T>{
    private Nodo next;
    private T dato;

    public Nodo(Nodo next, T dato) {
        this.next = next;
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public T getDato() {
        return dato;
    }

}
