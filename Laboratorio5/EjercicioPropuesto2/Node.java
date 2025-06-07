package Laboratorio5.EjercicioPropuesto2;

public class Node<T> {
    private T valor;
    private Node<T> siguiente;

    public Node(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public T getValor() {
        return valor;
    }

    public void setSiguiente(Node<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Node<T> getSiguiente() {
        return siguiente;
    }

    public String toString() {
        return valor.toString();
    }
}

