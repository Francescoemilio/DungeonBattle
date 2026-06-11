package it.rjcsoft.dungeonbattle.personaggi;

import it.rjcsoft.dungeonbattle.oggetti.Oggetto;
import it.rjcsoft.dungeonbattle.oggetti.Pozione;
import java.util.ArrayList;

public class Eroe extends Personaggio {
	private Oggetto oggettoEquipaggiato;
	private ArrayList<Oggetto> inventario;
	private static final int MAX_VITA = 250;
	private static final int ATTACCO_BASE = 20;

	public Eroe(String nome,  Oggetto arma, int nPozioni) {
		super(nome ,MAX_VITA,ATTACCO_BASE);
		oggettoEquipaggiato = arma;
		inventario = new ArrayList<Oggetto>(nPozioni);
		System.out.println(inventario.size() + "    " + nPozioni);
		for (int i = 0; i < nPozioni; i++) {
			inventario.add(new Pozione(50));
		}
	}

	public void stampa() {
		for (int i = 0; i < 10; i++) {
			inventario.get(i).stampa();
		}
	}

	public Pozione getPozione() {
		Pozione pozione = (Pozione) inventario.get(0);
		inventario.remove(0);
		return pozione;

	}

	public void sprite() {
		System.out.println("EROE");
	}

	@Override
	public String toString() {
		return "Eroe [oggetto=" + oggettoEquipaggiato + ", o=" + inventario + "]";
	}
	
	public void stampaInventario() {
		for(int i=0; i<inventario.size();i++) {
			inventario.get(i).stampa();
			System.out.println("---------");
		}
	}

}