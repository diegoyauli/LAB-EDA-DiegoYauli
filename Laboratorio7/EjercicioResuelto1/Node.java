package Laboratorio7.EjercicioResuelto1;

public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    // Constructor
    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Getter y Setter para data
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Getter y Setter para left
    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    // Getter y Setter para right
    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    // Método toString para imprimir fácilmente el nodo
    @Override
    public String toString() {
        return data.toString();
    }
}

