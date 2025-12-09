package EstructurasAlgoritmos.Pila;

public class Nodo <T>{
    private Nodo<T> next;
    private T dato;

    public Nodo(Nodo<T> next, T dato) {
        this.next = next;
        this.dato = dato;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public T getDato() {
        return dato;
    }

}
