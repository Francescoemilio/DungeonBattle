package it.rjcsoft.dangeounbattle.nemici;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public class Goblin extends Nemico
{
    public Goblin (String nome,int max_health,int attacco_base){
        super("GOBLIN", 100,15);
    }

    @Override
    public void sprite() {
        System.out.println("GOBLIN");
    }
}