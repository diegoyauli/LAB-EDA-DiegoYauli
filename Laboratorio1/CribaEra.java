import java.util.Scanner;
public class CribaEra {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Paso 1: Pedir límite superior
    System.out.print("Ingrese el número máximo del rango: ");
    int n = sc.nextInt();
    // Paso 2: Crear arreglo booleano para marcar si un número es primo
    boolean[] esPrimo = new boolean[n + 1];
    // Paso 3: Inicializar todos los valores como verdaderos (excepto 0 y 1)
    for (int i = 2; i <= n; i++) {
      esPrimo[i] = true;
    }
    // Paso 4: Aplicar Criba de Eratóstenes
    for (int i = 2; i * i <= n; i++) {
      if (esPrimo[i]) {
        // Marcar múltiplos de i como no primos
        for (int j = i * i; j <= n; j += i) {
          esPrimo[j] = false;
        }
      }
    }
    // Paso 5 y 6: Imprimir los números que siguen siendo primos
    System.out.println("Números primos hasta " + n + ":");
    for (int i = 2; i <= n; i++) {
      if (esPrimo[i]) {
        System.out.print(i + " ");
      }
    }
    sc.close();
  }
}
