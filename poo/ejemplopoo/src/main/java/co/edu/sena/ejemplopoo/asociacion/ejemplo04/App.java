package co.edu.sena.ejemplopoo.asociacion.ejemplo04;

public class App {
    public static void main(String[] args) {
        Factura factura = new Factura();

        Producto p1 = new Producto();
        p1.setSerial("1");
        p1.setNombre("papas super ricas");
        p1.setPrecio(1200);

        Producto p2 = new Producto();
        p2.setSerial("2");
        p2.setNombre("coca cola 350");
        p2.setPrecio(2500);

        Producto p3 = new Producto();
        p3.setSerial("3");
        p3.setNombre("empanada");
        p3.setPrecio(1500);

        Producto p4 = new Producto();
        p4.setSerial("4");
        p4.setNombre("chocoramo");
        p4.setPrecio(1200);



        factura.agregarProducto(new Item(p1,5));
        System.out.println(factura.getTotal());
        factura.agregarProducto(new Item(p2, 10));
        System.out.println(factura.getTotal());
        factura.agregarProducto(new Item(p1,5));
        System.out.println(factura.getTotal());

        for (Item i:factura.getProductos()
             ) {
            System.out.println(i.toString());
        }


    }
}
