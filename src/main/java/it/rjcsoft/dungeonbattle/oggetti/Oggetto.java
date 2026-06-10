package it.rjcsoft.dungeonbattle.oggetti;

import it.rjcsoft.dungeonbattle.personaggi.Personaggio;//non serve che lo scrivo cosa non va

public abstract class Oggetto {
	private String nome;
	private String descrizione;

	public Oggetto(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public void stampa() {
		System.out.println(nome);
		System.out.println(descrizione);
	}
}