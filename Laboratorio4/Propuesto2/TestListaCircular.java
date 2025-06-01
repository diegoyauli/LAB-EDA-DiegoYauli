package Laboratorio4.Propuesto2;

// Nodo genérico para lista circular simple
class Nodo<E> {
    E dato;
    Nodo<E> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Clase lista circular simple genérica
class ListaCircular<E> {
    private Nodo<E> ultimo; // Referencia al último nodo

    public ListaCircular() {
        ultimo = null;
    }

    // Método para agregar un nuevo nodo al final (antes del primero)
    public void agregar(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        if (ultimo == null) {
            // Lista vacía: el nodo apunta a sí mismo
            nuevoNodo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            // Insertar nuevoNodo después de ultimo y actualizar puntero circular
            nuevoNodo.siguiente = ultimo.siguiente; // Apunta al primero
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo; // nuevo nodo es el último
        }
    }

    // Método para mostrar todos los elementos (una vuelta completa)
    public void mostrar() {
        if (ultimo == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo<E> actual = ultimo.siguiente; // primer nodo
        do {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        System.out.println();
    }

    // Método para obtener el primer elemento
    public E obtenerPrimero() {
        if (ultimo == null) return null;
        return ultimo.siguiente.dato;
    }

    // Método para obtener el último elemento
    public E obtenerUltimo() {
        if (ultimo == null) return null;
        return ultimo.dato;
    }
}

// Clase principal para prueba
public class TestListaCircular {
    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();

        // Insertar del 1 al 12
        for (int i = 1; i <= 12; i++) {
            lista.agregar(i);
        }

        System.out.print("Lista circular: ");
        lista.mostrar();

        System.out.println("Primer elemento: " + lista.obtenerPrimero());
        System.out.println("Último elemento: " + lista.obtenerUltimo());
    }
}

