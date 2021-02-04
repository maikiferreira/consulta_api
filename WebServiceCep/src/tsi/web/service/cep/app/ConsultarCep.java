package tsi.web.service.cep.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import tsi.web.service.cep.es.EntradaESaida;

public class ConsultarCep {

	public static void main(String[] args) {
		iniciar();
	}
	
	/**
	 * Inicia a execução do programa.
	 */
	public static void iniciar() {
		String cep = EntradaESaida.lerString("Insira o CEP", "Pesquisar CEP");
		exibirCep(pesquisarCep(cep));
	}
	
	/**
	 * Pesquisa os dados do cep consumindo o web service de informações de CEP.
	 * @param cep é o CEP que será pesquisado.
	 * @return ums String contendo os dados do CEP que foi pesquisado.
	 */
	public static String pesquisarCep(String cep) {
		URL url;
		try {
			url = new URL("https://viacep.com.br/ws/" + cep +"/json");
			URLConnection con = url.openConnection();
			BufferedReader input = new BufferedReader(
			 new InputStreamReader(con.getInputStream(), "utf-8")
			);
			String line;
			StringBuilder source = new StringBuilder();
			while((line = input.readLine()) != null)
			 source.append(line);
			input.close();
			return source.toString();
		} catch (IOException e) {
			EntradaESaida.exibirMensagemErro("Erro ao pesquisar o cep.", "Pesquisar CEP");
		}
		return null;
	}

	/**
	 * Exibe os dados do CEP formatados.
	 * @param cep é uma String contendo os dados do CEP que será exibido.
	 */
	public static void exibirCep(String cep) {
		StringBuilder texto = new StringBuilder();
		cep = cep.replace("{", "");
		cep = cep.replace("}", "");
		cep = cep.replace("\"", "");
		String[] campos = cep.split(",");
		for (int i = 0; i < campos.length; i++) {
			String[] camp = campos[i].split(":");
			texto.append(camp[0] + " : " + camp[1] + "\n");
		}
		EntradaESaida.exibirMensagem(texto.toString(), "Pesquisar Cep");
	}
}
