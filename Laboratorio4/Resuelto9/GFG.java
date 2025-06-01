package Laboratorio4.Resuelto9;

// Un programa Java para iterar los elementos en una LinkedList
import java.util.*;

public class GFG {
    public static void main(String args[]) {

        // Crear una LinkedList de Strings
        LinkedList<String> ll = new LinkedList<>();

        // Agregar elementos
        ll.add("Uno");
        ll.add("Dos");
        ll.add(1, "Tres");  // Inserta "Tres" en la posición 1: [Uno, Tres, Dos]

        // Usando el método get() en un ciclo for
        System.out.print("Iteración con for y get(): ");
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        System.out.println();

        // Usando un ciclo for-each
        System.out.print("Iteración con for-each: ");
        for (String str : ll) {
            System.out.print(str + " ");
        }
    }
}

