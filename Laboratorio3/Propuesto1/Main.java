package Laboratorio3.Propuesto1;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new List<>();
        System.out.println("¿Está vacía?: " + myList.isEmpty());
        myList.addLast(10);
        myList.addLast(20);
        myList.addFirst(5);
        System.out.println("Lista actual: " + myList);
        System.out.println("Contiene 20?: " + myList.contains(20));
        System.out.println("Contiene 100?: " + myList.contains(100));
        myList.remove(10);
        System.out.println("Después de eliminar 10: " + myList);
        System.out.println("Tamaño: " + myList.size());
    }
}


