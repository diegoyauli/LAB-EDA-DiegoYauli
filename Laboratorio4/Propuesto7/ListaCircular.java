package Laboratorio4.Propuesto7;
class Nodo<E> {
    E dato;
    Nodo<E> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Lista circular simple genérica
class ListaCircular<E> {
    private Nodo<E> ultimo;

    public ListaCircular() {
        ultimo = null;
    }

    // Insertar al final (igual que addLast)
    public void insert(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (ultimo == null) {
            nuevo.siguiente = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    // Agregar al inicio
    public void addFirst(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (ultimo == null) {
            nuevo.siguiente = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        }
    }

    // Agregar al final
    public void addLast(E dato) {
        insert(dato);
    }

    // Mostrar lista (una vuelta)
    public void printList() {
        if (ultimo == null) {
            System.out.println("Lista vacía.");
            return;
        }
        Nodo<E> actual = ultimo.siguiente;
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        System.out.println("(circular)");
    }

    // Tamaño de la lista
    public int size() {
        if (ultimo == null) return 0;
        int count = 1;
        Nodo<E> actual = ultimo.siguiente;
        while (actual != ultimo) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    // Eliminar primer nodo
    public void removeFirst() {
        if (ultimo == null) return;

        if (ultimo == ultimo.siguiente) {
            ultimo = null;
        } else {
            ultimo.siguiente = ultimo.siguiente.siguiente;
        }
    }

    // Eliminar último nodo
    public void removeLast() {
        if (ultimo == null) return;

        if (ultimo == ultimo.siguiente) {
            ultimo = null;
            return;
        }

        Nodo<E> actual = ultimo.siguiente;
        Nodo<E> prev = null;
        while (actual.siguiente != ultimo.siguiente) {
            prev = actual;
            actual = actual.siguiente;
        }
        if (prev != null) {
            prev.siguiente = ultimo.siguiente;
            ultimo = prev;
        }
    }

    // Eliminar por clave (primera ocurrencia)
    public void deleteByKey(E key) {
        if (ultimo == null) return;

        Nodo<E> actual = ultimo.siguiente;
        Nodo<E> prev = ultimo;
        boolean encontrado = false;

        do {
            if (actual.dato.equals(key)) {
                encontrado = true;
                break;
            }
            prev = actual;
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);

        if (!encontrado) {
            System.out.println("Elemento no encontrado: " + key);
            return;
        }

        // Solo un nodo
        if (actual == ultimo && actual == ultimo.siguiente) {
            ultimo = null;
            return;
        }

        // Si es el nodo siguiente a ultimo (inicio)
        if (actual == ultimo.siguiente) {
            ultimo.siguiente = actual.siguiente;
        } else if (actual == ultimo) {
            prev.siguiente = actual.siguiente;
            ultimo = prev;
        } else {
            prev.siguiente = actual.siguiente;
        }
    }

    // Eliminar en posición (0-based)
    public void deleteAtPosition(int pos) {
        int tamaño = size();
        if (pos < 0 || pos >= tamaño) {
            System.out.println("Posición inválida.");
            return;
        }

        if (pos == 0) {
            removeFirst();
            return;
        }

        Nodo<E> actual = ultimo.siguiente;
        Nodo<E> prev = ultimo;
        int index = 0;

        while (index < pos) {
            prev = actual;
            actual = actual.siguiente;
            index++;
        }

        if (actual == ultimo) {
            prev.siguiente = actual.siguiente;
            ultimo = prev;
        } else {
            prev.siguiente = actual.siguiente;
        }
    }
}

