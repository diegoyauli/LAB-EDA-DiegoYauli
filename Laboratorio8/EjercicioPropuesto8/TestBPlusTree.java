package Laboratorio8.EjercicioPropuesto8;

import java.util.Scanner;

public class TestBPlusTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BPlusTree<Integer> tree = new BPlusTree<>(3);
        int option, value;

        do {
            System.out.println("\n---- MENÚ ÁRBOL B+ ----");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Mínimo");
            System.out.println("5. Máximo");
            System.out.println("6. Predecesor");
            System.out.println("7. Sucesor");
            System.out.println("8. Mostrar árbol");
            System.out.println("9. Destruir árbol");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    value = sc.nextInt();
                    tree.insert(value);
                    break;
                case 2:
                    System.out.print("Valor a eliminar: ");
                    value = sc.nextInt();
                    tree.remove(value);
                    break;
                case 3:
                    System.out.print("Valor a buscar: ");
                    value = sc.nextInt();
                    System.out.println("Encontrado: " + tree.search(value));
                    break;
                case 4:
                    System.out.println("Mínimo: " + tree.min());
                    break;
                case 5:
                    System.out.println("Máximo: " + tree.max());
                    break;
                case 6:
                    System.out.print("Valor: ");
                    value = sc.nextInt();
                    System.out.println("Predecesor: " + tree.predecessor(value));
                    break;
                case 7:
                    System.out.print("Valor: ");
                    value = sc.nextInt();
                    System.out.println("Sucesor: " + tree.successor(value));
                    break;
                case 8:
                    System.out.println("Árbol:\n" + tree.writeTree());
                    break;
                case 9:
                    tree.destroy();
                    System.out.println("Árbol destruido.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }
}
