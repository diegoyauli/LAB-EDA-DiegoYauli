package     Laboratorio8.EjercicioPropuesto8;

public class BPlusTree<T extends Comparable<T>> {
    private BPlusNode<T> root;
    private int maxKeys;

    public BPlusTree(int maxKeys) {
        this.maxKeys = maxKeys;
        this.root = new BPlusNode<>(true);
    }

    public boolean isEmpty() {
        return root == null || root.keys.isEmpty();
    }

    public void destroy() {
        root = new BPlusNode<>(true);
    }

    public void insert(T value) {
        // Lógica para insertar valor y dividir si es necesario
    }

    public void remove(T value) {
        // Lógica para eliminar
    }

    public boolean search(T value) {
        // Retorna true si existe
        return false;
    }

    public T min() {
        // Buscar el mínimo valor
        return null;
    }

    public T max() {
        // Buscar el máximo valor
        return null;
    }

    public T predecessor(T value) {
        // Retornar predecesor
        return null;
    }

    public T successor(T value) {
        // Retornar sucesor
        return null;
    }

    public String toString() {
        return writeTree();
    }

    public String writeTree() {
        // Mostrar estructura del árbol
        return ""; // Recorre por niveles
    }

    private void fuseNode() {
        // Implementación de fusión
    }

    private void dividedNode() {
        // Implementación de división
    }
}
