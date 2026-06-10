package it.rjcsoft.dungeonbattle.oggetti;

public class Pozione extends Oggetto {
	private int cura;

	public Pozione(int cura) {
		super("Pozione cura", "Pozione");
		this.cura = cura;
	}

	public int getCura() {
		return this.cura;
	}

}