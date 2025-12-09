package EstructurasAlgoritmos.Cola;

public class Cola <T>{
    private Nodo<T> inicio;
    private Nodo<T> fin;

    /**
     * Verifica si la cola esta vacia
     * @return Retorna un booleano
     */
    public boolean isEmpty(){
        return inicio ==null;
    }

    /**
     * Inserta datos a la cola
     * @param dato Dato a insetar
     */
    public void encolar(T dato){
        Nodo<T> nodo= new Nodo<>(dato);
        if(isEmpty()){
            inicio =nodo;
            fin=nodo;
        }else{
            fin.setNext(nodo);
            fin=nodo;
        }
    }

    /**
     * Extrae elementos de la cola
     * @return un objeto de la cola
     */
    public T desencolar() {
        if (isEmpty()) {
            return null;
        }
        T temp = inicio.getDato();
        inicio = inicio.getNext();

        if (inicio == null) {
            fin = null;
        }

        return temp;
    }

    /**
     * Consultar cima
     * @return El objeto sin sacarlo de la cola
     */
    public T consultarCima(){
        if(isEmpty()){
            return null;
        }else {
            return inicio.getDato();
        }

    }

}
