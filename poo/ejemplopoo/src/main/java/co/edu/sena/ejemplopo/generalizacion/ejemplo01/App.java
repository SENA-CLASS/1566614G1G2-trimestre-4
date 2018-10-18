package co.edu.sena.ejemplopo.generalizacion.ejemplo01;

public class App {
    public static void main(String[] args) {
        Camioneta camioneta= new Camioneta();
        System.out.println("esto monstrando la camioneta");
        mostrarCarro(camioneta);
        Deportivo deportivo = new Deportivo();
        System.out.println("estoy mostrando el deportivo");
        mostrarCarro(deportivo);
    }

    public static void mostrarCarro(Carro carro){
        carro.prender();
        carro.apagar();
        if(carro instanceof Camioneta){
            ((Camioneta)carro).cargar();
        }
    }

}
