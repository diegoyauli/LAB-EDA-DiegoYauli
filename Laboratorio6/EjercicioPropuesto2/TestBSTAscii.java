package Laboratorio6.EjercicioPropuesto2;

import java.util.Scanner;

public class TestBSTAscii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST<Integer> bst = new BST<>();

        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.nextLine();

        for (char c : palabra.toCharArray()) {
            int ascii = (int) c;
            bst.insert(ascii);
            System.out.println("Insertado '" + c + "' (ASCII: " + ascii + ")");
        }

        System.out.println("\nRecorridos del árbol:");
        bst.inOrder();    // Muestra caracteres en orden creciente por ASCII
        bst.preOrder();   // Raíz primero
        bst.postOrder();  // Raíz al final

        scanner.close();
    }
}
