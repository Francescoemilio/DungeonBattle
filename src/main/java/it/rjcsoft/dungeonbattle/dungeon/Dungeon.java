package it.rjcsoft.dungeonbattle.dungeon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import it.rjcsoft.dungeonbattle.combatsystem.BattleManager;
import it.rjcsoft.dungeonbattle.oggetti.Arma;
import it.rjcsoft.dungeonbattle.personaggi.*;
import it.rjcsoft.dungeonbattle.nemici.Goblin;
import it.rjcsoft.dungeonbattle.nemici.Orco;
import it.rjcsoft.dungeonbattle.nemici.Scheletro;


public class Dungeon {
    private ArrayList<Nemico> nemici;
    private Nemico[] listaNemici;
    private final Scanner input = new Scanner(System.in);
    private Eroe eroe;
    private final int NPOZIONI_INIZIALI = 4;


    public Dungeon() {
        nemici = new ArrayList<>();
        listaNemici = new Nemico[9];
        //è UNA COSTANTE?
    }


    public void generaNemici(int quantita) {

        listaNemici = new Nemico[9];
        listaNemici[0] = new Orco("ORCO");
        listaNemici[1] = new Goblin("GOBLIN");
        listaNemici[2] = new Scheletro("SCHELETRO");
        listaNemici[3] = new Orco("ORCO");
        listaNemici[4] = new Goblin("GOBLIN");
        listaNemici[5] = new Scheletro("SCHELETRO");
        listaNemici[6] = new Orco("ORCO");
        listaNemici[7] = new Goblin("GOBLIN");
        listaNemici[8] = new Scheletro("SCHELETRO");
        for(int i = 0; i < quantita; i++) {
            nemici.add(listaNemici[i]);

        }
    }

    public void start()throws IOException{
        if (this.eroe == null) {
            this.eroe = new Eroe("Francesco Barsotti", new Arma(), NPOZIONI_INIZIALI);
        } else {

            this.eroe.setHealth(eroe.getMaxHealth());
        }
        System.out.println("Sei entrato nel dungeon");
        System.out.println(" ");
        System.out.println("Seleziona la difficoltà del dungeon");
        System.out.println(" ");
        System.out.println("1. Facile");
        System.out.println("2. Medio");
        System.out.println("3. Difficile");
        System.out.println("Altro per terminare il gioco");
        int quantita = 0;
        switch (input.nextInt()) {
            case 1:
                quantita = 3;
                System.out.println(" ");
                System.out.println("Difficoltà selezionata -> FACILE");
                break;
            case 2:
                quantita = 6;
                System.out.println(" ");
                System.out.println("Difficoltà selezionata -> MEDIO");
                break;
            case 3:
                quantita = 9;
                System.out.println(" ");
                System.out.println("Difficoltà selezionata -> DIFFICILE");
                break;
            default:
                System.out.println(" ");
                System.out.println("Numero non esistente, hai terminato il gioco");
                return;
        };

        generaNemici(quantita);
        int counterScontri=0;
        while(eroe.getHealth()>0 && !nemici.isEmpty()){
            System.out.println(" ");
            BattleManager battle = new BattleManager(nemici.getFirst(),eroe);
            battle.iniziaCombattimento();
            try {
                TimeUnit.SECONDS.sleep(5); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if(eroe.getHealth()>0)
            nemici.removeFirst();
            counterScontri+=1;
            System.out.println("Hai vinto il "+counterScontri+" scontro");
            }

        if(eroe.getHealth()>0) {
            System.out.println(" ");
            System.out.println("HAI VINTO TUTTI GLI SCONTRI");
        }else {
            System.out.println(" ");
            System.out.println("HAI PERSO LA BATTAGLIA");
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(" ");
        System.out.println("Nuova Partita?");
        System.out.println(" ");
        System.out.println("1. Si");
        System.out.println("2. No");
        switch (input.nextInt()){
            case 1:
                System.out.println("Ripartiamo!");
                System.out.println(" ");
                start();
                break;
            case 2:
                System.out.println("Chiusura del gioco...");
                System.out.println(" ");
                break;
            default:
                System.out.println("Chiusura del gioco...");
                System.out.println(" ");
                break;
        }
    }
}