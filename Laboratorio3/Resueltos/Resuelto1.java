package Laboratorio3.Resueltos;
import java.util.ArrayList;

public class Resuelto1 { 
    public static void main(String[] args){
        ArrayList<String> alumnos = new ArrayList<String>();
        ArrayList<Integer> notas = new ArrayList<Integer>();
        alumnos.add("MARIA");
        alumnos.add("DIEGO");
        alumnos.add("RENE");
        alumnos.add("ALONSO");
        System.out.println(alumnos.hashCode()); 
        System.out.println(alumnos.isEmpty());  
        System.out.println(alumnos.size());     
    }
}