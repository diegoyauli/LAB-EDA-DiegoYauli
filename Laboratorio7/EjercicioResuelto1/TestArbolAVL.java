package Laboratorio7.EjercicioResuelto1;

public class TestArbolAVL {
    public static void main(String[] args) {
        AVLTree<Integer> arbol = new AVLTree<>();
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30); // Aquí se activará rotación simple izquierda

        arbol.inorden(); // Esperado: 10 20 30
    }
}

