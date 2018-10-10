package co.edu.sena.ejemplopoo.metodoestatico;

public class Calculadora {
	
	private Calculadora() {
		
	}

	public static void suma(int a, int b) {
		System.out.println(a + b);
	}

	public  static void resta(int a, int b) {
		System.out.println(a - b);
	}

	public static void multiplicacion(int a, int b) {
		System.out.println(a * b);
	}

	public static void division(int a, int b) {
		System.out.println(a / b);
	}

}
