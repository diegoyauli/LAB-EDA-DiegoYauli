public class Propuesto2 {
    public static int[] rotarIzquierdaArray(int[] A, int d) {
        int n = A.length;
        int[] Ainvertido = new int[n];
        d = d % n;  // Por si d > n5
        
        for (int i = 0; i < n; i++) {
            int nuevaPos = (i + n - d) % n;
            Ainvertido[nuevaPos] = A[i];
        }
        return Ainvertido;
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Ingrese tamaño del arreglo: ");
        int N = sc.nextInt();
        int[] A = new int[N];
        System.out.println("Ingrese los valores del arreglo:");
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.print("Ingrese número de posiciones a rotar a la izquierda (d): ");
        int d = sc.nextInt();
        int[] resultado = rotarIzquierdaArray(A, d);
        System.out.println("Arreglo rotado a la izquierda:");
        for (int val : resultado) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
