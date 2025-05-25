import java.util.*;
public class CaliEstu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Paso 1 y 2: Leer cantidad de estudiantes y declarar arreglo
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int n = sc.nextInt();
        int[] calificaciones = new int[n];
        // Paso 3: Leer calificaciones
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la calificación del estudiante " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();
        }
        // Paso 4: Ordenar el arreglo
        Arrays.sort(calificaciones);
        // Paso 5: Calcular mediana
        double mediana = calcularMediana(calificaciones);
        // Paso 6: Calcular moda
        int moda = calcularModa(calificaciones);
        // Paso 7: Calcular desviación estándar
        double desviacion = calcularDesviacion(calificaciones);
        // Paso 8: Mostrar resultados
        System.out.println("Mediana: " + mediana);
        System.out.println("Moda: " + moda);
        System.out.printf("Desviación estándar: %.2f\n", desviacion);
        sc.close();
    }
    public static double calcularMediana(int[] arr) {
        int n = arr.length;
        if (n % 2 == 0) {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        } else {
            return arr[n / 2];
        }
    }
    public static int calcularModa(int[] arr) {
        int moda = arr[0];
        int maxFrecuencia = 1;
        int actual = arr[0];
        int frecuencia = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == actual) {
                frecuencia++;
            } else {
                actual = arr[i];
                frecuencia = 1;
            }
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = arr[i];
            }
        }
        return moda;
    }
    public static double calcularDesviacion(int[] arr) {
        int suma = 0;
        for (int num : arr) {
            suma += num;
        }
        double media = (double) suma / arr.length;
        double sumaCuadrados = 0;
        for (int num : arr) {
            sumaCuadrados += Math.pow(num - media, 2);
        }
        return Math.sqrt(sumaCuadrados / arr.length);
    }
}
