package Laboratorio4.Propuesto3;

import java.util.LinkedList;

public class TestLinkedListJavaUtil {
    public static void main(String[] args) {
        // Crear lista doblemente enlazada usando LinkedList
        LinkedList<Integer> lista = new LinkedList<>();

        // Agregar elementos del 1 al 10
        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }

        // Mostrar lista desde el inicio (orden natural)
        System.out.print("Lista adelante: ");
        for (Integer num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Mostrar lista desde el final (usando descendingIterator)
        System.out.print("Lista atrás: ");
        var iteradorDesc = lista.descendingIterator();
        while (iteradorDesc.hasNext()) {
            System.out.print(iteradorDesc.next() + " ");
        }
        System.out.println();

        // Mostrar primer y último elemento usando métodos de LinkedList
        System.out.println("Primer elemento: " + lista.getFirst());
        System.out.println("Último elemento: " + lista.getLast());
    }
}

