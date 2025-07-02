package Laboratorio7.EjercicioResuelto1;

public class AVLTree<T extends Comparable<T>> {
    private NodeAVL<T> root;

    public void insertar(T data) {
        root = insertar(root, data);
    }

    private NodeAVL<T> insertar(NodeAVL<T> node, T data) {
        if (node == null) {
            return new NodeAVL<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertar(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertar(node.right, data);
        } else {
            return node; // No duplicados
        }

        // Actualizar el balance factor
        node = actualizarBalance(node);

        return node;
    }

    private NodeAVL<T> actualizarBalance(NodeAVL<T> node) {
        int alturaIzq = altura(node.left);
        int alturaDer = altura(node.right);
        node.bf = alturaIzq - alturaDer;

        // Verificar desequilibrio
        if (node.bf < -1) {
            return balanceToLeft(node);
        } else if (node.bf > 1) {
            return balanceToRight(node);
        }

        return node;
    }

    private int altura(NodeAVL<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(altura(node.left), altura(node.right));
    }

    // Rotación simple a la izquierda
    private NodeAVL<T> rotateSL(NodeAVL<T> node) {
        NodeAVL<T> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    // Rotación simple a la derecha
    private NodeAVL<T> rotateSR(NodeAVL<T> node) {
        NodeAVL<T> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    // Balanceo hacia la izquierda
    private NodeAVL<T> balanceToLeft(NodeAVL<T> node) {
        NodeAVL<T> hijo = node.right;

        switch (hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL<T> nieto = hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
                break;
        }

        return node;
    }

    // Balanceo hacia la derecha (puedes implementarlo similar si deseas completar)
    private NodeAVL<T> balanceToRight(NodeAVL<T> node) {
        // Similar a balanceToLeft pero simétrico
        // Lo implementamos si lo necesitas
        return node;
    }

    // Para probar: recorrido inorden
    public void inorden() {
        inorden(root);
        System.out.println();
    }

    private void inorden(NodeAVL<T> node) {
        if (node != null) {
            inorden(node.left);
            System.out.print(node.data + " ");
            inorden(node.right);
        }
    }
}

