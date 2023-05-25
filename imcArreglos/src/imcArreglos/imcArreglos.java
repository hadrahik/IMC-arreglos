package imcArreglos;

import javax.swing.JOptionPane;

public class imcArreglos {

	String nombres[];
	String telefonos[];
	Double imcArray[];
	String resultadosIMC[];

	public void menu() {
		int opcion = 0;

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("----------menu----------\n\n"
					+ "1.registro\n" 
					+ "2.imprimir\n" 
					+ "3.salir\n\n" 
					+ "----------------------"));
			proceso(opcion);
		} while (opcion != 3);
	}

	public void proceso(int opcion) {
		switch (opcion) {
			case 1:
				registro();
				break;
			case 2:
				imprimir();
				break;
			case 3:
				salir();
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
		}
	}

	private void salir() {
		System.out.println("Gracias por usar el programa");
	}

	private void imprimir() {
		if (nombres != null && nombres.length > 0) {
			for (int i = 0; i < nombres.length; i++) {
				JOptionPane.showInternalMessageDialog(null, "El nombre de la persona es: " + nombres[i] + "\n El telefono: " + telefonos[i]
						+ "\n El resultado del examen es:" + resultadosIMC[i] + "\n su porcentaje de IMC es: " + imcArray[i]);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay registros para imprimir.");
		}
	}

	private String obtenerResultado(double imc) {
		String resultado = "";

		if (imc < 18) {
			resultado = "anorexia";
		} else if (imc >= 18 && imc < 20) {
			resultado = "Delgades";
		} else if (imc >= 20 && imc < 27) {
			resultado = "Normalidad";
		} else if (imc >= 27 && imc < 30) {
			resultado = "Obesidad grado 1";
		} else if (imc >= 30 && imc < 35) {
			resultado = "Obesidad grado 2";
		} else if (imc >= 35 && imc < 40) {
			resultado = "Obesidad grado 3";
		} else {
			resultado = "Obesidad morbida";
		}

		return resultado;
	}

	public void registro() {
		double peso = 0;
		double altura = 0;

		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas a registrar: "));

		nombres = new String[cantidad];
		telefonos = new String[cantidad];
		resultadosIMC = new String[cantidad];
		imcArray = new Double[cantidad];

		double imc = 0;
		String resultado;

		for (int i = 0; i < cantidad; i++) {
			nombres[i] = JOptionPane.showInputDialog("Ingrese su nombre: ");
			telefonos[i] = JOptionPane.showInputDialog("Ingrese su número de teléfono:");
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso: "));
			altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su altura: "));

			imc = obtenerIMC(peso, altura);

			imcArray[i] = imc;

			resultado = obtenerResultado(imc);

			resultadosIMC[i] = resultado;
		}
	}

	private double obtenerIMC(double peso, double altura) {
		double imc = 0;

		imc = peso / (altura * altura);

		return imc;
	}
}