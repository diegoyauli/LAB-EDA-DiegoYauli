package Laboratorio4.Resuelto4;
public class LinkedList {
    Node head; // Cabecera de la lista

    // Nodo de lista enlazada
    // Esta clase interna se hace estática para que main() pueda acceder a ella
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // ************** INSERCION **************
    // Método para insertar un nuevo nodo
    public static LinkedList insert(LinkedList list, int data) {
        // Crea un nuevo nodo con los datos dados
        Node new_node = new Node(data);
        new_node.next = null;

        // Si la lista enlazada está vacía, convierte el nuevo nodo en la cabeza
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Recorre hasta el último nodo e inserta el nuevo nodo allí
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    // ************** RECORRIDO **************
    // Método para imprimir la lista enlazada
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.print("\nLinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("\n");
    }

    // ************** BORRADO POR DATO **************
    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node currNode = list.head, prev = null;

        // CASO 1: El nodo principal tiene el dato
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println(key + " found and deleted");
            return list;
        }

        // CASO 2: El dato está en otro nodo
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            // Desenlaza currNode de la lista enlazada
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        // CASO 3: El dato no está presente
        if (currNode == null) {
            System.out.println(key + " not found");
        }

        return list;
    }

    // ************** BORRADO POR POSICIÓN **************
    public static LinkedList deleteAtPosition(LinkedList list, int index) {
        Node currNode = list.head, prev = null;

        // CASO 1: índice 0, eliminar cabeza
        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println(index + " position element deleted");
            return list;
        }

        // CASO 2: índice válido en medio o final
        int counter = 0;
        while (currNode != null) {
            if (counter == index) {
                prev.next = currNode.next;
                System.out.println(index + " position element deleted");
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // CASO 3: índice fuera de rango
        if (currNode == null) {
            System.out.println(index + " position element not found");
        }

        return list;
    }

    // ************** MÉTODO PRINCIPAL **************
    public static void main(String[] args) {
        // Inicia con una lista vacía
        LinkedList list = new LinkedList();

        // Inserta valores
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Imprime la lista
        printList(list);

        // Elimina el nodo con valor 1 (cabeza)
        deleteByKey(list, 1);
        printList(list);

        // Elimina el nodo con valor 4 (en medio)
        deleteByKey(list, 4);
        printList(list);

        // Elimina el nodo con valor 10 (no existe)
        deleteByKey(list, 10);
        printList(list);

        // Elimina el nodo en posición 0
        deleteAtPosition(list, 0);
        printList(list);

        // Elimina el nodo en posición 2
        deleteAtPosition(list, 2);
        printList(list);

        // Intenta eliminar nodo en posición 10 (fuera de rango)
        deleteAtPosition(list, 10);
        printList(list);
    }
}
