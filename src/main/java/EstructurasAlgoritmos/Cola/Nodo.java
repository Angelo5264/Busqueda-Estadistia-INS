package EstructurasAlgoritmos.Cola;

public class Nodo <T>{
    private Nodo<T> next;
    private T dato;

    public Nodo( T dato){
        this.dato=dato;
        this.next=null;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> nodo) {
        this.next = nodo;
    }

    public T getDato() {
        return dato;
    }
}
