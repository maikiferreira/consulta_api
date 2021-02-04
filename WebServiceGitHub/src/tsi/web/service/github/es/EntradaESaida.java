package tsi.web.service.github.es;

import static javax.swing.JOptionPane.*;

public class EntradaESaida {
	/**
	 * Exibe uma mensagem para o usuário
	 * @param mensagem é a mensagem que será exibida.
	 * @param titulo é o titulo da mensagem que será exibida.
	 */
	public static void exibirMensagem(String mensagem, String titulo) {
		showMessageDialog(null, mensagem, titulo, INFORMATION_MESSAGE);
	}
	
	/**
	 * Exibe uma mensagem de erro para o usuário.
	 * @param mensagem é a mensagem de erro que será exibida.
	 * @param titulo é o titulo da mensagem de erro que será exibida.
	 */
	public static void exibirMensagemErro(String mensagem, String titulo) {
		showMessageDialog(null, mensagem, titulo, ERROR_MESSAGE);
	}
	
	/**
	 * Lê um numero int inserido pelo usuário.
	 * @param mensagem é a mensagem informando ao usuário qual valor deve ser inserido.
	 * @param titulo é o titulo da mensagem que será inserida.
	 * @return um int contendo o valor inserido pelo usuário.
	 */
	public static int lerInt(String mensagem, String titulo) {
		return Integer.parseInt(showInputDialog(null, mensagem, titulo, INFORMATION_MESSAGE));
	}
	
	/**
	 * Lê um double inserido pelo usuário.
	 * @param mensagem é a mensagem informando ao usuário qual o valor deve ser inserido.
	 * @param titulo é o titulo da mensagem que será exibida.
	 * @return um double contendo o valor inserido pelo usuário.
	 */
	public static double lerDouble(String mensagem, String titulo) {
		return Double.parseDouble(showInputDialog(null, mensagem, titulo, INFORMATION_MESSAGE));
	}
	
	/**
	 * Lê uma String inserida pelo usuário
	 * @param mensagem é a mensagem informando ao usuário o que deve ser inserido.
	 * @param titulo é o titulo da mensagem que será exibida.
	 * @return uma String contendo o texto inserido pelo usuário.
	 */
	public static String lerString(String mensagem, String titulo) {
		return showInputDialog(null, mensagem, titulo, INFORMATION_MESSAGE);
	}
}
