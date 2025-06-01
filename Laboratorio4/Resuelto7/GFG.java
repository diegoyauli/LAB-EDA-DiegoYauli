package Laboratorio4.Resuelto7;

// Programa Java para añadir elementos a la LinkedList
import java.util.*;

public class GFG {
    public static void main(String args[]) {

        // Crear una LinkedList de Strings
        LinkedList<String> ll = new LinkedList<>();

        // Añadir elementos
        ll.add("Uno");            // Añade al final
        ll.add("Tres");           // Añade al final
        ll.add(1, "Dos");         // Inserta "Dos" en la posición 1 (entre "Uno" y "Tres")

        // Imprimir la LinkedList
        System.out.println(ll);   // [Uno, Dos, Tres]
    }
}

