<<<<<<< HEAD
public class InserCon {
  public static void main(String[] args) {
    int[] arreglo = { 7, 3, 5, 2, 9, 1 };
    System.out.println("Arreglo original:");
    imprimirArreglo(arreglo);
    ordenamientoPorInsercion(arreglo);
    System.out.println("Arreglo ordenado:");
    imprimirArreglo(arreglo);
  }
  public static void ordenamientoPorInsercion(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int valorActual = arr[i];
      int j = i - 1;
      // Invariante: arr[0..i-1] está ordenado antes de comenzar esta iteración
      while (j >= 0 && arr[j] > valorActual) {
        arr[j + 1] = arr[j]; // mover elementos mayores una posición a la derecha
        j--;
      }
      arr[j + 1] = valorActual; // insertar valorActual en su posición correcta
      // Invariante se mantiene: arr[0..i] está ordenado
      System.out.print("Paso " + i + " (sublista ordenada hasta índice " + i + "): ");
      imprimirArreglo(arr);
    }
  }
  public static void imprimirArreglo(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
=======
public class InserCon {
  public static void main(String[] args) {
    int[] arreglo = { 7, 3, 5, 2, 9, 1 };
    System.out.println("Arreglo original:");
    imprimirArreglo(arreglo);
    ordenamientoPorInsercion(arreglo);
    System.out.println("Arreglo ordenado:");
    imprimirArreglo(arreglo);
  }
  public static void ordenamientoPorInsercion(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int valorActual = arr[i];
      int j = i - 1;
      // Invariante: arr[0..i-1] está ordenado antes de comenzar esta iteración
      while (j >= 0 && arr[j] > valorActual) {
        arr[j + 1] = arr[j]; // mover elementos mayores una posición a la derecha
        j--;
      }
      arr[j + 1] = valorActual; // insertar valorActual en su posición correcta
      // Invariante se mantiene: arr[0..i] está ordenado
      System.out.print("Paso " + i + " (sublista ordenada hasta índice " + i + "): ");
      imprimirArreglo(arr);
    }
  }
  public static void imprimirArreglo(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
>>>>>>> 89f174fa131a7f5aeb52ab87ac65bc46ba98fd4b
