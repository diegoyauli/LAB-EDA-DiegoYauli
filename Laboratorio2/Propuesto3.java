public class Propuesto3 {
  public void trianguloRecursivo1(int base) {
    imprimirFilas(1, base);
  }
  // Método auxiliar recursivo para imprimir filas
  private void imprimirFilas(int filaActual, int base) {
    if (filaActual > base) {
      return; // Caso base: terminamos
    }
    imprimirAsteriscos(filaActual);
    System.out.println();
    imprimirFilas(filaActual + 1, base);
  }
  // Método auxiliar para imprimir asteriscos de forma iterativa en una fila
  private void imprimirAsteriscos(int cantidad) {
    for (int i = 0; i < cantidad; i++) {
      System.out.print("*");
    }
  }
  public static void main(String[] args) {
    Propuesto3 tr = new Propuesto3();
    int b = 5; // Puedes cambiar este valor
    tr.trianguloRecursivo1(b);
  }
}
