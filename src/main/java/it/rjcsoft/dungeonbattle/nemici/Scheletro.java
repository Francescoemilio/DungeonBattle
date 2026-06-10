package it.rjcsoft.dungeonbattle.nemici;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public class Scheletro extends Nemico
{
    public Scheletro (String nome,int max_health,int attacco_base){
        super("SCHELETRO", 80,10);
    }

    @Override
    public void sprite() {
        System.out.println("SCHELETRO");
    }
    }
