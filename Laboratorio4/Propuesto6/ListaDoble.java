package Laboratorio4.Propuesto6;
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

// Lista doblemente enlazada genérica
class ListaDoble<E> {
    private Nodo<E> cabeza;
    private Nodo<E> cola;

    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    // Insertar al final (igual que addLast)
    public void insert(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Agregar al inicio
    public void addFirst(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    // Agregar al final
    public void addLast(E dato) {
        insert(dato);
    }

    // Mostrar lista de inicio a fin
    public void printList() {
        Nodo<E> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Tamaño de la lista
    public int size() {
        int count = 0;
        Nodo<E> actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    // Eliminar por clave (primera ocurrencia)
    public void deleteByKey(E key) {
        Nodo<E> actual = cabeza;

        while (actual != null && !actual.dato.equals(key)) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("Elemento no encontrado: " + key);
            return;
        }

        // Si es cabeza
        if (actual == cabeza) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) cabeza.anterior = null;
            else cola = null; // lista queda vacía
            return;
        }

        // Si es cola
        if (actual == cola) {
            cola = cola.anterior;
            if (cola != null) cola.siguiente = null;
            else cabeza = null;
            return;
        }

        // Nodo en medio
        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;
    }

    // Eliminar en posición (0-based)
    public void deleteAtPosition(int pos) {
        if (pos < 0 || cabeza == null) {
            System.out.println("Posición inválida.");
            return;
        }

        Nodo<E> actual = cabeza;
        int index = 0;

        while (actual != null && index < pos) {
            actual = actual.siguiente;
            index++;
        }

        if (actual == null) {
            System.out.println("Posición inválida.");
            return;
        }

        // Misma lógica que deleteByKey pero usando actual
        if (actual == cabeza) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) cabeza.anterior = null;
            else cola = null;
            return;
        }

        if (actual == cola) {
            cola = cola.anterior;
            if (cola != null) cola.siguiente = null;
            else cabeza = null;
            return;
        }

        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;
    }

    // Eliminar primer nodo
    public void removeFirst() {
        if (cabeza == null) return;

        cabeza = cabeza.siguiente;
        if (cabeza != null) cabeza.anterior = null;
        else cola = null;
    }

    // Eliminar último nodo
    public void removeLast() {
        if (cola == null) return;

        cola = cola.anterior;
        if (cola != null) cola.siguiente = null;
        else cabeza = null;
    }
}
