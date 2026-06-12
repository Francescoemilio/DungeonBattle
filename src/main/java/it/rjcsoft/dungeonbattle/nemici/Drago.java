package it.rjcsoft.dungeonbattle.nemici;

public class Drago extends Boss {
	
	private static final int MAX_VITA = 100;
    private static final int ATTACCO_BASE = 15;
	private static final String NOME = "DRAGO";

	public Drago() {
		super(NOME, MAX_VITA, ATTACCO_BASE);
	}

	@Override
	public void sprite() {
		System.out.println("                 / \\  //\\");
	    System.out.println("        |\\___/|      \\   \\//  .\\");
	    System.out.println("        /0  0  \\      /   //   | \\");
	    System.out.println("       /     /\\ \\    / __/\\   |  \\");
	    System.out.println("       \\_^_\\_\\/ /    /_/  \\/   |   \\");
	    System.out.println("       /__  /\\  \\           |   |");
	    System.out.println("          |/  \\  \\          /   /");
	    System.out.println("          /    \\  \\        /   /");
	    System.out.println("         /      \\  \\______/   /");
	    System.out.println("        /   /\\   /\\          /");
	    System.out.println("       /___/  \\_/  \\________/");
	}
	
}
