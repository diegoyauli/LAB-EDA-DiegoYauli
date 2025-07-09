package Laboratorio8.EjercicioPropuesto4;

// Clase que representa un nodo de un árbol B
public class BNode<T> {
    // Arreglo de claves
    T[] keys;
    // Arreglo de hijos
    BNode<T>[] children;
    // Indica el número de claves actualmente almacenadas
    int numKeys;
    // Indica si el nodo es hoja
    boolean isLeaf;

    // Constructor
    @SuppressWarnings("unchecked")
    public BNode(int order, boolean isLeaf) {
        this.keys = (T[]) new Object[order - 1];
        this.children = new BNode[order];
        this.numKeys = 0;
        this.isLeaf = isLeaf;
    }
}
