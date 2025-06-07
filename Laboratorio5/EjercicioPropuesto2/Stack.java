package Laboratorio5.EjercicioPropuesto2;

public interface Stack<E> {
    void push(E x);
    E pop();
    E top();
    boolean isEmpty();
    boolean isFull();
    void destroyStack();
    void printStack();
}

