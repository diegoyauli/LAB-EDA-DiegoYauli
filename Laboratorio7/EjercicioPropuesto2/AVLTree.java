package Laboratorio7.EjercicioPropuesto2;

public class AVLTree<T extends Comparable<T>> {

    private NodeAVL<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    public void destroy() {
        root = null;
    }

    private int height(NodeAVL<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(NodeAVL<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private NodeAVL<T> rightRotate(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        y.left = x.right;
        x.right = y;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private NodeAVL<T> leftRotate(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public void insert(T key) {
        root = insertRec(root, key);
    }

    private NodeAVL<T> insertRec(NodeAVL<T> node, T key) {
        if (node == null) return new NodeAVL<>(key);

        if (key.compareTo(node.data) < 0)
            node.left = insertRec(node.left, key);
        else if (key.compareTo(node.data) > 0)
            node.right = insertRec(node.right, key);
        else return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Rotaciones necesarias
        if (balance > 1 && key.compareTo(node.left.data) < 0)
            return rightRotate(node);

        if (balance < -1 && key.compareTo(node.right.data) > 0)
            return leftRotate(node);

        if (balance > 1 && key.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public boolean search(T key) {
        return searchRec(root, key);
    }

    private boolean searchRec(NodeAVL<T> node, T key) {
        if (node == null) return false;
        if (key.compareTo(node.data) == 0) return true;
        return key.compareTo(node.data) < 0 ?
            searchRec(node.left, key) : searchRec(node.right, key);
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(NodeAVL<T> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(NodeAVL<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(NodeAVL<T> node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    public T min() {
        NodeAVL<T> curr = root;
        while (curr.left != null) curr = curr.left;
        return curr.data;
    }

    public T max() {
        NodeAVL<T> curr = root;
        while (curr.right != null) curr = curr.right;
        return curr.data;
    }

    public void remove(T key) {
        root = removeRec(root, key);
    }

    private NodeAVL<T> removeRec(NodeAVL<T> root, T key) {
        if (root == null) return root;

        if (key.compareTo(root.data) < 0)
            root.left = removeRec(root.left, key);
        else if (key.compareTo(root.data) > 0)
            root.right = removeRec(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                root = (root.left != null) ? root.left : root.right;
            } else {
                NodeAVL<T> temp = getMinNode(root.right);
                root.data = temp.data;
                root.right = removeRec(root.right, temp.data);
            }
        }

        if (root == null) return null;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private NodeAVL<T> getMinNode(NodeAVL<T> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Métodos de predecesor y sucesor
    public T predecessor(T key) {
        NodeAVL<T> curr = root, pred = null;
        while (curr != null) {
            if (key.compareTo(curr.data) > 0) {
                pred = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return pred != null ? pred.data : null;
    }

    public T successor(T key) {
        NodeAVL<T> curr = root, succ = null;
        while (curr != null) {
            if (key.compareTo(curr.data) < 0) {
                succ = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return succ != null ? succ.data : null;
    }
}
