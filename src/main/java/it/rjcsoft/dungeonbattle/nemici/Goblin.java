package it.rjcsoft.dungeonbattle.nemici;



import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public class Goblin extends Nemico {

    private static final int MAX_VITA = 80;
    private static final int ATTACCO_BASE = 15;
    private static final String NOME = "GOBLIN";

    public Goblin() {
        super(NOME, MAX_VITA, ATTACCO_BASE);
    }

    @Override
    public void sprite(){

                System.out.println("             ,      ,");
                System.out.println("            /(.-\"\"-.)\\");
                System.out.println("        |\\   /      %   /|");
                System.out.println("        | \\ / =.  .= % / |");
                System.out.println("        \\(     o  o   / )/");
                System.out.println("         \\_, '-/  \\-' ,_/");
                System.out.println("           /   \\__/   ) ");
                System.out.println("           ! %__/\\__/ /");
                System.out.println("         ___!  %|--|/ /___");
                System.out.println("       /`    !       /    `\\");
                System.out.println("      /       '----'       \\");


    }
}