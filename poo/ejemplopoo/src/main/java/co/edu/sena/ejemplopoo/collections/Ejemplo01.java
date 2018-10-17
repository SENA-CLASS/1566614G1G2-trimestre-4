package co.edu.sena.ejemplopoo.collections;

public class Ejemplo01 {
    public static void main(String[] args) {
        //arreglos
        int [] a = new int[10];// tamaño fijo
        System.out.println(a);

        String [] arregloPalabras = new String[10];

        Mesa [] arregloMesas = new Mesa[5];

        int [] arreeglo = new int[10];
        for (int i = 0; i <arreeglo.length ; i++) {
            arreeglo[i]=i+1;
        }
        for (int i = 0; i <arreeglo.length ; i++) {
            System.out.println(arreeglo[i]);
        }

        int [] t = new int[10];
        int cont=0;
        for (int i = 0; i <t.length ; i++) {
            if(i != 4){
                t[cont]= arreeglo[i];
                cont++;
            }
        }
        arreeglo = t;


        for (int i = 0; i <arreeglo.length ; i++) {
            System.out.println(arreeglo[i]);
        }

        for (int i = 0; i <arregloMesas.length ; i++) {
            arregloMesas[i]= new Mesa(i);
        }

        for (int i = 0; i <arregloMesas.length ; i++) {
            System.out.println(arregloMesas[i].toString());
        }

        Mesa [] mesasTemporal = new Mesa[arregloMesas.length];
        cont=0;
        for (int i = 0; i <arregloMesas.length ; i++) {
            if(i!=2){
                mesasTemporal[cont]= arregloMesas[i];
                cont++;
            }
        }
        arregloMesas = mesasTemporal;
        for (int i = 0; i <arregloMesas.length ; i++) {
            System.out.println(arregloMesas[i].toString());
        }
        arregloMesas[4]= new Mesa(6);





    }


}
