package co.edu.sena.ejemplopoo.collections;

public class Llavero {
    private int maxCantidadLlaves;
    private Llave [] llaves;
    private int posicionActual;

    public Llavero(int maxCantidadLlaves) {
        this.maxCantidadLlaves = maxCantidadLlaves;
        this.llaves= new Llave[maxCantidadLlaves];
        this.posicionActual=0;
    }

    public void agregarLlave(Llave llave){
        if(posicionActual<maxCantidadLlaves){
            this.llaves[this.posicionActual]= llave;
            System.out.println("se agrego una llave de forma correcta en la posicion: "+posicionActual);
            this.posicionActual++;
        }else{
            System.out.println("a este llavero no le caben mas llaves");
        }
    }

    public void eliminarLlave(Llave llave){
        Llave [] llavesTemporal = new Llave[this.llaves.length];
        int cont=0;
        for (Llave l:this.llaves
             ) {
            if(!l.equals(llave)){
                llavesTemporal[cont]= l;
                cont++;
            }
        }
        this.llaves= llavesTemporal;
        this.posicionActual=cont;
    }

    public void eliminarPrimerLlave(Llave llave){
        Llave [] llavesTemporal = new Llave[this.llaves.length];
        int cont=0;
        int posicion=-1;
        for (int i = 0; i <this.llaves.length ; i++) {
            if(this.llaves[i].equals(llave)){
                posicion=i;
                break;
            }
        }
        if(posicion!=-1)
        for (int i = 0; i <this.llaves.length ; i++) {
            if(i!=posicion){
                llavesTemporal[cont]=this.llaves[i];
                cont++;
            }
        }
        else{
            System.out.println("esa llave no esta en el llavero");
        }
        this.llaves= llavesTemporal;
        this.posicionActual=cont;
    }

    public  void mostarLLaves(){
        for (int i = 0; i <this.posicionActual ; i++) {
            System.out.println(this.llaves[i].getPuerta());
        }
    }

}
