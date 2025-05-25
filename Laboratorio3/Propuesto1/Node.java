package Laboratorio3.Propuesto1;

// Clase genérica para representar un nodo de la lista
public class Node<T> {
    T data; // Dato almacenado en el nodo
    Node<T> nextNode; // Referencia al siguiente nodo
    // Constructor con referencia al siguiente nodo
    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
    // Constructor sin siguiente nodo (último)
    public Node(T data) {
        this(data, null);
    }
    // Representación en texto del nodo
    public String toString() {
        return data.toString();
    }
}

