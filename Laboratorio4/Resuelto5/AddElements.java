package Laboratorio4.Resuelto5;
// Un programa Java para añadir elementos a una LinkedList
import java.util.LinkedList;

public class AddElements {

    // Método principal
    public static void main(String[] args) {

        // Creando una LinkedList
        LinkedList<String> l = new LinkedList<String>();

        // Añadiendo elementos a la LinkedList usando el método add()
        l.add("Uno");
        l.add("Dos");
        l.add("Tres");
        l.add("Cuatro");
        l.add("Cinco");

        // Imprimiendo la LinkedList
        System.out.println(l);
    }
}

