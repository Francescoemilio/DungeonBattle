package it.rjcsoft.dungeonbattle.nemici;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public class Scheletro extends Nemico {
    private static final int MAX_VITA = 80;
    private static final int ATTACCO_BASE = 10;

    public Scheletro(String nome) {
        super("SCHELETRO", MAX_VITA, ATTACCO_BASE);
    }

    @Override
    public void sprite() {
        System.out.println("SCHELETRO");
    }
}
