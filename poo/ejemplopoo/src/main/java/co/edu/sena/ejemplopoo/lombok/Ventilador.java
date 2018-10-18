package co.edu.sena.ejemplopoo.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@EqualsAndHashCode

public class Ventilador {
    @Getter @Setter
    private String marca;
    @Getter @Setter
    private String color;

}
