package co.edu.sena.programming.capitulo07;

public class MundoAnimal<T extends Animal> {
    private T reino;

    public T getReino() {
        return reino;
    }

    public void setReino(T reino) {
        this.reino = reino;
    }
}
