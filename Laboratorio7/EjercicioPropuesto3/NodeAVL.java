package Laboratorio7.EjercicioPropuesto3;

public class NodeAVL<T extends Comparable<T>> {
    T key;
    NodeAVL<T> left, right;
    int height;

    public NodeAVL(T key) {
        this.key = key;
        this.height = 1;
    }

    public String getId() {
        return key.toString();
    }
}

