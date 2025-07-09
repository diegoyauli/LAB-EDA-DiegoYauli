package Laboratorio8.EjercicioPropuesto4;

import java.util.Scanner;

public class TestBTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<Integer> tree = new BTree<>(3);  // Orden 3

        while (true) {
            System.out.println("Menu de operaciones:");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mínimo");
            System.out.println("5. Máximo");
            System.out.println("6. Mostrar Árbol");
            System.out.println("7. Salir");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Ingrese valor a insertar:");
                    int insertVal = sc.nextInt();
                    tree.insert(insertVal);
                    break;
                case 2:
                    System.out.println("Ingrese valor a eliminar:");
                    int removeVal = sc.nextInt();
                    tree.remove(removeVal);
                    break;
                case 3:
                    System.out.println("Ingrese valor a buscar:");
                    int searchVal = sc.nextInt();
                    System.out.println(tree.search(searchVal) ? "Valor encontrado" : "Valor no encontrado");
                    break;
                case 4:
                    System.out.println("Mínimo: " + tree.min());
                    break;
                case 5:
                    System.out.println("Máximo: " + tree.max());
                    break;
                case 6:
                    System.out.println("Árbol actual:");
                    System.out.println(tree);
                    break;
                case 7:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}


