package co.edu.sena.programming.capitulo09;

public class MiExcepcionesAritmeticas extends ArithmeticException {
    public MiExcepcionesAritmeticas(Throwable e) {
        super();
    }

    public MiExcepcionesAritmeticas(String s, Throwable e) {
        super(s);
    }
}
