package Laboratorio5.EjercicioPropuesto4;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueList<Integer> cola = new QueueList<>(10); // Cola con tamaño máximo 10

        // Insertando los elementos del 1 al 10 en la cola
        for (int i = 1; i <= 10; i++) {
            cola.encolar(i);
        }

        // Menú interactivo
        while (true) {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Encolar");
            System.out.println("2. Desencolar");
            System.out.println("3. Mostrar el primer elemento (front)");
            System.out.println("4. Mostrar el último elemento (back)");
            System.out.println("5. Verificar si la cola está vacía");
            System.out.println("6. Verificar si la cola está llena");
            System.out.println("7. Destruir la cola");
            System.out.println("8. Mostrar contenido de la cola");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a encolar: ");
                    int valor = scanner.nextInt();
                    cola.encolar(valor);
                    break;
                case 2:
                    System.out.println("Elemento desencolado: " + cola.desencolar());
                    break;
                case 3:
                    System.out.println("Elemento al frente de la cola: " + cola.front());
                    break;
                case 4:
                    System.out.println("Elemento al final de la cola: " + cola.back());
                    break;
                case 5:
                    System.out.println("¿La cola está vacía? " + cola.isEmpty());
                    break;
                case 6:
                    System.out.println("¿La cola está llena? " + cola.isFull());
                    break;
                case 7:
                    cola.destroyQueue();
                    break;
                case 8:
                    cola.printQueue();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}

