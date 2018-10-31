package co.edu.sena.programming.capitulo05.enumation2;

public enum EstadoAprendiz {
    DESERTADO("cuando el aprendiz falta mas de tres dias"),
    APLAZADO("cuando el aprendiz tiene problemas"),
    RETIRO_VOLUNTARIO("cuando el aprendiz no quiere estudiar"),
    EN_FORMACION("cuando el aprendiz esta juicios en clase")
    ;

    private String descripcion;

    EstadoAprendiz(String descripcion) {
        this.descripcion= descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
