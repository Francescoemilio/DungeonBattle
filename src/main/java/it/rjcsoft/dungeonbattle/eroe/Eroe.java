package it.rjcsoft.dungeonbattle.eroe;

public class Eroe extends Personaggio{
	private Oggetto oggetto;
	private Oggetto[] o;
	
	public Eroe(String nome,int max_health,int attacco_base, Oggetto obj) {
		super(nome, max_health, attacco_base);
		oggetto=obj;
		o=new Oggetto[10];
	}
	
	public void stampa(){
		for(int i=0; i<10; i++) {
			o[i].stampa();
		}
	}
}