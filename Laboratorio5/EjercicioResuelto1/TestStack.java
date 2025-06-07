package Laboratorio5.EjercicioResuelto1;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> pila = new StackList<>();

        System.out.println("Insertando los elementos: 1 al 8");
        for (int i = 1; i <= 8; i++) {
            pila.push(i);
            System.out.println("Se agregó: " + i + " | Pila actual: " + pila.toString());
        }

        System.out.println("\nEstado actual de la pila:");
        System.out.println(pila.toString());

        System.out.println("\nElemento en el tope: " + pila.top());

        System.out.println("\nEliminando elementos (pop):");
        while (!pila.isEmpty()) {
            System.out.println("Se eliminó: " + pila.pop() + " | Pila actual: " + pila.toString());
        }

        System.out.println("\n¿La pila está vacía?: " + pila.isEmpty());
    }
}