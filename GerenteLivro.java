package com.biblioteca;

import java.util.*;

public class GerenteLivro {

	private Map<String, Livro> livros = new HashMap<String, Livro>();

	// CADASTRAR LIVRO
	public void CadastraLivros(String numeroDeRegistro, Livro livro) {

		if (getLivros().containsKey(numeroDeRegistro)) {
			lancarExcecao("Numero de registro ja existe");
		}
		if (numeroDeRegistro == null) {
			lancarExcecao("Numero de registro nulo");
		}
		getLivros().put(numeroDeRegistro, livro);
		// entradaDeLivro();
	}

	
	// CONSULTAR LIVRO
	public boolean ConsultarLivro(String numeroDeRegistro) {
		if (!getLivros().containsKey(numeroDeRegistro)) {
			lancarExcecao("Livro não encontrado");
		}
		return getLivros().containsKey(numeroDeRegistro);
	}

	// REMOVER LIVRO
	public boolean RemoverLivro(String numeroDeRegistro) {

		if (getLivros().containsKey(numeroDeRegistro)) {
			getLivros().remove(numeroDeRegistro);
			return true;
		} else
			lancarExcecao("Livro não foi removido");
		return false;
	}

	private static void lancarExcecao(String msg) {
		throw new BibliotecaException(msg);
	}


	Map<String, Livro> getLivros() {
		return livros;
	}


	private void setLivros(Map<String, Livro> livros) {
		this.livros = livros;
	}
}
