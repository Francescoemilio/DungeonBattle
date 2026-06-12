package it.rjcsoft.dungeonbattle.dungeon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import it.rjcsoft.dungeonbattle.combatsystem.BattleManager;
import it.rjcsoft.dungeonbattle.oggetti.Arma;
import it.rjcsoft.dungeonbattle.personaggi.*;
import it.rjcsoft.dungeonbattle.nemici.Boss;
import it.rjcsoft.dungeonbattle.nemici.Drago;
import it.rjcsoft.dungeonbattle.nemici.Goblin;
import it.rjcsoft.dungeonbattle.nemici.MindFlayer;
import it.rjcsoft.dungeonbattle.nemici.Orco;
import it.rjcsoft.dungeonbattle.nemici.Scheletro;


public class Dungeon {
    private ArrayList<Nemico> nemici;
    private ArrayList<Nemico> listaNemici;
    private final Scanner input = new Scanner(System.in);
    private Eroe eroe;
    private final int NPOZIONI_INIZIALI = 4;
    private final int NEMICI_FACILE = 3;
    private final int NEMICI_NORMALE = 6;
    private final int NEMICI_DIFFICILE = 9;


    public Dungeon() {
        nemici = new ArrayList<>();
        listaNemici = new ArrayList<>();
        //è UNA COSTANTE?
    }


    private void stampaLegenda(){
        System.out.println("--- LEGENDA ---");
        System.out.println(" ");
        System.out.println("--- DIFFICOLTA' ---");
        System.out.println("FACILE     = " + NEMICI_FACILE  +   " NEMICI");
        System.out.println("MEDIA      = " + NEMICI_NORMALE + " NEMICI");
        System.out.println("DIFFICILE  = " + NEMICI_DIFFICILE + " NEMICI");
        System.out.println(" ");
        System.out.println("--- INFO OGGETTI ALL'AVVIO ---");
        System.out.println(" " + NPOZIONI_INIZIALI + " POZIONI ( AGGIUNGONO OGNUNA 50 PUNTI VITA ) ");


    }

    public void generaNemici(int quantita) {

        for(int i = 0; i < quantita; i++) {
            int random = (int) (Math.random()*3);
            if(random==0) {
                listaNemici.add(new Orco());
            }
            if(random==1) {
                listaNemici.add(new Goblin());
            }else{
                listaNemici.add(new Scheletro());
            }
            

        }

        int random=(int)(Math.random());
        Boss b;
        if(random == 0){
            b=new Drago();
        }
        else{
            b=new MindFlayer();    
        }
            listaNemici.add(b);
    }

    public void start()throws IOException{
        if (this.eroe == null) {
            this.eroe = new Eroe("Francesco Barsotti",  NPOZIONI_INIZIALI);
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
                quantita = NEMICI_FACILE;
                System.out.println(" ");
                System.out.println("Difficoltà selezionata -> FACILE");
                break;
            case 2:
                quantita = NEMICI_NORMALE;
                System.out.println(" ");
                System.out.println("Difficoltà selezionata -> MEDIO");
                break;
            case 3:
                quantita = NEMICI_DIFFICILE;
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
        while(eroe.getHealth()>0 && nemici.getFirst() instanceof Boss){
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