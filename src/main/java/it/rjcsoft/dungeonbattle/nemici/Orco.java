package it.rjcsoft.dungeonbattle.nemici;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public class Orco extends Nemico
{
    public Orco (String nome,int max_health,int attacco_base){
        super("ORCO", 150,30);
    }
    @Override
    public void sprite() {
        System.out.println("ORCO");
    }
}