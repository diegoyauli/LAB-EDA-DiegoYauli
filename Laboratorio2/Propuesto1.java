import java.util.Scanner;
public class Propuesto1 {
    // Método para invertir el arreglo
    public static int[] invertirArray(int[] A) {
        int n = A.length;
        int[] Asalida = new int[n];
        for (int i = 0; i < n; i++) {
            Asalida[i] = A[n - 1 - i];
        }
        return Asalida;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese tamaño del vector: ");
        int N = sc.nextInt();
        int[] A = new int[N];
        System.out.println("Ingrese los valores del arreglo:");
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int[] resultado = invertirArray(A);
        System.out.println("Arreglo invertido:");
        for (int val : resultado) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
