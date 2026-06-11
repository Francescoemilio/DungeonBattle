package it.rjcsoft.dungeonbattle.oggetti;

import it.rjcsoft.dungeonbattle.personaggi.Personaggio;//non serve che lo scrivo cosa non va

public abstract class Oggetto {
	private String nome;
	private String descrizione;

	public Oggetto(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Oggetto{" +
				"nome='" + nome + '\'' +
				", descrizione='" + descrizione + '\'' +
				'}';
	}

	public String getNome() {
		return nome;
	}
}