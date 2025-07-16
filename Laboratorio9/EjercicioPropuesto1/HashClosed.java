package Laboratorio9.EjercicioPropuesto1;

public class HashClosed<E> {
    private Register<E>[] table;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        this.capacity = capacity;
        this.table = new Register[capacity];
        this.size = 0;
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void insert(int key, E value) {
        if (size == capacity) {
            System.out.println("Tabla llena. No se puede insertar " + key);
            return;
        }

        int index = hash(key);
        int originalIndex = index;
        int i = 1;

        // Sondeo lineal para manejar colisiones
        while (table[index] != null && !table[index].isDeleted()) {
            if (table[index].getKey() == key) {
                System.out.println("Error: Clave duplicada " + key);
                return;
            }
            index = (originalIndex + i) % capacity;
            i++;
            if (index == originalIndex) break; // Evita bucle infinito
        }

        table[index] = new Register<>(key, value);
        size++;
        System.out.println("Insertado: " + key + ": " + value + " en posición " + index);
    }

    public Register<E> search(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 1;

        while (table[index] != null) {
            if (!table[index].isDeleted() && table[index].getKey() == key) {
                return table[index];
            }
            index = (originalIndex + i) % capacity;
            i++;
            if (index == originalIndex || table[index] == null) break;
        }

        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 1;

        while (table[index] != null) {
            if (!table[index].isDeleted() && table[index].getKey() == key) {
                table[index].delete();
                size--;
                System.out.println("Eliminado lógicamente: " + key);
                return;
            }
            index = (originalIndex + i) % capacity;
            i++;
            if (index == originalIndex || table[index] == null) break;
        }

        System.out.println("Error: Clave no encontrada " + key);
    }

    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Cerrada) ---");
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + ": ");
            if (table[i] == null) {
                System.out.println("[VACÍO]");
            } else {
                System.out.println(table[i]);
            }
        }
    }
}
