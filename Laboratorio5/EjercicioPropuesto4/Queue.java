package Laboratorio5.EjercicioPropuesto4;

public interface Queue<E> {
    void encolar(E x);
    E desencolar();
    E front();
    E back();
    boolean isEmpty();
    boolean isFull();
    void destroyQueue();
    void printQueue();
}
