package Laboratorio4.Resuelto3;
public class LinkedList {
    Node head; // Cabecera de la lista

    // Nodo de lista enlazada.
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

    // Método para insertar un nuevo nodo
    public static LinkedList insert(LinkedList list, int data) {
        // Crea un nuevo nodo con los datos dados
        Node new_node = new Node(data);
        new_node.next = null;

        // Si la lista está vacía, convierte el nuevo nodo en la cabeza
        if (list.head == null) {
            list.head = new_node;
        } else {
            // De lo contrario, recorre hasta el último nodo e inserta el nuevo nodo allí
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

        // Retorna la lista desde la cabeza
        return list;
    }

    // Método para imprimir la lista enlazada
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");

        // Recorre la lista enlazada
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }

        System.out.println();
    }

    // Método para eliminar un nodo en la LinkedList por posición
    public static LinkedList deleteAtPosition(LinkedList list, int index) {
        // Guarda el nodo cabecera
        Node currNode = list.head, prev = null;

        // CASO 1: Si el índice es 0, elimina la cabecera
        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println(index + " position element deleted");
            return list;
        }

        // CASO 2: Si el índice es mayor que 0
        int counter = 0;

        while (currNode != null) {
            if (counter == index) {
                // Se desenlaza currNode de la lista
                prev.next = currNode.next;
                System.out.println(index + " position element deleted");
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // CASO 3: El índice es mayor que el tamaño de la lista
        if (currNode == null) {
            System.out.println(index + " position element not found");
        }

        return list;
    }

    // ************** MÉTODO PRINCIPAL **************
    public static void main(String[] args) {
        // Inicia con una lista vacía
        LinkedList list = new LinkedList();

        // ****** INSERCIÓN ******
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Imprime la LinkedList
        printList(list);

        // ****** BORRADO POR POSICIÓN ******

        // Eliminar nodo en la posición 0 (cabecera)
        deleteAtPosition(list, 0);
        printList(list);

        // Eliminar nodo en la posición 2 (en medio)
        deleteAtPosition(list, 2);
        printList(list);

        // Eliminar nodo en la posición 10 (no existe)
        deleteAtPosition(list, 10);
        printList(list);
    }
}

