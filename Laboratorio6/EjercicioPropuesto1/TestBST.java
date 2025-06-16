package Laboratorio6.EjercicioPropuesto1;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.inOrder();   // 20 30 40 50 60 70 80
        bst.preOrder();  // 50 30 20 40 70 60 80
        bst.postOrder(); // 20 40 30 60 80 70 50

        System.out.println("Min: " + bst.min());            // 20
        System.out.println("Max: " + bst.max());            // 80
        System.out.println("Predecessor of 60: " + bst.predecessor(60)); // 50
        System.out.println("Successor of 60: " + bst.successor(60));     // 70

        System.out.println("Search 40: " + bst.search(40)); // true
        System.out.println("Search 100: " + bst.search(100)); // false

        bst.remove(70);
        bst.inOrder(); // sin el 70

        bst.destroy();
        System.out.println("Is empty after destroy: " + bst.isEmpty()); // true
    }
}

