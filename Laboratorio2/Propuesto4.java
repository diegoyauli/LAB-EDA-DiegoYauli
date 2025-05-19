public class Propuesto4 {
  public void trianguloRecursivo2(int base) {
    imprimirFilas(1, base);
  }
  private void imprimirFilas(int filaActual, int base) {
    if (filaActual > base) {
      return;
    }
    imprimirEspacios(base - filaActual);
    imprimirAsteriscos(filaActual);
    System.out.println();
    imprimirFilas(filaActual + 1, base);
  }
  private void imprimirEspacios(int cantidad) {
    for (int i = 0; i < cantidad; i++) {
      System.out.print(" ");
    }
  }
  private void imprimirAsteriscos(int cantidad) {
    for (int i = 0; i < cantidad; i++) {
      System.out.print("*");
    }
  }
  public static void main(String[] args) {
    Propuesto4 tr = new Propuesto4();
    int b = 5;
    tr.trianguloRecursivo2(b);
  }
}