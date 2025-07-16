package Laboratorio9.EjercicioResuelto3;

public class TestHashClosed {
    public static void main(String[] args) {
        // Crear tabla hash con capacidad para 11 elementos (número primo para mejor distribución)
        HashClosed<String> hashTable = new HashClosed<>(11);
        
        System.out.println("=== PRUEBA DE TABLA HASH CERRADA (SONDEO LINEAL) ===");
        
        // 1. Agregar los elementos especificados
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
        hashTable.insert(32, "Valor32-Duplicado"); // Debe mostrar error de duplicado
        hashTable.insert(100, "Valor100-Duplicado"); // Debe mostrar error de duplicado
        
        // 2. Mostrar tabla hash resultante
        System.out.println("\n--- Tabla Hash después de inserciones ---");
        hashTable.showTable();
        
        // 3. Buscar los elementos especificados
        System.out.println("\n--- Buscando elementos ---");
        buscarYMostrar(hashTable, 32);
        buscarYMostrar(hashTable, 200);
        
        // 4. Eliminar los elementos especificados
        System.out.println("\n--- Eliminando elementos ---");
        hashTable.delete(17);
        hashTable.delete(100);
        hashTable.delete(200); // No existe, debe mostrar mensaje
        
        // 5. Mostrar tabla hash resultante después de eliminaciones
        System.out.println("\n--- Tabla Hash después de eliminaciones ---");
        hashTable.showTable();
    }
    
    private static void buscarYMostrar(HashClosed<String> hashTable, int key) {
        Register<String> resultado = hashTable.search(key);
        if (resultado != null) {
            System.out.println("Elemento encontrado - Clave: " + key + ", Valor: " + resultado.getValue());
        } else {
            System.out.println("Elemento NO encontrado - Clave: " + key);
        }
    }
}