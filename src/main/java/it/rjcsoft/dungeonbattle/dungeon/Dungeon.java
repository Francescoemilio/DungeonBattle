package it.rjcsoft.dungeonbattle.dungeon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;
import it.rjcsoft.dungeonbattle.nemici.Orco;


public class Dungeon {
    private ArrayList<Nemico> nemici;
    private Nemico[] listaNemici;
    private final Scanner input = new Scanner(System.in);
    //private BattleManager battle;

    public Dungeon() {
        nemici = new ArrayList<>();
        listaNemici = new Nemico[9];
        listaNemici[0] = new Orco();
        listaNemici[1] = new Goblin();
        listaNemici[2] = new Scheletro();
        listaNemici[3] = new Orco();
        listaNemici[4] = new Goblin();
        listaNemici[5] = new Scheletro();
        listaNemici[6] = new Orco();
        listaNemici[7] = new Goblin();
        listaNemici[8] = new Scheletro();
        this.battle = new BattleManager();
    }


    public void generaNemici(int quantita) {
        for(int i = 0; i < quantita; i++) {
            nemici.add(listaNemici[i]);

        }
    }

    public void start() {
        System.out.println("Sei entrato nel dungeon");
        System.out.println(" ");
        System.out.println("Seleziona la difficoltà del dungeon");
        System.out.println(" ");
        System.out.println("1. Facile");
        System.out.println("2. Medio");
        System.out.println("3. Difficile");
        System.out.println("Altro per terminare il gioco");

        int difficolta = input.nextInt();
        int quantita;
        switch (difficolta) {
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


        while(eroe.getVita()>0 || nemici[quantita-1]!=null){
            System.out.println(" ");
            for(int i=0; i<quantita; i++) {
            battle.inizioBattaglia(Eroe eroe, Nemico nemici[i]);
            try {
                TimeUnit.SECONDS.sleep(5); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if(eroe.getVita>0) 
            nemici.remove(i);
            System.out.println("Hai vinto il "+i+" scontro")
            }
        }
        if(eroe.getVita>0) {
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
        int newP = input.nextInt();
        switch (newP){
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