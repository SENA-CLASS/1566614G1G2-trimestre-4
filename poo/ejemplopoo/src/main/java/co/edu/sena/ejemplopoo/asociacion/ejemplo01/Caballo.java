package co.edu.sena.ejemplopoo.asociacion.ejemplo01;

public class Caballo {
    private Silla silla;
    private Cerebro cerebro;
    private Corazon corazon;

    public Caballo(Cerebro cerebro, Corazon corazon) {
        this.cerebro = cerebro;
        this.corazon = corazon;
    }

    public Silla getSilla() {
        return silla;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    public Cerebro getCerebro() {
        return cerebro;
    }

    public Corazon getCorazon() {
        return corazon;
    }

}
