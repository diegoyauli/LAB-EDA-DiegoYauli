package Laboratorio9.EjercicioPropuesto2;

public class TestHashOpened {
    public static void main(String[] args) {
        HashOpened<String> hashTable = new HashOpened<>(8);

        System.out.println("=== PRUEBA DE TABLA HASH ABIERTA (ENCADENAMIENTO) ===");

        // Insertar elementos
        System.out.println("\n--- Insertando elementos ---");
        hashTable.insert(5, "Pepe");
        hashTable.insert(21, "Jesús");
        hashTable.insert(19, "Juan");
        hashTable.insert(16, "María");
        hashTable.insert(21, "DUPLICADO"); // Error: duplicado

        // Mostrar tabla
        System.out.println("\n--- Tabla después de inserciones ---");
        hashTable.showTable();

        // Buscar elementos
        System.out.println("\n--- Buscando elementos ---");
        buscarYMostrar(hashTable, 5); // Existe
        buscarYMostrar(hashTable, 21); // Existe
        buscarYMostrar(hashTable, 99); // No existe

        // Eliminar elementos
        System.out.println("\n--- Eliminando elementos ---");
        hashTable.delete(21);
        hashTable.delete(100); // Error: no existe

        // Mostrar tabla final
        System.out.println("\n--- Tabla después de eliminaciones ---");
        hashTable.showTable();
    }

    private static void buscarYMostrar(HashOpened<String> hashTable, int key) {
        Register<String> resultado = hashTable.search(key);
        if (resultado != null) {
            System.out.println("Encontrado: " + key + " -> " + resultado.getValue());
        } else {
            System.out.println("No encontrado: " + key);
        }
    }
}
