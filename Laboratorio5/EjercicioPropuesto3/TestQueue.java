package Laboratorio5.EjercicioPropuesto3;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> cola = new QueueList<>();

        System.out.println("Insertando elementos del 1 al 10 en la cola:");
        for (int i = 1; i <= 10; i++) {
            cola.enqueue(i);
            System.out.println("Se agregó: " + i + " | Cola actual: " + cola);
        }

        System.out.println("\nElemento al frente: " + cola.front());

        System.out.println("\nEliminando elementos (dequeue):");
        while (!cola.isEmpty()) {
            System.out.println("Se eliminó: " + cola.dequeue() + " | Cola actual: " + cola);
        }

        System.out.println("\n¿La cola está vacía?: " + cola.isEmpty());
    }
}
