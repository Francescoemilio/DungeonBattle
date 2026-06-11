package it.rjcsoft.dungeonbattle.oggetti;

public class Arma extends Oggetto {
	private int attacco;

	public Arma(int attacco) {

		super("Spada", "Spada");
		this.attacco = attacco;

	}
	public Arma()
	{
		super("Spada","Spada");
		this.attacco = 0;
	}

}