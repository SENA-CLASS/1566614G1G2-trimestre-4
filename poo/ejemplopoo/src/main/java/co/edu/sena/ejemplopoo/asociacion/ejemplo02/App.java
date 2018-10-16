package co.edu.sena.ejemplopoo.asociacion.ejemplo02;

public class App {
    public static void main(String[] args) {
        Casa casa1 = new Casa();
        casa1.setHabitantes(new Habitante[5]);// tiene fijo bases no son fijas
        casa1.getHabitantes()[0]= new Habitante();
        casa1.getHabitantes()[1]= new Habitante();
        casa1.getHabitantes()[3]= new Habitante();
        casa1.getHabitantes()[4]= new Habitante();
        casa1.getHabitantes()[6]= new Habitante();
        casa1.getHabitantes()[7]= new Habitante();
        for (int i = 0; i <casa1.getHabitantes().length ; i++) {
            System.out.println(casa1.getHabitantes()[i]);
        }


    }
}
