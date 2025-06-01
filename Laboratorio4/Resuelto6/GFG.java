package Laboratorio4.Resuelto6;

// Programa que demuestra la implementación de la clase LinkedList
import java.util.*;

public class GFG {
    public static void main(String args[]) {

        // Creando el objeto de la clase lista enlazada
        LinkedList<String> ll = new LinkedList<String>();

        // Añadiendo elementos a la lista enlazada
        ll.add("A");              // Añade al final
        ll.add("B");              // Añade al final
        ll.addLast("C");          // Añade al final
        ll.addFirst("D");         // Añade al principio
        ll.add(2, "E");           // Añade en la posición 2

        // Imprime la lista actual
        System.out.println(ll);   // [D, A, E, B, C]

        // Eliminando elementos
        ll.remove("B");           // Elimina la primera aparición de "B"
        ll.remove(3);             // Elimina el elemento en el índice 3
        ll.removeFirst();         // Elimina el primer elemento
        ll.removeLast();          // Elimina el último elemento

        // Imprime la lista después de las eliminaciones
        System.out.println(ll);   // [A]
    }
}

