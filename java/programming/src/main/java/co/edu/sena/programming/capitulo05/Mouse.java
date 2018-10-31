package co.edu.sena.programming.capitulo05;

public class Mouse {
    private static int con =0;

    public Mouse() {
        con++;
    }

    public static int getCon() {
        return con;
    }
}
