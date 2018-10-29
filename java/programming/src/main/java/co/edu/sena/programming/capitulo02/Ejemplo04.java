package co.edu.sena.programming.capitulo02;

public class Ejemplo04 {
    public static void main(String[] args) {
        int x =10;
        int y = x;
        x=5;
        System.out.println(x);
        System.out.println(y);

        Integer a= new Integer(10);
        Integer b= new Integer(a);
        a= new Integer(5);
        System.out.println(a);
        System.out.println(b);

        // estan usando las referencias
        Empleado e1 = new Empleado();
        e1.setId(1);
        Empleado e2 = e1;
        e2.setId(2);
        System.out.println(e1.getId());
        System.out.println(e2.getId());









    }
}
