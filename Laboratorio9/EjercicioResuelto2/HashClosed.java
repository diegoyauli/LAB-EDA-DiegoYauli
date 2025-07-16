package Laboratorio9.EjercicioResuelto2;

public class HashClosed<E> {
    private Element<E>[] table;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public HashClosed(int capacity) {
        this.capacity = capacity;
        this.table = new Element[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new Element<>();
        }
        this.size = 0;
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void insert(int key, E value) {
        if (size == capacity) {
            System.out.println("Tabla hash llena. No se puede insertar " + key);
            return;
        }

        int index = hash(key);
        int originalIndex = index;
        int i = 1;

        // Buscar posición vacía o con marca de eliminado
        while (!table[index].isEmpty() && !table[index].isDeleted()) {
            if (table[index].getRegister().getKey() == key) {
                System.out.println("Error: Clave duplicada " + key);
                return;
            }
            index = (originalIndex + i) % capacity; // Sondeo lineal
            i++;
            if (index == originalIndex) break;
        }

        table[index].setRegister(new Register<>(key, value));
        size++;
        System.out.println("Insertado: " + key + ": " + value + " en posición " + index);
    }

    public Register<E> search(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 1;

        while (!table[index].isEmpty()) {
            if (!table[index].isDeleted() && 
                table[index].getRegister().getKey() == key) {
                return table[index].getRegister();
            }
            index = (originalIndex + i) % capacity;
            i++;
            if (index == originalIndex || table[index].isEmpty()) break;
        }

        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 1;

        while (!table[index].isEmpty()) {
            if (!table[index].isDeleted() && 
                table[index].getRegister().getKey() == key) {
                table[index].markAsDeleted();
                size--;
                System.out.println("Eliminado lógicamente: " + key);
                return;
            }
            index = (originalIndex + i) % capacity;
            i++;
            if (index == originalIndex || table[index].isEmpty()) break;
        }

        System.out.println("Clave no encontrada: " + key);
    }

    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Cerrado) ---");
        for (int i = 0; i < capacity; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }
}
