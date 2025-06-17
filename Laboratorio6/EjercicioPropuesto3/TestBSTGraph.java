package Laboratorio6.EjercicioPropuesto3;

public class TestBSTGraph {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(20);
        bst.insert(75);
        bst.insert(6);
        bst.insert(8);
        bst.insert(32);
        bst.insert(10);

        bst.printTreeGraph();
    }
}
