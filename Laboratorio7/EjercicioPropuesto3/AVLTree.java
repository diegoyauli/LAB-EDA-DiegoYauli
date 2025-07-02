package Laboratorio7.EjercicioPropuesto3;

public class AVLTree<T extends Comparable<T>> {
    private NodeAVL<T> root;

    public void insert(T key) {
        root = insertRec(root, key);
    }

    public NodeAVL<T> getRoot() {
        return root;
    }

    private NodeAVL<T> insertRec(NodeAVL<T> node, T key) {
        if (node == null) return new NodeAVL<>(key);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insertRec(node.left, key);
        else if (cmp > 0) node.right = insertRec(node.right, key);
        else return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private int height(NodeAVL<T> node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(NodeAVL<T> node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private NodeAVL<T> rotateRight(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        NodeAVL<T> T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private NodeAVL<T> rotateLeft(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        NodeAVL<T> T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private NodeAVL<T> balance(NodeAVL<T> node) {
        int balance = getBalance(node);
        if (balance > 1 && getBalance(node.left) >= 0)
            return rotateRight(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0)
            return rotateLeft(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }
}