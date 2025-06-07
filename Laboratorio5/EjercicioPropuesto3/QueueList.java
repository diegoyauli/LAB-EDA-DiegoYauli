package Laboratorio5.EjercicioPropuesto3;

public class QueueList<T> implements Queue<T> {
    private Node<T> frente;
    private Node<T> fin;

    public QueueList() {
        this.frente = null;
        this.fin = null;
    }

    public void enqueue(T x){
        Node<T> nuevo = new Node<>(x);
        if (isEmpty()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public T dequeue(){
        if (isEmpty()) throw new IllegalStateException("Cola vacía");
        T valor = frente.getValor();
        frente = frente.getSiguiente();
        if (frente == null) fin = null; // si se vació la cola
        return valor;
    }

    public T front(){
        if (isEmpty()) throw new IllegalStateException("Cola vacía");
        return frente.getValor();
    }

    public boolean isEmpty(){
        return frente == null;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        Node<T> actual = frente;
        while (actual != null){
            str.append(actual.getValor()).append(", ");
            actual = actual.getSiguiente();
        }
        return str.toString();
    }
}

