package Laboratorio3;
import java.util.ArrayList;
import java.util.Iterator; 

public class Resuelto2 { 
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
        Iterator<String> itA = alumnos.iterator();
        while (itA.hasNext()) {
            System.out.println(itA.next()); 
        }
    }
}