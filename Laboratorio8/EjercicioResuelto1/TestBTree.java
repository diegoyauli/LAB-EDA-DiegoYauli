package Laboratorio8.EjercicioResuelto1;

public class TestBTree {
    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>(4); // Orden 4 (máx 3 claves por nodo)
        int[] valores = {100, 200, 300, 400, 500, 50};

        for (int x : valores) {
            System.out.println("Insertando: " + x);
            btree.insert(x);
            System.out.println(btree);
        }
    }
}

