package Laboratorio5.EjercicioResuelto2;

public interface Queue<T> {
    void enqueue(T x);
    T dequeue();
    T front();
    boolean isEmpty();
    String toString();
}

