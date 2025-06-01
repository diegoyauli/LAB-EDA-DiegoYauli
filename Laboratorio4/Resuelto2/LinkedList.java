package Laboratorio4.Resuelto2;
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

        // Si la lista enlazada está vacía, convierte el nuevo nodo en la cabeza
        if (list.head == null) {
            list.head = new_node;
        } else {
            // De lo contrario, recorre hasta el último nodo e inserta el nuevo nodo allí
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Inserta el nuevo nodo al final
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
            // Imprime el dato del nodo actual
            System.out.print(currNode.data + " ");
            // Va al siguiente nodo
            currNode = currNode.next;
        }
        System.out.println();
    }

    // ************** ELIMINACIÓN POR DATO **************

    // Método para eliminar un nodo en LinkedList por dato (key)
    public static LinkedList deleteByKey(LinkedList list, int key) {
        // Aloja el nodo cabecera
        Node currNode = list.head, prev = null;

        // CASO 1: Si el nodo cabecera contiene el dato a eliminar
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Cambia la cabeza
            System.out.println(key + " found and deleted");
            return list;
        }

        // CASO 2: Si el dato está en otro lugar que no sea la cabecera
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        // Si el dato está presente (currNode no es null)
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        // CASO 3: El dato no está presente
        if (currNode == null) {
            System.out.println(key + " not found");
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

        // ****** ELIMINACIÓN POR DATO ******

        // Elimina el nodo con el valor 1 (en la cabeza)
        deleteByKey(list, 1);
        printList(list);

        // Elimina el nodo con el valor 4 (en el medio)
        deleteByKey(list, 4);
        printList(list);

        // Intenta eliminar el nodo con el valor 10 (no está en la lista)
        deleteByKey(list, 10);
        printList(list);
    }
}

