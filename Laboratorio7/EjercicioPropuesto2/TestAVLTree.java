package Laboratorio7.EjercicioPropuesto2;

import java.util.Scanner;

public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        int option, value;

        do {
            System.out.println("\n--- MENÚ ÁRBOL AVL ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mostrar InOrder");
            System.out.println("5. Mostrar PreOrder");
            System.out.println("6. Mostrar PostOrder");
            System.out.println("7. Mínimo");
            System.out.println("8. Máximo");
            System.out.println("9. Predecesor");
            System.out.println("10. Sucesor");
            System.out.println("11. Destruir árbol");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    tree.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Valor a eliminar: ");
                    tree.remove(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Valor a buscar: ");
                    System.out.println(tree.search(sc.nextInt()) ? "Encontrado" : "No encontrado");
                    break;
                case 4:
                    tree.inOrder();
                    break;
                case 5:
                    tree.preOrder();
                    break;
                case 6:
                    tree.postOrder();
                    break;
                case 7:
                    System.out.println("Mínimo: " + tree.min());
                    break;
                case 8:
                    System.out.println("Máximo: " + tree.max());
                    break;
                case 9:
                    System.out.print("Valor: ");
                    System.out.println("Predecesor: " + tree.predecessor(sc.nextInt()));
                    break;
                case 10:
                    System.out.print("Valor: ");
                    System.out.println("Sucesor: " + tree.successor(sc.nextInt()));
                    break;
                case 11:
                    tree.destroy();
                    System.out.println("Árbol destruido.");
                    break;
            }
        } while (option != 0);
    }
}
