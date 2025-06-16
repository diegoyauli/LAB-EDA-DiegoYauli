package Laboratorio6.EjercicioResuelto1;

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

        bst.inorder();    // Salida: 20 30 40 50 60 70 80
        bst.preorder();   // Salida: 50 30 20 40 70 60 80
        bst.postorder();  // Salida: 20 40 30 60 80 70 50
    }
}

