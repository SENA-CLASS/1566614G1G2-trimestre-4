package co.edu.sena.programming.capitulo07;

public class App2 {
    public static void main(String[] args) {
        MundoAnimal<Vertebrados> vertebrados = new MundoAnimal<>();

        // este objeto no puede ser creado por que los vegetales no hacen parte del mundo animal no generalizan de animal
        //MundoAnimal<Vegetal> vegetales = new MundoAnimal<>();
    }
}
