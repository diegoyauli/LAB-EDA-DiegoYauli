public class Propuesto6 {
  public void cuadradoRecursivo(int base) {
    imprimirFila(1, base);
  }
  // Recursión para imprimir fila por fila
  private void imprimirFila(int filaActual, int base) {
    if (filaActual > base)
      return;
    imprimirColumna(filaActual, 1, base);
    System.out.println();
    imprimirFila(filaActual + 1, base);
  }
  // Recursión para imprimir columnas de una fila
  private void imprimirColumna(int fila, int columna, int base) {
    if (columna > base)
      return;
    // Condición para imprimir asterisco en bordes
    if (fila == 1 || fila == base || columna == 1 || columna == base) {
      System.out.print("*");
    } else {
      System.out.print(" ");
    }
    imprimirColumna(fila, columna + 1, base);
  }
  public static void main(String[] args) {
    Propuesto6 fr = new Propuesto6();
    int b = 5;
    fr.cuadradoRecursivo(b);
  }
}
