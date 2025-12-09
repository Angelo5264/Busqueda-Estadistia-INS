package EstructurasAlgoritmos.Pila;

public class Pila <T>{
    private Nodo<T> cima;

    /**
     * Devuelve si la pila esta vacia
     * @return boleano
     */
    public boolean isEmpty() {
        return cima == null;
    }

    /**
     * Insertar en la cima
     * @param dato Objeto
     */
    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(cima, dato);
        cima = nuevo;
    }

    /**
     * Eliminar en la cima
     * @return Objeto
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T dato = cima.getDato();
        cima = cima.getNext();
        return dato;
    }

    /**
     * Muestra el elemento de la cima sin haberlo extraido
     * @return Generico
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return cima.getDato();
    }

    /**
     * Muestra la pila
     * @return String
     */
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cima;

        while (actual != null) {
            sb.append(actual.getDato()).append("\n");
            actual = actual.getNext();
        }

        return sb.toString();
    }
}
