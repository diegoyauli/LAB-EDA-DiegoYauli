package Laboratorio5.EjercicioResuelto2;

public class QueueList<T> implements Queue<T> {
    private Node<T> frente;
    private Node<T> fin;

    public QueueList() {
        this.frente = null;
        this.fin = null;
    }

    public void enqueue(T x) {
        Node<T> nuevoNodo = new Node<>(x);
        if (isEmpty()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Cola vacía");
        T valor = frente.getValor();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null; // si se elimina el último nodo
        }
        return valor;
    }

    public T front() {
        if (isEmpty()) throw new IllegalStateException("Cola vacía");
        return frente.getValor();
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> actual = frente;
        while (actual != null) {
            str.append(actual.getValor()).append(", ");
            actual = actual.getSiguiente();
        }
        return str.toString();
    }
}

