package Laboratorio9.EjercicioPropuesto4;

import java.util.LinkedList;

public class HashOpen<E> {
    private LinkedList<Register<E>>[] table;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashOpen(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void insert(int key, E value) {
        int index = hash(key);
        for (Register<E> reg : table[index]) {
            if (reg.getKey() == key && !reg.isDeleted()) {
                System.out.println("Error: Clave duplicada " + key);
                return;
            }
        }
        table[index].add(new Register<>(key, value));
        System.out.println("Insertado: " + key + " -> " + value);
    }

    public Register<E> search(int key) {
        int index = hash(key);
        for (Register<E> reg : table[index]) {
            if (reg.getKey() == key && !reg.isDeleted()) {
                return reg;
            }
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        for (Register<E> reg : table[index]) {
            if (reg.getKey() == key && !reg.isDeleted()) {
                reg.delete();
                System.out.println("Eliminado: " + key);
                return;
            }
        }
        System.out.println("Error: Clave no encontrada");
    }

    public void showTable() {
        System.out.println("\n--- Tabla Hash (Abierto) ---");
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("[VACÍO]");
            } else {
                for (Register<E> reg : table[i]) {
                    System.out.print(reg + " | ");
                }
                System.out.println();
            }
        }
    }
}

