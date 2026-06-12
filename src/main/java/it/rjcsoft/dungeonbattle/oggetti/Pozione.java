package it.rjcsoft.dungeonbattle.oggetti;

public class Pozione extends Oggetto {

	private static int CURA = 50;
	public Pozione() {
		super("Pozione cura", "Pozione");

	}

	public static int getCura() {
		return CURA;
	}

}