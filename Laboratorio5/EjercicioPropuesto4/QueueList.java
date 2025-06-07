package Laboratorio5.EjercicioPropuesto4;

public class QueueList<T> implements Queue<T> {
    private Node<T> frente;
    private Node<T> fin;
    private int maxSize;
    private int currentSize;

    public QueueList(int maxSize) {
        this.frente = null;
        this.fin = null;
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    public void encolar(T x) {
        if (isFull()) {
            System.out.println("Cola llena, no se puede agregar más elementos.");
            return;
        }
        Node<T> nuevo = new Node<>(x);
        if (isEmpty()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        currentSize++;
    }

    public T desencolar() {
        if (isEmpty()) {
            System.out.println("Cola vacía, no se puede desencolar.");
            return null;
        }
        T valor = frente.getValor();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        currentSize--;
        return valor;
    }

    public T front() {
        if (isEmpty()) {
            System.out.println("Cola vacía.");
            return null;
        }
        return frente.getValor();
    }

    public T back() {
        if (isEmpty()) {
            System.out.println("Cola vacía.");
            return null;
        }
        return fin.getValor();
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void destroyQueue() {
        frente = null;
        fin = null;
        currentSize = 0;
        System.out.println("Cola destruida.");
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Node<T> actual = frente;
        System.out.print("Contenido de la cola: ");
        while (actual != null) {
            System.out.print(actual.getValor() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}

