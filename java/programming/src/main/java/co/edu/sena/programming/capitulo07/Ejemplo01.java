package co.edu.sena.programming.capitulo07;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ejemplo01 {
    public static void main(String[] args) {
        Object [] arreglo = new Object[10];
        arreglo[0]= "hola";
        arreglo[1]= 12;
        arreglo[2]= "asdfsd";


        for (int i = 0; i <arreglo.length ; i++) {
            if(arreglo[i] instanceof String) {
                String st = (String) arreglo[i];
                System.out.println(st.toUpperCase());
            }else{
                System.out.println("el arregloen la pcsicion no tiene un string"+i);
            }
        }

        List<String> lista = new ArrayList<>();
        lista.add("adsfasd");
        lista.add("adsfasd");

        for (String i:lista) {
            System.out.println(i);
        }





    }
}
