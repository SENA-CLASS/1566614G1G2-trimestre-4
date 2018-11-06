package co.edu.sena.programming.capitulo08;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args){
        String shirts = "Blue Shirt, Red Shirt, Black Shirt, Maroon Shirt";
        
        StringTokenizer st = new StringTokenizer(shirts, ",");
        System.out.println(st.countTokens());
        
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken().trim());
        }
    }
}
