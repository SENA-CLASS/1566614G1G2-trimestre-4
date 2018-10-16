package co.edu.sena.ejemplopoo.equalhashcode;

public class App {
    public static void main(String[] args) {
        Esfero esfero1 = new Esfero();
        System.out.println("esfero1 :" +esfero1.hashCode());
        esfero1.setId(1);
        System.out.println("esfero1 :" +esfero1.hashCode());
        esfero1.setColor("rojo");
        System.out.println("esfero1 :" +esfero1.hashCode());
        esfero1.setMarca("bic");
        System.out.println("esfero1 :" +esfero1.hashCode());


        Esfero esfero2 = new Esfero();
        System.out.println("esfero2: "+esfero2.hashCode());
        esfero2.setId(1);
        System.out.println("esfero2: "+esfero2.hashCode());
        esfero2.setColor("rojo");
        System.out.println("esfero2: "+esfero2.hashCode());
        esfero2.setMarca("kilometrico");
        System.out.println("esfero2: "+esfero2.hashCode());



        if(esfero1.equals(esfero2)){
            System.out.println("son iguales");
        }else{
            System.out.println("no son iguales");
        }



    }
}
