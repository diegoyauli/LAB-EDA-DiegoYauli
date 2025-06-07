package Laboratorio5.EjercicioPropuesto1;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> pila = new StackList<>();

        System.out.println("Insertando elementos del 1 al 10 en la pila:");
        for (int i = 1; i <= 10; i++) {
            pila.push(i);
            System.out.println("Se agregó: " + i + " | Pila actual: " + pila);
        }

        System.out.println("\nElemento en el tope: " + pila.top());

        System.out.println("\nEliminando elementos (pop):");
        while (!pila.isEmpty()) {
            System.out.println("Se eliminó: " + pila.pop() + " | Pila actual: " + pila);
        }

        System.out.println("\n¿La pila está vacía?: " + pila.isEmpty());
    }
}

