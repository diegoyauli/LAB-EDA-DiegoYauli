package Laboratorio4.Propuesto4;

import java.util.Iterator;
import java.util.LinkedList;

public class TestListaCircularJavaUtil {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();

        // Agregar elementos del 1 al 12
        for (int i = 1; i <= 12; i++) {
            lista.add(i);
        }

        System.out.println("Elementos en lista circular simulada (24 elementos en 2 vueltas):");

        // Simular recorrido circular haciendo 2 vueltas sobre la lista
        Iterator<Integer> iterador = lista.iterator();
        int vueltas = 2;
        int totalElementos = lista.size() * vueltas;
        int contador = 0;

        while (contador < totalElementos) {
            if (!iterador.hasNext()) {
                // Reiniciar iterator para simular circularidad
                iterador = lista.iterator();
            }
            System.out.print(iterador.next() + " ");
            contador++;
        }
        System.out.println();
    }
}

