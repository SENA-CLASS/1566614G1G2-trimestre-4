package co.edu.sena.programming.capitulo08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Ejemplo02 {
    public static void main(String[] args) {
        Properties propiedades = new Properties();
        try {
            FileInputStream file = new FileInputStream("archivo.properties");
            propiedades.load(file);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println(propiedades.getProperty("host"));
        System.out.println(propiedades.getProperty("correo"));
        System.out.println(propiedades.getProperty("password"));
        System.out.println(propiedades.getProperty("auth"));

    }
}
