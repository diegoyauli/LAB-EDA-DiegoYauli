package Laboratorio3.Resueltos;
import java.util.ArrayList;
import java.util.Iterator; 

public class Resuelto2 { 
    public static void main(String[] args){
        ArrayList<String> alumnos = new ArrayList<String>();
        alumnos.add("MARIA");
        alumnos.add("DIEGO");
        alumnos.add("RENE");
        alumnos.add("ALONSO");   
        Iterator<String> itA = alumnos.iterator();
        while (itA.hasNext()) {
            System.out.println(itA.next()); 
        }
    }
}