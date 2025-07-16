package Laboratorio9.EjercicioResuelto7;

public class TestHashOpened {
    public static void main(String[] args) {
        // 1. Crear tabla hash con tamaño 8
        HashOpened<String> tablaHash = new HashOpened<>(8);
        
        System.out.println("=== PRUEBAS DE TABLA HASH ABIERTA ===");
        System.out.println("Tamaño de la tabla: 8\n");

        // 2. Agregar elementos específicos
        System.out.println("--- Insertando elementos ---");
        tablaHash.insert(5, "Pepe");
        tablaHash.insert(21, "Jesús");
        tablaHash.insert(19, "Juan");
        tablaHash.insert(16, "María");
        tablaHash.insert(21, "DUPLICADO"); // Debe fallar por duplicado

        // 3. Mostrar tabla después de inserciones
        System.out.println("\n--- Tabla Hash después de inserciones ---");
        tablaHash.showTable();

        // 4. Buscar elementos específicos
        System.out.println("\n--- Buscando elementos ---");
        probarBusqueda(tablaHash, 5);  // Debe existir
        probarBusqueda(tablaHash, 21); // Debe existir
        probarBusqueda(tablaHash, 99); // No existe

        // 5. Eliminar elementos específicos
        System.out.println("\n--- Eliminando elementos ---");
        tablaHash.delete(21);  // Existe
        tablaHash.delete(100); // No existe

        // 6. Mostrar tabla final
        System.out.println("\n--- Tabla Hash después de eliminaciones ---");
        tablaHash.showTable();
    }

    private static void probarBusqueda(HashOpened<String> tabla, int clave) {
        Register<String> resultado = tabla.search(clave);
        if (resultado != null) {
            System.out.println("Encontrado: Clave " + clave + " -> " + resultado.getValue());
        } else {
            System.out.println("No encontrado: Clave " + clave);
        }
    }
}
