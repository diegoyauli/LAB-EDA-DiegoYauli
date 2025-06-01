package Laboratorio4.Resuelto14;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {

        // Crear una nueva LinkedList de enteros
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Añadir elementos a la lista enlazada
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // Añadir un elemento al principio de la lista
        linkedList.addFirst(0);

        // Añadir un elemento al final de la lista
        linkedList.addLast(4);

        // Imprimir todos los elementos de la lista
        for (int i : linkedList) {
            System.out.println(i);
        }
    }
}

