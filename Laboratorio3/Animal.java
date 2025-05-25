package Laboratorio3;
//Resuelto 3

import java.util.ArrayList;
import java.util.List;

public class Animal {
    String nombre;
    boolean genero;
    public Animal(String nombre, boolean genero) {
        this.nombre = nombre;
        this.genero = genero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isGenero() {
        return genero;
    }
    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    public static void main(String[] args) {
        ArrayList<Animal> mascotas = new ArrayList<Animal>();
       // List<Animal> mascotas2 = new List<Animal>(); //No se puede instanciar directamente a una interfaz
        List<Animal> mascotas3 = new ArrayList<Animal>();
        mascotas.add(new Animal("Toby", true));                        // ArrayList
        System.out.println("ArrayList -> " + mascotas.get(0).getNombre());

        mascotas3.add(new Animal("Luna", false));                      // List (interfaz)
        System.out.println("List -> " + mascotas3.get(0).getNombre());
    }
}
