package co.edu.sena.ejemplopoo.metodos;

public class Tanque {
    private String color;
    private int ruedas;
    private int cantidadBalas;

    public Tanque(String color, int ruedas) {
        this.color = color;
        this.ruedas = ruedas;
        this.cantidadBalas = 0;
    }

    public void cargar(int cantidadValas) {
        this.cantidadBalas = this.cantidadBalas + cantidadValas;
    }

    public void disparar() {
        if (this.cantidadBalas > 0) {
            this.cantidadBalas = this.cantidadBalas - 1;
            System.out.println("buummmmmmmmmm");
        } else {
            System.out.println("OJO no hay balas");
        }
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getCantidadBalas() {
        return cantidadBalas;
    }

    public void setCantidadBalas(int cantidadBalas) {
        this.cantidadBalas = cantidadBalas;
    }
}
