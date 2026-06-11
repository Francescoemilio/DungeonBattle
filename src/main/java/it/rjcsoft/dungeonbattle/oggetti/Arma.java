package it.rjcsoft.dungeonbattle.oggetti;

public class Arma extends Oggetto {
	private int attacco;


	public Arma(String nome, String documentazione, int attacco) {

		super(nome,documentazione);
		this.attacco = attacco;

	}
	public Arma()
	{
		super("Spada","Spada");
		this.attacco = 0;
	}

	public int getAttacco()
	{
		return this.attacco;
	}

}