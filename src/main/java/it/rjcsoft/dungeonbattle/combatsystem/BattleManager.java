package it.rjcsoft.dungeonbattle.combatsystem;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;
import it.rjcsoft.dungeonbattle.oggetti.Pozione;
import it.rjcsoft.dungeonbattle.personaggi.Eroe;

import java.util.Scanner;

public class BattleManager {
    private Nemico nemico;
    private Eroe eroe;
    final int COSTANTE_ATTACCO = 10;
    final float COSTANTE_DIFESA=0.7f;

    public BattleManager(Nemico nemico, Eroe eroe) {
        this.nemico = nemico;
        this.eroe = eroe;
    }

    private int tiraDado() {
        return (int) (Math.random() * 20) + 1;
    }

    private void battleAttack(Eroe eroe, Nemico nemico) {
        int risultatoDado = tiraDado();
        System.out.println("\n--- TUO ATTACCO ---");
        System.out.println("Tiro dado: " + risultatoDado);

        if (risultatoDado < 4) {
            System.out.println("Mancato!");
            return;
        }

        int colpo;
        if (risultatoDado == 20) {
            System.out.println("COLPO CRITICO!");
            colpo = eroe.getAttacco_base() * 3;
        } else {
            colpo = eroe.getAttacco_base() * (risultatoDado / COSTANTE_ATTACCO);
        }

        
        int nuovoHealth = (nemico.getHealth() - colpo);//no
        nemico.setHealth(nuovoHealth);
        System.out.println("Salute del nemico: " + nemico.getHealth());
    }

    private void nemicoAttack(int difesa) {
        int risultatoDado = tiraDado();
        System.out.println("\n--- ATTACCO NEMICO ---");
        System.out.println("Tiro dado: " + risultatoDado);

        if (risultatoDado < 4) {
            System.out.println("Il nemico ha mancato!");
            return;
        }

        int colpo;//stessa ccon patate
        if (risultatoDado == 20) {
            System.out.println("COLPO CRITICO DEL NEMICO!");
            colpo = nemico.getAttacco_base() * 2;
        } else {
            colpo = nemico.getAttacco_base() * (risultatoDado / COSTANTE_ATTACCO);
        }

        // Applica la difesa belli i commenti di chat
        colpo -= difesa;
        if (colpo < 0) {
            colpo = 0;
            System.out.println("Hai parato completamente l'attacco!");
        }

        System.out.println("Danno subito: " +  colpo);
        int nuovoHealth = eroe.getHealth() - colpo;
        eroe.setHealth(nuovoHealth);
        System.out.println("Tua salute: " + eroe.getHealth());
    }

    private void usaOggetto() {
        System.out.println("\n--- USA OGGETTO ---");
        System.out.println("Hai usato una pozione curativa!");
        Pozione pozione = eroe.getPozione();
        int nuovaSalute = eroe.getHealth() + pozione.getCura();
        if(nuovaSalute<200){
            eroe.setHealth(nuovaSalute);
        } 
        else{
            eroe.setHealth(200);
        }   
        
        System.out.println("Ti sei curato di " + pozione.getCura() + " punti!");
        System.out.println("Tua salute: " + eroe.getHealth());
    }

    private void turno() {
        int difesa = 0;
        int scelta = -1;
        Scanner sc = new Scanner(System.in);

        // Mostra stato attuale GEMINI O CHAT?
        System.out.println("\n========== STATO COMBATTIMENTO ==========");
        System.out.println("Tua salute: " + eroe.getHealth());
        System.out.println("Salute nemico: " + nemico.getHealth());
        System.out.println("==========================================");

        // Scegli azione
        do {
            System.out.print("\nCosa vuoi fare?\n1: Attacca | 2: Difendi | 3: Usa oggetto\nScelta: ");
            scelta = sc.nextInt();
            if (scelta < 1 || scelta > 3) {
                System.out.println("Scelta non valida! Riprova.");
            }
        } while (scelta < 1 || scelta > 3);

        // Esegui azione
        switch (scelta) {
            case 1:
                battleAttack(eroe, nemico);
                break;
            case 2:
                difesa = (int)(COSTANTE_DIFESA * tiraDado());//Corretto
                System.out.println("\n--- DIFESA ---");
                System.out.println("Punti difesa: " + difesa);
                break;
            case 3:
                usaOggetto();
                break;
        }

        // Turno del nemico (solo se è ancora vivo)
        if (nemico.getHealth() > 0) {
            nemicoAttack(difesa);
        }
    }

    public void iniziaCombattimento() {
        System.out.println("\n INIZIA IL COMBATTIMENTO! \n");

        while (nemico.getHealth() > 0 && eroe.getHealth() > 0) {
            turno();

            // Pausa per leggibilità
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Risultato finale
        System.out.println("\n========== FINE COMBATTIMENTO ==========");
        if (eroe.getHealth() <= 0) {
            System.out.println(" GAME OVER! Sei stato sconfitto... ");
        } else {
            System.out.println(" VITTORIA! Hai sconfitto il nemico! ");
        }
        System.out.println("=========================================");
    }
}