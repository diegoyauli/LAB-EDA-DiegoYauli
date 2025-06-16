package Laboratorio6.EjercicioResuelto1;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        this.root = null;
    }

    // Inserción
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> node, T data) {
        if (node == null) return new Node<>(data);
        if (data.compareTo(node.data) < 0)
            node.left = insertRec(node.left, data);
        else
            node.right = insertRec(node.right, data);
        return node;
    }

    // Recorrido INORDEN: izquierda - nodo - derecha
    public void inorder() {
        System.out.print("Inorden: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node<T> node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    // Recorrido PREORDEN: nodo - izquierda - derecha
    public void preorder() {
        System.out.print("Preorden: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    // Recorrido POSTORDEN: izquierda - derecha - nodo
    public void postorder() {
        System.out.print("Postorden: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node<T> node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }
}


