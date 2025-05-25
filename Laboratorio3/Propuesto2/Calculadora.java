package Laboratorio3.Propuesto2;

public class Calculadora {

    public static <T extends Number> double suma(Operador<T> op) {
        return op.getValor1().doubleValue() + op.getValor2().doubleValue();
    }

    public static <T extends Number> double resta(Operador<T> op) {
        return op.getValor1().doubleValue() - op.getValor2().doubleValue();
    }

    public static <T extends Number> double producto(Operador<T> op) {
        return op.getValor1().doubleValue() * op.getValor2().doubleValue();
    }

    public static <T extends Number> double division(Operador<T> op) {
        if (op.getValor2().doubleValue() == 0)
            throw new ArithmeticException("No se puede dividir entre 0.");
        return op.getValor1().doubleValue() / op.getValor2().doubleValue();
    }

    public static <T extends Number> double potencia(Operador<T> op) {
        return Math.pow(op.getValor1().doubleValue(), op.getValor2().doubleValue());
    }

    public static <T extends Number> double raizCuadrada(T valor) {
        return Math.sqrt(valor.doubleValue());
    }

    public static <T extends Number> double raizCubica(T valor) {
        return Math.cbrt(valor.doubleValue());
    }
}

