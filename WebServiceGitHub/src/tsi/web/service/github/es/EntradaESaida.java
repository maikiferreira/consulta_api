package tsi.web.service.github.es;

import static javax.swing.JOptionPane.*;

public class EntradaESaida {
	/**
	 * Exibe uma mensagem para o usu�rio
	 * @param mensagem � a mensagem que ser� exibida.
	 * @param titulo � o titulo da mensagem que ser� exibida.
	 */
	public static void exibirMensagem(String mensagem, String titulo) {
		showMessageDialog(null, mensagem, titulo, INFORMATION_MESSAGE);
	}
	
	/**
	 * Exibe uma mensagem de erro para o usu�rio.
	 * @param mensagem � a mensagem de erro que ser� exibida.
	 * @param titulo � o titulo da mensagem de erro que ser� exibida.
	 */
	public static void exibirMensagemErro(String mensagem, String titulo) {
		showMessageDialog(null, mensagem, titulo, ERROR_MESSAGE);
	}
	
	/**
	 * L� um numero int inserido pelo usu�rio.
	 * @param mensagem � a mensagem informando ao usu�rio qual valor deve ser inserido.
	 * @param titulo � o titulo da mensagem que ser� inserida.
	 * @return um int contendo o valor inserido pelo usu�rio.
	 */
	public static int lerInt(String mensagem, String titulo) {
		return Integer.parseInt(showInputDialog(null, mensagem, titulo, INFORMATION_MESSAGE));
	}
	
	/**
	 * L� um double inserido pelo usu�rio.
	 * @param mensagem � a mensagem informando ao usu�rio qual o valor deve ser inserido.
	 * @param titulo � o titulo da mensagem que ser� exibida.
	 * @return um double contendo o valor inserido pelo usu�rio.
	 */
	public static double lerDouble(String mensagem, String titulo) {
		return Double.parseDouble(showInputDialog(null, mensagem, titulo, INFORMATION_MESSAGE));
	}
	
	/**
	 * L� uma String inserida pelo usu�rio
	 * @param mensagem � a mensagem informando ao usu�rio o que deve ser inserido.
	 * @param titulo � o titulo da mensagem que ser� exibida.
	 * @return uma String contendo o texto inserido pelo usu�rio.
	 */
	public static String lerString(String mensagem, String titulo) {
		return showInputDialog(null, mensagem, titulo, INFORMATION_MESSAGE);
	}
}
