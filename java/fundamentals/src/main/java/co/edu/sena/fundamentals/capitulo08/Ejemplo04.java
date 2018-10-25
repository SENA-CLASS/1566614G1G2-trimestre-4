package co.edu.sena.fundamentals.capitulo08;

public class Ejemplo04 {
    public static void main(String[] args) {
        int [][] matriz = new int[10][10];

        int con=1;
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                matriz[i][j]= con;
                con++;
            }
        }

        for (int i = 0; i <10 ; i++) {
            System.out.print("[");
            for (int j = 0; j <10 ; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println("]");
        }
    }
}
