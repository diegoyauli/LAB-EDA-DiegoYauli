package Laboratorio4.Resuelto8;

// Programa en Java para cambiar los elementos en una LinkedList
import java.util.*;

public class GFG {
    public static void main(String args[]) {

        // Crear una LinkedList de Strings
        LinkedList<String> ll = new LinkedList<>();

        // Añadir elementos
        ll.add("Uno");             // Índice 0
        ll.add("Dos");             // Índice 1
        ll.add(1, "Tres");         // Inserta "Tres" en el índice 1: [Uno, Tres, Dos]

        // Mostrar la LinkedList inicial
        System.out.println("Initial LinkedList: " + ll);  // [Uno, Tres, Dos]

        // Reemplazar el elemento en el índice 1 con "Cuatro"
        ll.set(1, "Cuatro");       // [Uno, Cuatro, Dos]

        // Mostrar la LinkedList actualizada
        System.out.println("Updated LinkedList: " + ll);  // [Uno, Cuatro, Dos]
    }
}

