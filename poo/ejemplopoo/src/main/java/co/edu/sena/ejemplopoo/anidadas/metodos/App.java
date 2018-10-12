package co.edu.sena.ejemplopoo.anidadas.metodos;

import java.lang.invoke.LambdaConversionException;

public class App {
    public static void main(String[] args) {
        class Llave{
            private String marca;
            private float precio;

            public String getMarca() {
                return marca;
            }

            public void setMarca(String marca) {
                this.marca = marca;
            }

            public float getPrecio() {
                return precio;
            }

            public void setPrecio(float precio) {
                this.precio = precio;
            }
        }

        Llave llave = new Llave();
        llave.setMarca("yale");
        llave.setPrecio(3750.5F);

        System.out.println(llave.getMarca());
        System.out.println(llave.getPrecio());



    }
}
