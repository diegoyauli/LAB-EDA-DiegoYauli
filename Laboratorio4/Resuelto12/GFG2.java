package Laboratorio4.Resuelto12;

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

        // Mostrar la LinkedList inicial
        System.out.println("LinkedList: " + list);

        // Remover el primer elemento y mostrarlo
        System.out.println("El primer elemento removido es: " + list.removeFirst());

        // Mostrar la LinkedList después de la eliminación
        System.out.println("LinkedList final: " + list);
    }
}

