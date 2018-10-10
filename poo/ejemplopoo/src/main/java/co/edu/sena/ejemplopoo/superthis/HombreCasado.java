package co.edu.sena.ejemplopoo.superthis;

public class HombreCasado extends Hombre {

    private String anillo;

    public HombreCasado(String nombre, String apellidos, String anillo) {
        super(nombre, apellidos);// llamado a constructor de la clase padre
        this.anillo= anillo;
    }

    public String getAnillo() {
        return this.anillo;
    }

    public void setAnillo(String anillo) {
        this.anillo = anillo;
    }
}
