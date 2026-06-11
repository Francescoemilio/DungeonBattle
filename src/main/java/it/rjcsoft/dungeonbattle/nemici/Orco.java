package it.rjcsoft.dungeonbattle.nemici;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public class Orco extends Nemico {

    private static final int MAX_VITA = 150;
    private static final int ATTACCO_BASE = 30;
    private static final String NOME = "ORCO";

    public Orco() {
        super(NOME, MAX_VITA, ATTACCO_BASE);
    }

    @Override
    public void sprite() {
        System.out.println("                        _,.---''```````'-.");
        System.out.println("                    ,-'`                  `-._");
        System.out.println("                 ,-`                   __,-``,\\");
        System.out.println("                /             _       /,'  ,|/ \\");
        System.out.println("              ,'         ,''-<_`'.    |  ,' |   \\");
        System.out.println("             /          / _    `  `.  | / \\ |\\  |");
        System.out.println("             |         (  |`'-,---, `'  \\_|/ |  |");
        System.out.println("             |         |`  \\  \\|  /  __,    _ \\ |");
        System.out.println("             |         |    `._\\,'  '    ,-`_\\ \\|");
        System.out.println("             |         |        ,----      /|   )");
        System.out.println("             \\         \\       / --.      {/   /|");
        System.out.println("              \\         | |       `.\\         / |");
        System.out.println("               \\        / `-.                 | /");
        System.out.println("                `.     |     `-        _,--V`)\\/        _-");
        System.out.println("                  `,   |           /``V_,.--`  \\.  _,-'`");
        System.out.println("                   /`--'`._        `-'`         )`'");
        System.out.println("                  /        `-.            _,.-'`");
        System.out.println("                              `-.____,.-'`");


    }
}