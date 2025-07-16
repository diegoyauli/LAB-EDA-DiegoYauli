package Laboratorio9.EjercicioPropuesto1;

public class TestHashClosed {
    public static void main(String[] args) {
        HashClosed<String> hashTable = new HashClosed<>(11);

        System.out.println("=== PRUEBA DE TABLA HASH CERRADA (SONDEO LINEAL) ===");

        // Insertar elementos
        System.out.println("\n--- Insertando elementos ---");
        hashTable.insert(100, "Valor100");
        hashTable.insert(5, "Valor5");
        hashTable.insert(14, "Valor14");
        hashTable.insert(15, "Valor15");
        hashTable.insert(22, "Valor22");
        hashTable.insert(16, "Valor16");
        hashTable.insert(17, "Valor17");
        hashTable.insert(32, "Valor32");
        hashTable.insert(13, "Valor13");
        hashTable.insert(32, "Valor32-Duplicado"); // Error: duplicado
        hashTable.insert(100, "Valor100-Duplicado"); // Error: duplicado

        // Mostrar tabla
        System.out.println("\n--- Tabla después de inserciones ---");
        hashTable.showTable();

        // Buscar elementos
        System.out.println("\n--- Buscando elementos ---");
        buscarYMostrar(hashTable, 32); // Existe
        buscarYMostrar(hashTable, 200); // No existe

        // Eliminar elementos
        System.out.println("\n--- Eliminando elementos ---");
        hashTable.delete(17);
        hashTable.delete(100);
        hashTable.delete(200); // Error: no existe

        // Mostrar tabla final
        System.out.println("\n--- Tabla después de eliminaciones ---");
        hashTable.showTable();
    }

    private static void buscarYMostrar(HashClosed<String> hashTable, int key) {
        Register<String> resultado = hashTable.search(key);
        if (resultado != null) {
            System.out.println("Encontrado: " + key + " -> " + resultado.getValue());
        } else {
            System.out.println("No encontrado: " + key);
        }
    }
}
