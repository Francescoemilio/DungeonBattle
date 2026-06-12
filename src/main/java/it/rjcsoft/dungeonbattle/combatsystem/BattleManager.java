package it.rjcsoft.dungeonbattle.combatsystem;

import it.rjcsoft.dungeonbattle.nemici.*;
import it.rjcsoft.dungeonbattle.personaggi.Nemico;
import it.rjcsoft.dungeonbattle.oggetti.Pozione;
import it.rjcsoft.dungeonbattle.personaggi.Eroe;

import java.util.Scanner;

public class BattleManager {
    private Nemico nemico;
    private Eroe eroe;
    private final int COSTANTE_ATTACCO = 10;
    private boolean mossaSpeciale;
    private final int VITA_FINITA = 0;

    public BattleManager(Nemico nemico, Eroe eroe) {
        this.nemico = nemico;
        this.eroe = eroe;
        mossaSpeciale = true;
    }

    private void stampaLegenda(){
            System.out.println("--- LEGENDA ---");
            System.out.println(" ");
            System.out.println("--- DIFFICOLTA' ---");
            System.out.println("FACILE     = 3 NEMICI");
            System.out.println("MEDIA      = 6 NEMICI");
            System.out.println("DIFFICILE  = 9 NEMICI");
            System.out.println(" ");
            System.out.println("--- INFO OGGETTI ALL'AVVIO ---");
            System.out.println(" 5 POZIONI ( AGGIUNGONO OGNUNA 50 PUNTI VITA ) ");
            turno();

    }

    private int tiraDado() {
        return (int) (Math.random() * 20) + 1;
    }

    public void battleAttack(Eroe eroe, Nemico nemico,boolean specialMove) {
        int risultatoDado;
        if(specialMove)
        {
            risultatoDado = 20;
            this.mossaSpeciale = false;
        }
        else
            risultatoDado = tiraDado();
        System.out.println("\n--- TUO ATTACCO ---");
        System.out.println("Tiro dado: " + risultatoDado);

        if (risultatoDado < 4) {
            System.out.println("Mancato!");
            return;
        }

        int colpo;
        if (risultatoDado == 20) {
            System.out.println("COLPO CRITICO!");
            colpo = eroe.getAttaccoBase() * 3;
        } else {
            colpo = (int) (nemico.getAttaccoBase() * ((double) risultatoDado / COSTANTE_ATTACCO));
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        int nuovoHealth = (nemico.getHealth() - colpo);//no
        nemico.setHealth(nuovoHealth);
        if(nemico.getHealth() < VITA_FINITA)
            nemico.setHealth(VITA_FINITA);
        System.out.println("Salute del nemico: " + nemico.getHealth());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void nemicoAttack() {
        int risultatoDado = tiraDado();
        System.out.println("\n--- ATTACCO NEMICO ---");
        System.out.println("Tiro dado: " + risultatoDado);

        if(this.nemico instanceof Orco){
            if(risultatoDado < 12){
                System.out.println("Mancato!");
                return;
            }

        }

        if(this.nemico instanceof Goblin){
            if(risultatoDado < 5){
                System.out.println("Mancato!");
                return;
            }
        }

        if (risultatoDado < 3) { //scheletro
            System.out.println("Il nemico ha mancato!");
            return;
        }

        int colpo;
        if (risultatoDado == 20) {
            System.out.println("COLPO CRITICO DEL NEMICO!");
            colpo = nemico.getAttaccoBase() * 3;
        } else {
            colpo = (int) (nemico.getAttaccoBase() * ((double) risultatoDado / COSTANTE_ATTACCO));
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        System.out.println("Danno subito: " +  colpo);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        eroe.setHealth(eroe.getHealth()-colpo);
        if(eroe.getHealth() <VITA_FINITA)
            eroe.setHealth(VITA_FINITA);
        System.out.println("Tua salute: " + eroe.getHealth());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void usaOggetto() {
        System.out.println("\n--- USA OGGETTO ---");

        Pozione pozione = eroe.getPozione();
        if(pozione == null)
            System.out.println("Hai finito le pozioni!");
        else
        {
            int differenzaVita = eroe.getMaxHealth()-eroe.getHealth();
            eroe.setHealth(eroe.getHealth() + pozione.getCura());

            if(eroe.getHealth() > eroe.getMaxHealth())
            {
                System.out.println("Ti sei curato di " + differenzaVita+ " punti!");
                eroe.setHealth(eroe.getMaxHealth());
            }
            else
                System.out.println("Ti sei curato di " + pozione.getCura() + " punti!");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Tua salute: " + eroe.getHealth());
            System.out.println("Hai usato una pozione curativa!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }

    private void turno() {
        int difesa = 0;
        int scelta;
        Scanner sc = new Scanner(System.in);

        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n========== STATO COMBATTIMENTO ==========");
        System.out.println("Tua salute: " + eroe.getHealth());
        System.out.println("Salute nemico: " + nemico.getHealth());
        System.out.println("==========================================");

        do {
            System.out.print("\nCosa vuoi fare?\n1: Attacca | 2: Usa mossa speciale | 3: Usa oggetto | 4: Legenda\nScelta: ");
            scelta = sc.nextInt();
            if (scelta < 1 || scelta > 4) {
                System.out.println("Scelta non valida! Riprova.");
            }
        } while (scelta < 1 || scelta > 4);

        switch (scelta) {
            case 1:
                battleAttack(eroe, nemico, false);
                break;
            case 2:
                if(this.mossaSpeciale)
                    battleAttack(eroe, nemico, true);
                else
                    System.out.println("Puoi usare la mossa speciale una sola volta per round");
                break;
            case 3:
                usaOggetto();
                break;
            case 4:
                stampaLegenda();
                break;
        }

        if (nemico.getHealth() > VITA_FINITA) {
            nemicoAttack();
        }
    }

    public void iniziaCombattimento() {
        System.out.println("\n INIZIA IL COMBATTIMENTO! \n");

        nemico.sprite();

        while (nemico.getHealth() > 0 && eroe.getHealth() > 0) {
            turno();

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n========== FINE COMBATTIMENTO ==========");
        if (eroe.getHealth() <= VITA_FINITA) {
            System.out.println(" GAME OVER! Sei stato sconfitto... ");
        } else {
            System.out.println(" VITTORIA! Hai sconfitto il nemico! ");
        }
        System.out.println("=========================================");
    }
}