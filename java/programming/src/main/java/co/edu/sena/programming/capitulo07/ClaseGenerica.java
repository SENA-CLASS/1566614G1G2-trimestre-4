package co.edu.sena.programming.capitulo07;

public class ClaseGenerica<T, T2> {
    private T atributoUno;
    private T2 atributoDos;

    public T getAtributoUno() {
        return atributoUno;
    }

    public void setAtributoUno(T atributoUno) {
        this.atributoUno = atributoUno;
    }

    public T2 getAtributoDos() {
        return atributoDos;
    }

    public void setAtributoDos(T2 atributoDos) {
        this.atributoDos = atributoDos;
    }
}
