package tsi.web.service.github.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import tsi.web.service.github.es.EntradaESaida;

public class ConsultarUsuario {

	public static void main(String[] args) {
		iniciar();
	}

	/**
	 * Inicia a execu��o do programa.
	 */
	public static void iniciar() {
		StringBuilder texto = new StringBuilder();
		String nomeUsuario = EntradaESaida.lerString("Insira o nome do usuario", "Consultar Usu�rio");
		texto.append("Usu�rio da consulta: " + nomeUsuario + "\n\n");
		
		String consultaUsuario = realizarRequisi��o("https://api.github.com/users/" + nomeUsuario);
		String dadosSeguidores = realizarRequisi��o(obterUrlSeguidores(consultaUsuario));
 		
		List<String> nomesSeguidores = obterNomeSeguidores(dadosSeguidores);
		texto.append(nomesSeguidores.size() + " seguidores: \n\n");
		for (int i = 0; i < nomesSeguidores.size(); i++) {
			texto.append(nomesSeguidores.get(i) + "\n");
			String url = obterRepositorios(nomesSeguidores.get(i));
			texto.append(obterNomeRepos(url));
		}
		
		System.out.println(texto.toString());
	}
	
	/**
	 * Realiza uma requisi��o.
	 * @param textoUrl � a url em que ser� feita a requisi��o.
	 * @return uma String contento os dados da requisi��o.
	 */
	public static String realizarRequisi��o(String textoUrl) {
		URL url;
		try {
			url = new URL(textoUrl);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obt�m os seguidores de um usu�rio.
	 * @param dadosUsuario � os dados do usu�rio obtido da requisi��o.
	 * @return uma String contendo a url do seguidor.
	 */
	public static String obterUrlSeguidores(String dadosUsuario) {
		dadosUsuario = dadosUsuario.replace("{", "");
		dadosUsuario = dadosUsuario.replace("}", "");
		dadosUsuario = dadosUsuario.replace("\"", "");
		String[] campos = dadosUsuario.split(",");
		for (int i = 0; i < campos.length; i++) {
			String[] camp = campos[i].split(":");
			if(camp[0].equals("followers_url") == true)
				return camp[1] + ":" + camp[2];
		}
		return null;
	}
	
	/**
	 * Obt�m os nomes dos seguidores.
	 * @param dadosSeguiores cont�m os dados do usuario pesquisado.
	 * @return um List contendo os nomes dos seguidores.
	 */
	public static List<String> obterNomeSeguidores(String dadosSeguiores) {
		List<String> seguidores = new ArrayList<String>();
		String dados[] = dadosSeguiores.split("login\":\"");
		for (int i = 1; i < dados.length; i++) {
			String dadosUser[] = dados[i].split("\"");
			seguidores.add(dadosUser[0]);
		}
		return seguidores;
	}

	/**
	 * Obt�m os repositorios dos seguidores.
	 * @param nome � uma String contendo o nome do seguidor.
	 * @return uma String contendo o repositorio do seguidor.
	 */
	public static String obterRepositorios(String nome) {
		String dadosUsuario = realizarRequisi��o("https://api.github.com/users/" + nome);
		dadosUsuario = dadosUsuario.replace("{", "");
		dadosUsuario = dadosUsuario.replace("}", "");
		dadosUsuario = dadosUsuario.replace("\"", "");
		String[] campos = dadosUsuario.split(",");
		for (int i = 0; i < campos.length; i++) {
			String camp[] = campos[i].split(":");
			if(camp[0].equals("repos_url") == true)
				return camp[1] + ":" + camp[2];
		}
		return null;
	}
	
	/**
	 * Obt�m os nomes dos repositorios.
	 * @param url � a url do repositorio do seguidor.
	 * @return uma string contendo o nome do repositorio.
	 */
	public static String obterNomeRepos(String url) {
		StringBuilder texto = new StringBuilder();
		String dados = realizarRequisi��o(url);
		dados = dados.replace("{", "");
		dados = dados.replace("}", "");
		dados = dados.replace("\"", "");
		String[] campos = dados.split(",");
		for (int i = 0; i < campos.length; i++) {
			String camp[] = campos[i].split(":");
			if(camp[0].equals("name") == true)
				texto.append("\t" + camp[1] + "\n");
		}
		return texto.toString();
	}
}
