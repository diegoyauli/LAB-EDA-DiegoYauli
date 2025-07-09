package Laboratorio8.EjercicioResuelto1;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    public BNode(int n) {
        this.keys = new ArrayList<E>(n);
        this.childs = new ArrayList<BNode<E>>(n + 1);
        this.count = 0;
        for (int i = 0; i < n; i++) {
            this.keys.add(null);
        }
        for (int i = 0; i <= n; i++) {
            this.childs.add(null);
        }
    }

    public boolean nodeFull(int max) {
        return count == max;
    }

    public boolean nodeEmpty() {
        return count == 0;
    }

    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < count && key.compareTo(keys.get(pos[0])) > 0) {
            pos[0]++;
        }
        if (pos[0] < count && key.compareTo(keys.get(pos[0])) == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < count; i++) {
            s += keys.get(i);
            if (i < count - 1) s += ", ";
        }
        s += "]";
        return s;
    }
}

