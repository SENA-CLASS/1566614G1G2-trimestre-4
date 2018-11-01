package co.edu.sena.programming.capitulo06.example01;

public class Main {

    public static void main(String[] args) {
        ElectronicDevice ed = new Television();
        ed.turnOn();
        ed.turnOff();
        //ed.changeChannel(2); // fails
        String s = ed.toString();

        Television t = new Television();
        if (t instanceof ElectronicDevice) {
            System.out.println("si es una instancia");
        }

        Object o = new Television();
        turnObjectOn(o);
    }
    
    public static void turnObjectOn(Object o) {
        if (o instanceof ElectronicDevice) {
            System.out.println("o es una instancia");
            ElectronicDevice e = (ElectronicDevice)o;
            e.turnOn();
        }        
    }
}