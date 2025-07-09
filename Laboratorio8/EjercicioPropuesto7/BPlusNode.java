package Laboratorio8.EjercicioPropuesto7;

import java.util.ArrayList;

public class BPlusNode<T extends Comparable<T>> {
    boolean isLeaf;
    ArrayList<T> keys;
    ArrayList<BPlusNode<T>> children;
    BPlusNode<T> next; // Apunta al siguiente nodo hoja

    public BPlusNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return keys.toString();
    }
}

