package Laboratorio7.EjercicioResuelto1;

public class NodeAVL<T extends Comparable<T>> {
    public T data;
    public NodeAVL<T> left;
    public NodeAVL<T> right;
    public int bf; // balance factor (factor de equilibrio)

    public NodeAVL(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.bf = 0;
    }
}
