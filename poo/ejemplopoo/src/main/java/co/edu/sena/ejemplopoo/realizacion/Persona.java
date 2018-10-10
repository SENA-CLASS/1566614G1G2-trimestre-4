package co.edu.sena.ejemplopoo.realizacion;

public class Persona implements Ciego, Sordo{

    @Override
    public void hablar(){
        System.out.println("hablo");
    }

    @Override
    public void ver(){
        System.out.println("veo");
    }

    @Override
    public void caminar(){
        System.out.println("camino");
    }

    @Override
    public void escuchar(){
        System.out.println("escucha");
    }

    @Override
    public void tantear() {
        System.out.println("toca con el bastón");
    }

    @Override
    public void comer(){
        System.out.println("estoy comiendo");
    }
}
