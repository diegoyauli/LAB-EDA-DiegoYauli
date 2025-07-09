package Laboratorio8.EjercicioPropuesto3;

// Clase principal del Árbol B
// Clase que representa el Árbol B
public class BTree<T extends Comparable<T>> {
    private BNode<T> root;
    private int order;

    // Constructor
    public BTree(int order) {
        this.order = order;
        this.root = new BNode<>(order, true);
    }

    // Verifica si el árbol está vacío
    public boolean isEmpty() {
        return root.numKeys == 0;
    }

    // Insertar un valor en el árbol B
    public void insert(T value) {
        BNode<T> r = root;
        if (r.numKeys == order - 1) {  // Si la raíz está llena
            BNode<T> s = new BNode<>(order, false);
            s.children[0] = r;
            split(s, 0);
            root = s;
        }
        insertNonFull(root, value);
    }

    // Divide un nodo lleno
    private void split(BNode<T> parent, int i) {
        BNode<T> fullNode = parent.children[i];
        BNode<T> newNode = new BNode<>(order, fullNode.isLeaf);
        int mid = order / 2;
        
        parent.keys[i] = fullNode.keys[mid];
        parent.numKeys++;

        for (int j = mid + 1; j < order - 1; j++) {
            newNode.keys[j - (mid + 1)] = fullNode.keys[j];
            fullNode.keys[j] = null;
            fullNode.numKeys--;
        }

        if (!fullNode.isLeaf) {
            for (int j = mid + 1; j < order; j++) {
                newNode.children[j - (mid + 1)] = fullNode.children[j];
                fullNode.children[j] = null;
            }
        }
        
        parent.children[i + 1] = newNode;
    }

    // Insertar en un nodo no lleno
    private void insertNonFull(BNode<T> node, T value) {
        int i = node.numKeys - 1;
        if (node.isLeaf) {
            while (i >= 0 && value.compareTo(node.keys[i]) < 0) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = value;
            node.numKeys++;
        } else {
            while (i >= 0 && value.compareTo(node.keys[i]) < 0) {
                i--;
            }
            i++;
            BNode<T> child = node.children[i];
            if (child.numKeys == order - 1) {
                split(node, i);
                if (value.compareTo(node.keys[i]) > 0) {
                    i++;
                }
            }
            insertNonFull(node.children[i], value);
        }
    }

    // Eliminar un valor
    public void remove(T value) {
        remove(root, value);
    }

    // Eliminar un valor recursivamente
    private void remove(BNode<T> node, T value) {
        int i = 0;
        while (i < node.numKeys && value.compareTo(node.keys[i]) > 0) {
            i++;
        }

        if (i < node.numKeys && value.compareTo(node.keys[i]) == 0) {
            if (node.isLeaf) {
                for (int j = i; j < node.numKeys - 1; j++) {
                    node.keys[j] = node.keys[j + 1];
                }
                node.keys[node.numKeys - 1] = null;
                node.numKeys--;
            } else {
                BNode<T> child = node.children[i];
                BNode<T> sibling = node.children[i + 1];
                // Si el hijo tiene suficientes elementos, podemos borrar
                if (child.numKeys > order / 2) {
                    remove(child, value);
                } else if (sibling.numKeys > order / 2) {
                    // Predecesor o sucesor
                    T pred = max(child);
                    node.keys[i] = pred;
                    remove(child, pred);
                }
            }
        }
    }

    // Buscar un valor
    public boolean search(T value) {
        return search(root, value);
    }

    private boolean search(BNode<T> node, T value) {
        int i = 0;
        while (i < node.numKeys && value.compareTo(node.keys[i]) > 0) {
            i++;
        }

        if (i < node.numKeys && value.compareTo(node.keys[i]) == 0) {
            return true;
        }

        if (node.isLeaf) {
            return false;
        }

        return search(node.children[i], value);
    }

    // Obtener el valor mínimo
    public T min() {
        return min(root);
    }

    private T min(BNode<T> node) {
        while (!node.isLeaf) {
            node = node.children[0];
        }
        return node.keys[0];
    }

    // Obtener el valor máximo
    public T max() {
        return max(root);
    }

    private T max(BNode<T> node) {
        while (!node.isLeaf) {
            node = node.children[node.numKeys];
        }
        return node.keys[node.numKeys - 1];
    }

    // Predecesor de un valor
    public T predecessor(T value) {
        return predecessor(root, value);
    }

    private T predecessor(BNode<T> node, T value) {
        // Implementar la lógica de predecesor
        return null;
    }

    // Sucesor de un valor
    public T successor(T value) {
        return successor(root, value);
    }

    private T successor(BNode<T> node, T value) {
        // Implementar la lógica de sucesor
        return null;
    }

    // Convertir el árbol a String
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }

    private void toString(BNode<T> node, StringBuilder sb) {
        if (node == null) return;
        for (int i = 0; i < node.numKeys; i++) {
            sb.append(node.keys[i]).append(" ");
        }
        sb.append("\n");
        if (!node.isLeaf) {
            for (int i = 0; i <= node.numKeys; i++) {
                toString(node.children[i], sb);
            }
        }
    }
}


