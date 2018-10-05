package co.edu.sena.ejemplopoo.generalizacion.ejemplo1;

public class App {

	public static void main(String[] args) {
		Apartamento a = new Apartamento();
		a.setTamanio("45 metros cuadrados");
		a.setColor("ladrillo");
		System.out.println(a.getTamanio());
		System.out.println(a.getColor());
		
		Casa casa = new Casa();
		casa.setTamanio("200 metros cuadrados");
		casa.setColor("cafe");
		System.out.println(casa.getTamanio());
		System.out.println(casa.getColor());
		
		CasaLote casaLote = new CasaLote();
		casaLote.setTamanio("500 metros cuadrados");
		casaLote.setColor("bloque");
		System.out.println(casaLote.getTamanio());
		System.out.println(casaLote.getColor());

	}

}
