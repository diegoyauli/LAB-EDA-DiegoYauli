package Laboratorio9.EjercicioPropuesto4;

import java.util.Scanner;

public class TestHashOpenMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese capacidad de la tabla hash: ");
        int capacity = scanner.nextInt();
        HashOpen<String> hashTable = new HashOpen<>(capacity);

        while (true) {
            System.out.println("\n--- MENÚ HASH ABIERTO ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Mostrar tabla");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese clave (entero): ");
                    int key = scanner.nextInt();
                    System.out.print("Ingrese valor (String): ");
                    scanner.nextLine(); // limpiar buffer
                    String value = scanner.nextLine();
                    hashTable.insert(key, value);
                    break;
                case 2:
                    System.out.print("Ingrese clave a buscar: ");
                    key = scanner.nextInt();
                    Register<String> result = hashTable.search(key);
                    System.out.println(result != null ? "Encontrado: " + result : "No encontrado");
                    break;
                case 3:
                    System.out.print("Ingrese clave a eliminar: ");
                    key = scanner.nextInt();
                    hashTable.delete(key);
                    break;
                case 4:
                    hashTable.showTable();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}

