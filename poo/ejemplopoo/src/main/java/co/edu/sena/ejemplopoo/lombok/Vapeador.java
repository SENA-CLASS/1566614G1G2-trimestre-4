package co.edu.sena.ejemplopoo.lombok;

public class Vapeador {
    private String marca;
    private String color;
    private String voltaje;

    public Vapeador() {
    }

    public String getMarca() {
        return this.marca;
    }

    public String getColor() {
        return this.color;
    }

    public String getVoltaje() {
        return this.voltaje;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Vapeador)) return false;
        final Vapeador other = (Vapeador) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$marca = this.getMarca();
        final Object other$marca = other.getMarca();
        if (this$marca == null ? other$marca != null : !this$marca.equals(other$marca)) return false;
        final Object this$color = this.getColor();
        final Object other$color = other.getColor();
        if (this$color == null ? other$color != null : !this$color.equals(other$color)) return false;
        final Object this$voltaje = this.getVoltaje();
        final Object other$voltaje = other.getVoltaje();
        if (this$voltaje == null ? other$voltaje != null : !this$voltaje.equals(other$voltaje)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $marca = this.getMarca();
        result = result * PRIME + ($marca == null ? 43 : $marca.hashCode());
        final Object $color = this.getColor();
        result = result * PRIME + ($color == null ? 43 : $color.hashCode());
        final Object $voltaje = this.getVoltaje();
        result = result * PRIME + ($voltaje == null ? 43 : $voltaje.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Vapeador;
    }

    public String toString() {
        return "Vapeador(marca=" + this.getMarca() + ", color=" + this.getColor() + ", voltaje=" + this.getVoltaje() + ")";
    }
}
