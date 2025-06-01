package Laboratorio4.Propuesto5;
class Nodo<E> {
    E dato;
    Nodo<E> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Lista enlazada simple genérica
class ListaSimple<E> {
    private Nodo<E> cabeza;

    public ListaSimple() {
        cabeza = null;
    }

    // Insertar al final
    public void insert(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<E> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Agregar al inicio
    public void addFirst(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    // Agregar al final (igual que insert)
    public void addLast(E dato) {
        insert(dato);
    }

    // Mostrar lista
    public void printList() {
        Nodo<E> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Tamaño de la lista
    public int size() {
        int contador = 0;
        Nodo<E> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // Eliminar por clave (primer ocurrencia)
    public void deleteByKey(E key) {
        if (cabeza == null) return;

        if (cabeza.dato.equals(key)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo<E> actual = cabeza;
        Nodo<E> prev = null;

        while (actual != null && !actual.dato.equals(key)) {
            prev = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Elemento no encontrado: " + key);
            return;
        }

        prev.siguiente = actual.siguiente;
    }

    // Eliminar en posición específica (0-based)
    public void deleteAtPosition(int position) {
        if (cabeza == null || position < 0) return;

        if (position == 0) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo<E> actual = cabeza;
        Nodo<E> prev = null;
        int contador = 0;

        while (actual != null && contador < position) {
            prev = actual;
            actual = actual.siguiente;
            contador++;
        }

        if (actual == null) {
            System.out.println("Posición inválida: " + position);
            return;
        }

        prev.siguiente = actual.siguiente;
    }

    // Eliminar primer nodo
    public void removeFirst() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        }
    }

    // Eliminar último nodo
    public void removeLast() {
        if (cabeza == null) return;

        if (cabeza.siguiente == null) {
            cabeza = null;
            return;
        }

        Nodo<E> actual = cabeza;
        Nodo<E> prev = null;

        while (actual.siguiente != null) {
            prev = actual;
            actual = actual.siguiente;
        }
        prev.siguiente = null;
    }
}

