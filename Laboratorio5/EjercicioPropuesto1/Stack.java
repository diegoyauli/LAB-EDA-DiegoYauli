package Laboratorio5.EjercicioPropuesto1;

public interface Stack<E> {
    void push(E x);
    E pop();
    E top();
    boolean isEmpty();
    String toString();
}

