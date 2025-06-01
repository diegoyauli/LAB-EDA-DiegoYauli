package Laboratorio4.Resuelto13;

import java.io.*;
import java.util.LinkedList;

public class GFG2 {
    public static void main(String args[]) {

        // Crear una LinkedList de enteros
        LinkedList<Integer> list = new LinkedList<Integer>();

        // Agregar elementos a la lista
        list.add(10);
        list.add(20);
        list.add(30);

        // Mostrar la lista inicial
        System.out.println("LinkedList: " + list);

        // Remover el último elemento usando removeLast() y mostrarlo
        System.out.println("El último elemento removido es: " + list.removeLast());

        // Mostrar la lista después de la primera eliminación
        System.out.println("LinkedList final: " + list);

        // Remover nuevamente el último elemento y mostrarlo
        System.out.println("El último elemento removido es: " + list.removeLast());

        // Mostrar la lista después de la segunda eliminación
        System.out.println("LinkedList final: " + list);
    }
}

