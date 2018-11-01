package co.edu.sena.programming.capitulo06.patronabstracfactory;

public class App2 {
    public static void main(String[] args) {
        ReyOrco reyOrco = new ReyOrco();
        CastilloOrco castilloOrco = new CastilloOrco();
        EjercitoOrco ejercitoOrco =new EjercitoOrco();

        reyOrco.gobernar();
        castilloOrco.defender();
        ejercitoOrco.combatir();
    }
}
