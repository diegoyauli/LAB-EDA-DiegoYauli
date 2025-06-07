package Laboratorio5.EjercicioPropuesto1;

public class StackList<T> implements Stack<T> {
    private Node<T> tope;

    public StackList() {
        this.tope = null;
    }

    public void push(T x){
        Node<T> nuevoNodo = new Node<>(x);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    public T pop(){
        if (isEmpty()) throw new IllegalStateException("Pila vacía");
        T valor = tope.getValor();
        tope = tope.getSiguiente();
        return valor;
    }

    public T top(){
        if (isEmpty()) throw new IllegalStateException("Pila vacía");
        return tope.getValor();
    }

    public boolean isEmpty(){
        return tope == null;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        Node<T> actual = tope;
        while (actual != null){
            str.append(actual.getValor()).append(", ");
            actual = actual.getSiguiente();
        }
        return str.toString();
    }
}

