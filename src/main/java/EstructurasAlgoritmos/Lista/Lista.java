package EstructurasAlgoritmos.Lista;

import ArchivosCSV.RegistroCovid;
import EstructurasAlgoritmos.Cola.Cola;

public class Lista <T>{
    private Nodo<T> cabeza;

    /**
     * Verifica si la lista esta vacia
     * @return booleano
     */
    public boolean isEmpty() {
        return cabeza == null;
    }

    /**
     * Inserta un elemento al inicio de la lista
     * @param dato objeto
     */
    public void insertarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(cabeza, dato);
        cabeza = nuevo;
    }

    /**
     * Inserta un elemento al final de la lista
     * @param dato Objeto
     */
    public void insertarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(null, dato);

        if (isEmpty()) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getNext() != null) {
                actual = (Nodo<T>) actual.getNext();
            }
            actual.setNext(nuevo);
        }
    }

    /**
     * Eliminamos un elemento de la lista
     * @param dato Objeto
     * @return Objeto
     */
    public boolean eliminar(T dato) {
        if (isEmpty()) return false;

        // Si está en la cabeza
        if (cabeza.getDato().equals(dato)) {
            cabeza = (Nodo<T>) cabeza.getNext();
            return true;
        }

        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;

        while (actual != null && !actual.getDato().equals(dato)) {
            anterior = actual;
            actual = (Nodo<T>) actual.getNext();
        }

        if (actual == null) return false;

        anterior.setNext(actual.getNext());
        return true;
    }
    //posible cambio con interfaces
    /**
     * crear una interfz con los metodos a buscar
     * y luego agregar al principio de la lista "<T extends interface>"
     * luego cambiamos el mmetodo buscar asi
     * public boolean buscarPorNombre(String nombre) {
     *     Nodo<T> actual = cabeza;
     *
     *     while (actual != null) {
     *         if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
     *             return true;
     *         }
     *         actual = (Nodo<T>) actual.getNext();
     *     }
     *
     *     return false;
     * }
     */

    /**
     * Busca un elemento en la lista
     * @param dato Objeto
     * @return
     */
    public boolean buscar(T dato) {
        Nodo<T> actual = cabeza;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = (Nodo<T>) actual.getNext();
        }

        return false;
    }

    /**
     * Muestra la lista
     * @return String
     */
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cabeza;

        while (actual != null) {
            sb.append(actual.getDato()).append(" -> ");
            actual = (Nodo<T>) actual.getNext();
        }

        sb.append("null");
        return sb.toString();
    }
    public Cola<RegistroCovid> filtrarResultadoEnCola(String resultado) {
        Cola<RegistroCovid> cola = new Cola<>();
        Nodo<T> actual = cabeza;

        while (actual != null) {
            RegistroCovid r = (RegistroCovid) actual.getDato();

            if (r.getResultado().equalsIgnoreCase(resultado)) {
                cola.encolar(r);
            }
            actual = actual.getNext();
        }

        return cola;
    }





}
