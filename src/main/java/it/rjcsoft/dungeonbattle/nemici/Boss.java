package it.rjcsoft.dungeonbattle.nemici;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public abstract class Boss extends Nemico{
	
	public Boss(String nome, int max_health, int attacco_base) {
		super(nome, max_health, attacco_base);
		
	}

}
