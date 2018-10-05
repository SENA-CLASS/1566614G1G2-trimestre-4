package co.edu.sena.ejemplopoo.generalizacion.ejemplo2;

public class App {

	public static void main(String[] args) {
		AvionComercial avionComercial = new AvionComercial();
		avionComercial.prender();
		
		Jet jet = new Jet();
		jet.prender();

	}

}
