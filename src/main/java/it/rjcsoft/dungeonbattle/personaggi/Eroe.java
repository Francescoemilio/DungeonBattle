package it.rjcsoft.dungeonbattle.personaggi;

import it.rjcsoft.dungeonbattle.oggetti.*;

import java.util.ArrayList;

public class Eroe extends Personaggio {
	private Oggetto oggetto;
	private ArrayList<Oggetto> o;
	private static final int MAX_VITA = 250;
	private static final int ATTACCO_BASE = 20;

	public Eroe(String nome,  int nPozioni) {
		super(nome ,MAX_VITA,ATTACCO_BASE);
		oggetto = new Pugno();
		o = new ArrayList<Oggetto>(nPozioni);
		System.out.println(o.size() + "    " + nPozioni);
		for (int i = 0; i < nPozioni; i++) {
			o.add(new Pozione(50));
		}
	}

	public Pozione getPozione() {
		Pozione pozione = (Pozione) o.get(0);
		o.remove(0);
		return pozione;

	}

	public void sprite() {
		System.out.println("EROE");
	}

	@Override
	public String toString() {
		return "Eroe [oggetto=" + oggetto + ", o=" + o + "]";
	}
	
	public void stampaInventario() {
		for(int i=0; i<o.size();i++) {
			System.out.println(o.get(i).toString());
			System.out.println("---------");
		}
	}

}