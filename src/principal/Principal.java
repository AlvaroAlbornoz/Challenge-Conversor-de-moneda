package principal;

import javax.swing.JOptionPane;

import conversorMonedas.function;
import conversorTemperatura.functionTemperatura;

public class Principal {
	public static void main(String[] args) {

		function monedas = new function();
		functionTemperatura temperatura = new functionTemperatura();
		String opciones = "";
		while (true) {
			try{
			opciones = (JOptionPane.showInputDialog(null, "Seleccione una opción de conversión ", "Menu",
					JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Conversor de Moneda", "Conversor de Temperatura" }, "Seleccion")).toString();
			}catch(NullPointerException e) {
				System.out.println("Cancelado");
				System.out.println(e);
				System.exit(0);
			}
			
			switch (opciones) {
			case "Conversor de Moneda":

				String input = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir: ");
			
				if ( input != null && ValidarNumero(input) == true ) {

					double Minput = Double.parseDouble(input);
					monedas.ConvertirMonedas(Minput);

					int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?");
					if (JOptionPane.OK_OPTION == respuesta) {
						System.out.println("Selecciona opción Afirmativa");
					} else {
						JOptionPane.showMessageDialog(null, "Programa terminado");
						System.exit(0);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
				break;

			case "Conversor de Temperatura":
				input = JOptionPane.showInputDialog("Ingresa el valor de la temperatura que deseas convertir ");
				System.out.println(input);
				if (input != null && ValidarNumero(input) == true) {
					double Minput = Double.parseDouble(input);
					temperatura.ConvertirTemperatura(Minput);

					int respuesta = 0;
					respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
					if ((respuesta == 0) && (ValidarNumero(input) == true)) {
					} else {
						JOptionPane.showMessageDialog(null, "Programa terminado");
						System.exit(0);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
				break;
			}
		}

	}

	public static boolean ValidarNumero(String input) {
		try {
			double x = Double.parseDouble(input);
			if (x >= 0 || x < 0)
				;
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
}
