package Laboratorio5.EjercicioPropuesto3;

public interface Queue<E> {
    void enqueue(E x);  // Agrega al final
    E dequeue();        // Elimina del frente
    E front();          // Muestra el primero
    boolean isEmpty();
    String toString();
}

