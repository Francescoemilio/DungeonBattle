package it.rjcsoft.dungeonbattle.personaggi;

import it.rjcsoft.dungeonbattle.oggetti.Oggetto;
import it.rjcsoft.dungeonbattle.oggetti.Pozione;
import java.util.ArrayList;

public class Eroe extends Personaggio {
	private Oggetto oggetto;
	private ArrayList<Oggetto> o;

	public Eroe(String nome, int maxHealth, int attaccoBase, Oggetto arma, int nPozioni) {
		super(nome, maxHealth, attaccoBase); 
		oggetto = arma;
		o = new ArrayList<Oggetto>(nPozioni);
		System.out.println(o.size() + "    " + nPozioni);
		for (int i = 0; i < nPozioni; i++) {
			o.add(new Pozione(50));
		}
	}

	public void stampa() {
		for (int i = 0; i < 10; i++) {
			o.get(i).stampa();
		}
	}

	public Pozione getPozione() {
		if(o.isEmpty())
			return null;
		else
		{
			Pozione pozione = (Pozione) o.getFirst();
			o.removeFirst();
			return pozione;
		}

	}

	public void sprite() {
		System.out.println("EROE");
	}

	@Override
	public String toString() {
		return "Eroe [oggetto=" + oggetto + ", o=" + o + "]";
	}



}