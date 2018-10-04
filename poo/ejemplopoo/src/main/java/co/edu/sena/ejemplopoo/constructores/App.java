package co.edu.sena.ejemplopoo.constructores;

public class App {
    public static void main(String[] args) {
        Avion avion1= new Avion();
        System.out.println(avion1.getSerial());



        Avion avion2= new Avion("123");
        System.out.println(avion2.getSerial());
    }
}
