package co.edu.sena.ejemplopoo.tostring;

public class Sala {
    private int sillas;
    private String pantalla;
    private Cine cine;

    public int getSillas() {
        return sillas;
    }

    public void setSillas(int sillas) {
        this.sillas = sillas;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "sillas=" + sillas +
                ", pantalla='" + pantalla + '\'' +

                '}';
    }
}
