package Laboratorio3.Propuesto1;

// Clase genérica para implementar una lista enlazada simple
public class List<T> {
    private Node<T> root; // Nodo inicial de la lista
    // Constructor: crea lista vacía
    public List() {
        this.root = null;
    }
    // Verifica si la lista está vacía
    public boolean isEmpty() {
        return root == null;
    }
    // Devuelve el tamaño (número de nodos)
    public int size() {
        int count = 0;
        Node<T> current = root;
        while (current != null) {
            count++;
            current = current.nextNode;
        }
        return count;
    }
    // Inserta un nuevo nodo al inicio
    public void addFirst(T data) {
        root = new Node<>(data, root);
    }
    // Inserta un nuevo nodo al final
    public void addLast(T data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node<T> current = root;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = new Node<>(data);
        }
    }
    // Busca si un valor existe en la lista
    public boolean contains(T data) {
        Node<T> current = root;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.nextNode;
        }
        return false;
    }
    // Elimina la primera aparición de un valor
    public void remove(T data) {
        if (isEmpty()) return;

        // Si el valor está en el primer nodo
        if (root.data.equals(data)) {
            root = root.nextNode;
            return;
        }
        Node<T> prev = root;
        Node<T> current = root.nextNode;
        // Buscar el nodo que contiene el valor
        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.nextNode;
        }
        // Si se encontró el valor, eliminar el nodo
        if (current != null) {
            prev.nextNode = current.nextNode;
        }
    }
    // Representación de la lista como texto
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = root;
        while (current != null) {
            sb.append(current.data);
            if (current.nextNode != null) sb.append(", ");
            current = current.nextNode;
        }
        sb.append("]");
        return sb.toString();
    }
}
