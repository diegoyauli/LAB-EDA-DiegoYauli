package Laboratorio4.Propuesto5;

import java.util.Scanner;

public class TestListaSimple {
    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();
        Scanner sc = new Scanner(System.in);

        // Insertar elementos del 1 al 10 inicialmente
        for (int i = 1; i <= 10; i++) {
            lista.insert(i);
        }

        int opcion;
        do {
            System.out.println("\n--- Menú Lista Enlazada Simple ---");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Insertar al final");
            System.out.println("3. Agregar al inicio");
            System.out.println("4. Agregar al final");
            System.out.println("5. Eliminar por clave");
            System.out.println("6. Eliminar por posición");
            System.out.println("7. Eliminar primer nodo");
            System.out.println("8. Eliminar último nodo");
            System.out.println("9. Tamaño de la lista");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Lista: ");
                    lista.printList();
                    break;
                case 2:
                    System.out.print("Dato a insertar al final: ");
                    int datoFin = sc.nextInt();
                    lista.insert(datoFin);
                    break;
                case 3:
                    System.out.print("Dato a agregar al inicio: ");
                    int datoIni = sc.nextInt();
                    lista.addFirst(datoIni);
                    break;
                case 4:
                    System.out.print("Dato a agregar al final: ");
                    int datoFin2 = sc.nextInt();
                    lista.addLast(datoFin2);
                    break;
                case 5:
                    System.out.print("Clave a eliminar: ");
                    int clave = sc.nextInt();
                    lista.deleteByKey(clave);
                    break;
                case 6:
                    System.out.print("Posición a eliminar (0-based): ");
                    int pos = sc.nextInt();
                    lista.deleteAtPosition(pos);
                    break;
                case 7:
                    lista.removeFirst();
                    System.out.println("Primer nodo eliminado.");
                    break;
                case 8:
                    lista.removeLast();
                    System.out.println("Último nodo eliminado.");
                    break;
                case 9:
                    System.out.println("Tamaño de la lista: " + lista.size());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

