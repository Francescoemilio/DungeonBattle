package it.rjcsoft.dungeonbattle.nemici;

public class MindFlayer extends Boss {
	private static final int MAX_VITA = 300;
    private static final int ATTACCO_BASE = 50;
	private static final String NOME = "MINDFLAYER";

	public MindFlayer() {
		super(NOME, MAX_VITA, ATTACCO_BASE);
	}

	@Override
	public void sprite() {
	    System.out.println("           .-''''-.");
	    System.out.println("         .'  .--.  '.");
	    System.out.println("        /   /0  0\\   \\");
	    System.out.println("       |   |  __  |   |");
	    System.out.println("       |   | (__) |   |");
	    System.out.println("        \\   \\_.._/   /");
	    System.out.println("         '.   /\\   .'");
	    System.out.println("           '-/  \\-'");
	    System.out.println("        _.-/|    |\\-._");
	    System.out.println("     _.-'  / |    | \\  '-._");
	    System.out.println("    /___.-'/  |    |  \\-.___\\");
	    System.out.println("        /__/  /    \\  \\__\\");
	}
}

