package co.edu.sena.ejemplopoo.lombok;

public class App {
    public static void main(String[] args) {
        Ventilador ventilador= new Ventilador();

        Vapeador vapeador= new Vapeador();
        if(vapeador.canEqual(ventilador)){
            System.out.println("los dos objetos son del mismo tipo");
        }else{
            System.out.println("los dos objetos son de diferente tipo");
        }

        if(vapeador instanceof Vapeador){
            System.out.println("es un vapeador");
        }else{
            System.out.println("no es un vapeador");
        }


        Object [] objetos = new Object[10];
        objetos[0]= new String("hola");
        objetos[1]= new Vapeador();


    }
}
