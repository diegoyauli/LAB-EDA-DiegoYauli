package Laboratorio9.EjercicioResuelto6;

import java.util.LinkedList;

public class HashOpened<E> {
    private LinkedList<Register<E>>[] table;

    @SuppressWarnings("unchecked")
    public HashOpened(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(int key, E value) {
        Register<E> newReg = new Register<>(key, value);
        int index = hash(key);
        
        // Verificar duplicados
        for (Register<E> reg : table[index]) {
            if (reg.getKey() == key && !reg.isDeleted()) {
                System.out.println("Error: Clave duplicada " + key);
                return;
            }
        }
        
        table[index].add(newReg);
        System.out.println("Insertado: " + newReg + " en posición " + index);
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
                System.out.println("Eliminado lógicamente: " + key);
                return;
            }
        }
        System.out.println("Error: Clave no encontrada " + key);
    }

    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Abierto) ---");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("[VACÍO]");
            } else {
                for (Register<E> reg : table[i]) {
                    System.out.print(reg + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}