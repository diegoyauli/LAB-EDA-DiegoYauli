package Laboratorio4.Resuelto10;

import java.util.*;

public class GFG2 {
    public static void main(String[] args) {

        // Crear una LinkedList de enteros
        LinkedList<Integer> list = new LinkedList<Integer>();

        // Agregar elementos a la LinkedList
        list.add(123);
        list.add(12);
        list.add(11);
        list.add(1134);

        // Imprimir la LinkedList
        System.out.println("LinkedList: " + list);

        // Convertir la LinkedList a un arreglo
        Object[] a = list.toArray();

        // Imprimir el arreglo
        System.out.print("Después de convertir LinkedList a un Array: ");
        for (Object element : a) {
            System.out.print(element + " ");
        }
    }
}

