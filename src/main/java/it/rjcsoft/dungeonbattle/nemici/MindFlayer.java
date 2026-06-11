package it.rjcsoft.dungeonbattle.nemici;

public class MindFlayer extends Boss {
	private static final int MAX_VITA = 300;
    private static int ATTACCO_BASE = 50;
	
	public MindFlayer() {
		super("MINDFLAYER", MAX_VITA, ATTACCO_BASE);
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

