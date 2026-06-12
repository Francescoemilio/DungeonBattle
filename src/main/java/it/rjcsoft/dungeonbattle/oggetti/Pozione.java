package it.rjcsoft.dungeonbattle.oggetti;

public class Pozione extends Oggetto {

	private static final String NOME = "POZIONE";
	private static final String DESCRIZIONE = "Una pozione magica che conferisce poteri rigenerativi";

	private static final int CURA = 50;
	public Pozione() {
		super(NOME, DESCRIZIONE);

	}

	public static int getCura() {
		return CURA;
	}

}