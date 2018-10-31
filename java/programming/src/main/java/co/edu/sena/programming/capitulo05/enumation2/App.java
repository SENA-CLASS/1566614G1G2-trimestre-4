package co.edu.sena.programming.capitulo05.enumation2;

public class App {
    public static void main(String[] args) {
        Aprendiz a = new Aprendiz();
        a.setTipoDocumento("CC");
        a.setNumeroDocumeto("123");
        a.setEstado(EstadoAprendiz.EN_FORMACION);

        System.out.println(a.getEstado());
        System.out.println(a.getEstado().ordinal());
        System.out.println(a.getEstado().getDescripcion());
    }
}
