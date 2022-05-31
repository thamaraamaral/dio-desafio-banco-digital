package helpers;

import javax.swing.JOptionPane;

public class ClienteHelper {
	
	public static Integer lerIdCliente() throws Exception {
		String value = JOptionPane.showInputDialog("Informe o ID do cliente:");
		return Integer.parseInt(value);
	}

	public static String lerNome() throws Exception {
		return JOptionPane.showInputDialog("Informe o Nome do cliente:");

	}

	public static String lerEmail() throws Exception {
		return JOptionPane.showInputDialog("Informe o Email do cliente:");

	}
	public static String lerCelular() throws Exception {
		return JOptionPane.showInputDialog("Informe o Celular do cliente:");

	}
}