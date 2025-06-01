package Laboratorio4.Propuesto1;
// Clase Nodo genérica para lista doblemente enlazada
class Nodo<E> {
    E dato;
    Nodo<E> siguiente;
    Nodo<E> anterior;

    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

// Clase ListaDoble con nodos genéricos
class ListaDoble<E> {
    private Nodo<E> cabeza;
    private Nodo<E> cola;

    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    // Método para agregar nodo al final de la lista
    public void agregar(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
    }

    // Método para mostrar lista desde el inicio al final
    public void mostrarAdelante() {
        Nodo<E> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para mostrar lista desde el final al inicio
    public void mostrarAtras() {
        Nodo<E> actual = cola;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    // Método para obtener un nodo genérico (ejemplo: obtener cabeza)
    public E obtenerCabeza() {
        if (cabeza != null) return cabeza.dato;
        else return null;
    }
    
    // Método para obtener un nodo genérico (ejemplo: obtener cola)
    public E obtenerCola() {
        if (cola != null) return cola.dato;
        else return null;
    }
}

// Clase principal para probar
public class TestListaDoble {
    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<>();

        // Insertar elementos del 1 al 10
        for (int i = 1; i <= 10; i++) {
            lista.agregar(i);
        }

        System.out.print("Lista adelante: ");
        lista.mostrarAdelante();

        System.out.print("Lista atrás: ");
        lista.mostrarAtras();

        // Prueba de métodos genéricos
        System.out.println("Cabeza de la lista: " + lista.obtenerCabeza());
        System.out.println("Cola de la lista: " + lista.obtenerCola());
    }
}
