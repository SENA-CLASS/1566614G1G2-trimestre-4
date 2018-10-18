package co.edu.sena.ejemplopoo.tostring;



public class Vaca {
    private String color;
    private String raza;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * es la esprecion del objeto en string
     * @return
     */
    @Override
    public String toString() {
        return "Vaca{" +
                "color='" + color + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
