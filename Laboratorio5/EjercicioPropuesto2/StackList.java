package Laboratorio5.EjercicioPropuesto2;

public class StackList<T> implements Stack<T> {
    private Node<T> tope;

    public StackList() {
        this.tope = null;
    }

    public void push(T x) {
        Node<T> nuevoNodo = new Node<>(x);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Pila vacía");
        T valor = tope.getValor();
        tope = tope.getSiguiente();
        return valor;
    }

    public T top() {
        if (isEmpty()) throw new IllegalStateException("Pila vacía");
        return tope.getValor();
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public boolean isFull() {
        return false; // La pila no está limitada en tamaño
    }

    public void destroyStack() {
        tope = null; // Elimina todos los elementos de la pila
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }
        Node<T> actual = tope;
        while (actual != null) {
            System.out.print(actual.getValor() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}

