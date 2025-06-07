package Laboratorio5.EjercicioResuelto1;

class Node<T> {
    private T valor;
    private Node<T> siguiente;

    public Node(T valor){
        this.valor = valor;
        this.siguiente = null;
    }
    public Node(T valor, Node<T> siguiente){
        this.valor = valor;
        this.siguiente = siguiente;
    } 
    public T getValor(){
        return valor;
    }
    public void setValor(T valor){
        this.valor = valor;
    }
    public Node<T> getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(Node<T> siguiente){
        this.siguiente = siguiente;
    }
    public String toString(){
        return valor.toString();
    }
}
