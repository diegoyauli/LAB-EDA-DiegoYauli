package Laboratorio5.EjercicioResuelto2;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> cola = new QueueList<>();

        System.out.println("Insertando elementos en la cola: 1 al 8");
        for (int i = 1; i <= 8; i++) {
            cola.enqueue(i);
            System.out.println("Se agregó: " + i + " | Cola actual: " + cola.toString());
        }

        System.out.println("\nEstado actual de la cola:");
        System.out.println(cola.toString());

        System.out.println("\nElemento al frente: " + cola.front());

        System.out.println("\nEliminando elementos (dequeue):");
        while (!cola.isEmpty()) {
            System.out.println("Se eliminó: " + cola.dequeue() + " | Cola actual: " + cola.toString());
        }

        System.out.println("\n¿La cola está vacía?: " + cola.isEmpty());
    }
}

