package co.edu.sena.ejemplopoo.constructores;

public class Avion {
    private String serial;

    // contructor generico
    public Avion(){

    }

    // constructor con parametros
    public Avion(String serial){
        this.serial = serial;
    }

    // tercer constructor a partir del segundo constructor ya hay una sobrecarga de constructores
    public Avion(int altura){

    }


    public String getSerial() {
        return serial;
    }
}
