public class Propuesto5 {
  public void trianguloRecursivo3(int base) {
    imprimirFila(1, base);
  }
  private void imprimirFila(int filaActual, int base) {
    if (filaActual > base)
      return;
    // Imprime espacios (base - filaActual)
    imprimirEspacios(base - filaActual);
    // Imprime asteriscos (2 * filaActual - 1)
    imprimirAsteriscos(2 * filaActual - 1);
    System.out.println();
    imprimirFila(filaActual + 1, base);
  }
  private void imprimirEspacios(int cantidad) {
    if (cantidad == 0)
      return;
    System.out.print(" ");
    imprimirEspacios(cantidad - 1);
  }
  private void imprimirAsteriscos(int cantidad) {
    if (cantidad == 0)
      return;
    System.out.print("*");
    imprimirAsteriscos(cantidad - 1);
  }
  public static void main(String[] args) {
    Propuesto5 tr = new Propuesto5();
    int b = 5;
    tr.trianguloRecursivo3(b);
  }
}