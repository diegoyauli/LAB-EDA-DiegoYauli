package Laboratorio9.EjercicioPropuesto3;

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
            System.out.println("Error: Tabla llena");
            return;
        }

        int index = hash(key);
        int originalIndex = index;
        int i = 1;

        while (table[index] != null && !table[index].isDeleted()) {
            if (table[index].getKey() == key) {
                System.out.println("Error: Clave duplicada " + key);
                return;
            }
            index = (originalIndex + i) % capacity; // Sondeo lineal
            i++;
        }

        table[index] = new Register<>(key, value);
        size++;
        System.out.println("Insertado: " + key + " -> " + value);
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
            if (index == originalIndex) break;
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
                System.out.println("Eliminado: " + key);
                return;
            }
            index = (originalIndex + i) % capacity;
            i++;
            if (index == originalIndex) break;
        }
        System.out.println("Error: Clave no encontrada");
    }

    public void showTable() {
        System.out.println("\n--- Tabla Hash ---");
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + ": ");
            System.out.println(table[i] == null ? "[VACÍO]" : table[i]);
        }
    }
}
