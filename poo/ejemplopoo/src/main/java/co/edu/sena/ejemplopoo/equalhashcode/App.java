package co.edu.sena.ejemplopoo.equalhashcode;

public class App {
    public static void main(String[] args) {
        Esfero esfero1 = new Esfero();
        System.out.println(esfero1.hashCode());
        esfero1.setId(1);
        esfero1.setColor("rojo");
        esfero1.setMarca("kilometrico");

        Esfero esfero2 = new Esfero();
        System.out.println(esfero2.hashCode());
        esfero2.setId(1);
        esfero2.setColor("rojo");
        esfero2.setMarca("bic");

        if(esfero1.equals(esfero2)){
            System.out.println("son iguales");
        }else{
            System.out.println("no son iguales");
        }


        if(esfero1 == esfero2){// no es correcto
            System.out.println("son iguales");
        }else{
            System.out.printf("son diferentes");
        }


    }
}
