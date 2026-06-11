package it.rjcsoft.dungeonbattle.nemici;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public class Orco extends Nemico {

    private static final int MAX_VITA = 150;
    private static final int ATTACCO_BASE = 30;

    public Orco(String nome) {
        super("ORCO", MAX_VITA, ATTACCO_BASE);
    }

    @Override
    public void sprite() {
        System.out.println("ORCO");
    }
}