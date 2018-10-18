package co.edu.sena.ejemplopoo.tostring;

import java.util.List;

public class Cine {
    private String direccion;
    private int id;
    private String empresa;

    private List<Sala> salaList;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<Sala> getSalaList() {
        return salaList;
    }

    public void setSalaList(List<Sala> salaList) {
        this.salaList = salaList;
    }

    @Override
    public String toString() {
        return "Cine{" +
                "direccion='" + direccion + '\'' +
                ", id=" + id +
                ", empresa='" + empresa + '\'' +
                ", salaList=" + salaList +
                '}';
    }
}
