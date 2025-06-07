package Laboratorio5.EjercicioResuelto1;

// Interfaz genérica para la implementación de la Pila y Cola
public interface Stack<E> {
    void push(E x);
    E pop() ;
    E top() ;
    boolean isEmpty();
    String toString();
}

