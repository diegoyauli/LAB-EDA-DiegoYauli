package Laboratorio3.Propuesto2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú de Operaciones Clases Genéricas:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir del Programa");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("¿Tipo de dato? (int/double): ");
                String tipo = sc.next();
                System.out.print("Ingrese el primer valor: ");
                double v1 = sc.nextDouble();
                System.out.print("Ingrese el segundo valor: ");
                double v2 = sc.nextDouble();

                if (tipo.equalsIgnoreCase("int")) {
                    Operador<Integer> op = new Operador<>((int)v1, (int)v2);
                    ejecutarOperacion(opcion, op);
                } else {
                    Operador<Double> op = new Operador<>(v1, v2);
                    ejecutarOperacion(opcion, op);
                }

            } else if (opcion == 6 || opcion == 7) {
                System.out.print("¿Tipo de dato? (int/double): ");
                String tipo = sc.next();
                System.out.print("Ingrese el valor: ");
                double v = sc.nextDouble();

                if (tipo.equalsIgnoreCase("int")) {
                    if (opcion == 6)
                        System.out.println("Raíz Cuadrada: " + Calculadora.raizCuadrada((int)v));
                    else
                        System.out.println("Raíz Cúbica: " + Calculadora.raizCubica((int)v));
                } else {
                    if (opcion == 6)
                        System.out.println("Raíz Cuadrada: " + Calculadora.raizCuadrada(v));
                    else
                        System.out.println("Raíz Cúbica: " + Calculadora.raizCubica(v));
                }

            } else if (opcion == 8) {
                salir = true;
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    // Método auxiliar para ejecutar operaciones básicas
    public static <T extends Number> void ejecutarOperacion(int opcion, Operador<T> op) {
        switch (opcion) {
            case 1:
                System.out.println("Resultado de la suma: " + Calculadora.suma(op));
                break;
            case 2:
                System.out.println("Resultado de la resta: " + Calculadora.resta(op));
                break;
            case 3:
                System.out.println("Resultado del producto: " + Calculadora.producto(op));
                break;
            case 4:
                try {
                    System.out.println("Resultado de la división: " + Calculadora.division(op));
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 5:
                System.out.println("Resultado de la potencia: " + Calculadora.potencia(op));
                break;
        }
    }
}

