package co.edu.sena.ejemplopoo.plimorfismo;


public class App {
    public static void main(String[] args) {
        Animal animal1 = new Perro();
        System.out.println(animal1.getClass().getCanonicalName());
        animal1.respirar();

        Perro perro1 = (Perro)animal1;
        perro1.ladrar();


        Animal animal2 = new Animal();
        // Perro perro2 = (Perro)animal2; este cast no se puede hacer ya que es de arriba hacia abajo


        Perro perro3 = new Perro();
        Animal animal3 = perro3;

    }
}
