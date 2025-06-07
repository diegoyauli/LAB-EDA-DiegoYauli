package Laboratorio5.EjercicioPropuesto2;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> pila = new StackList<>();

        // Insertando los elementos del 1 al 10
        for (int i = 1; i <= 10; i++) {
            pila.push(i);
        }

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Is Empty");
            System.out.println("5. Is Full");
            System.out.println("6. Destroy Stack");
            System.out.println("7. Print Stack");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el número a añadir a la pila: ");
                    int valor = scanner.nextInt();
                    pila.push(valor);
                    System.out.println(valor + " añadido a la pila.");
                    break;
                case 2:
                    if (!pila.isEmpty()) {
                        System.out.println("Elemento eliminado: " + pila.pop());
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;
                case 3:
                    if (!pila.isEmpty()) {
                        System.out.println("Elemento en el tope: " + pila.top());
                    } else {
                        System.out.println("La pila está vacía.");
                    }
                    break;
                case 4:
                    System.out.println("¿Está la pila vacía? " + pila.isEmpty());
                    break;
                case 5:
                    System.out.println("¿Está la pila llena? " + pila.isFull());
                    break;
                case 6:
                    pila.destroyStack();
                    System.out.println("Pila destruida.");
                    break;
                case 7:
                    System.out.print("Elementos de la pila: ");
                    pila.printStack();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
