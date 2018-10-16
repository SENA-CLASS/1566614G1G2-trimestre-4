package co.edu.sena.ejemplopoo.asociacion.ejemplo04;

import java.util.ArrayList;
import java.util.Collection;

public class Factura {
    private Collection<Item> productos;
    private double total;

    public Factura() {
        this.productos = new ArrayList<>();
        this.total=0;
    }

    public void agregarProducto(Item item){
        this.productos.add(item);
        this.total = this.total+ (item.getCantidad()*item.getProducto().getPrecio());
    }

    public double getTotal() {
        return total;
    }

    public Collection<Item> getProductos() {
        return productos;
    }
}
