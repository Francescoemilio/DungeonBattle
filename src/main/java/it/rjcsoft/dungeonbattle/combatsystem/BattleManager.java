package it.rjcsoft.dungeonbattle.combatsystem;

import it.rjcsoft.dungeonbattle.nemici.*;
import it.rjcsoft.dungeonbattle.oggetti.*;
import it.rjcsoft.dungeonbattle.personaggi.Nemico;
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



    private int tiraDado() {
        return (int) (Math.random() * 20) + 1;
    }

    private void forziere(){
        int risultatoDado = tiraDado();

        if(risultatoDado > 14){
            System.out.println("Hai trovato un forziere!");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            int dadoArmaNuova = tiraDado();
            if(dadoArmaNuova > 5 && dadoArmaNuova < 16){

                    System.out.println("Hai trovato una pozione!");
                    Pozione pozione= new Pozione();
                    eroe.aggiungiInventario(pozione);
                }else if(dadoArmaNuova>16){
                    System.out.println("Hai trovato un'arma...");
                    int dadoArma= tiraDado();
                    if(dadoArma<10){
                        System.out.println("Hai trovato una daga!");
                        Daga daga= new Daga();
                        eroe.aggiungiInventario(daga);
                    }else if(dadoArma<=15){
                        System.out.println("Hai trovato una spada!");
                        Spada spada = new Spada();
                        eroe.aggiungiInventario(spada);
                    }else{
                        System.out.println("Hai trovato un'ascia!");
                        Ascia ascia = new Ascia();
                        eroe.aggiungiInventario(ascia);
                    }

            }else{
                System.out.println("E' vuota...");
            }
        }
    }

    private void battleAttack(Eroe eroe, Nemico nemico,boolean specialMove) {
        int risultatoDado;
        int colpo=0;
        if(specialMove)
        {
            risultatoDado = 20;
            this.mossaSpeciale = false;
        }
        else
            risultatoDado = tiraDado();
        System.out.println("\n--- TUO ATTACCO ---");
        System.out.println("Tiro dado: " + risultatoDado);
        if(eroe.getArma() instanceof Spada || eroe.getArma() instanceof Pugno){
            if (risultatoDado < 4) {
                System.out.println("Mancato!");
                return;
            }
            if (risultatoDado == 20) {
                System.out.println("COLPO CRITICO!");
                colpo = eroe.getAttaccoBase() * 3;
            } else {
                colpo = (int) (nemico.getAttaccoBase() * ((double) risultatoDado / COSTANTE_ATTACCO));
            }
        }else if(eroe.getArma() instanceof Ascia){
            if (risultatoDado < 12) {
                System.out.println("Mancato!");
                return;
            }
            if (risultatoDado == 20) {
                System.out.println("COLPO CRITICO!");
                colpo = eroe.getAttaccoBase() * 2;
            } else {
                colpo = (int) (nemico.getAttaccoBase() * ((double) risultatoDado / COSTANTE_ATTACCO));
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Hai inflitto" + colpo + "danni.");

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

        if (risultatoDado < 3) {
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

    private void usaOggetto(Oggetto oggetto) {
        if(oggetto == null)
        {
            System.out.println("Oggetto  non presente nell'inventario");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        else if(oggetto instanceof Arma)
        {
            this.eroe.setArma((Arma)oggetto);
            System.out.println("Equipaggiata la nuova arma! E sostituita quella attuale");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        else
        {

            Pozione pozione = (Pozione) oggetto;


            int differenzaVita = eroe.getMaxHealth()-eroe.getHealth();
            eroe.setHealth(eroe.getHealth() + Pozione.getCura());

            if(eroe.getHealth() > eroe.getMaxHealth())
            {
                System.out.println("Ti sei curato di " + differenzaVita+ " punti!");
                eroe.setHealth(eroe.getMaxHealth());
            }
            else
                System.out.println("Ti sei curato di " + Pozione.getCura() + " punti!");
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

            System.out.println("\nCosa vuoi fare?\n1: Attacca | 2: Usa mossa speciale | 3: Usa oggetto");
            scelta = sc.nextInt();
            if (scelta < 1 || scelta > 4) {
                System.out.println("Scelta non valida! Riprova.");
            }


            switch (scelta) {
                case 1:
                    if(eroe.getArma() instanceof Spada || eroe.getArma() instanceof Pugno){
                        battleAttack(eroe, nemico, false);
                    }else if(eroe.getArma() instanceof Ascia){
                        battleAttack(eroe, nemico, false);
                        if (nemico.getHealth() > VITA_FINITA) {
                            nemicoAttack();
                        }
                    }else{
                        battleAttack(eroe, nemico, false);
                        battleAttack(eroe, nemico, false);
                    }
                    break;
                case 2:
                    if (this.mossaSpeciale){
                        if(eroe.getArma() instanceof Spada || eroe.getArma() instanceof Pugno || eroe.getArma() instanceof Daga ){
                            battleAttack(eroe, nemico, true);
                        }else{
                            battleAttack(eroe, nemico, true);
                            if (nemico.getHealth() > VITA_FINITA) {
                                nemicoAttack();
                            }
                        }
                    }
                    else
                        System.out.println("Puoi usare la mossa speciale una sola volta per round");
                    break;
                case 3:
                    visualizzaInventario();
                    break;

            }

            if (nemico.getHealth() > VITA_FINITA) {
                nemicoAttack();
            }
        }
        while(scelta != 1 && scelta != 2 && scelta != 3);
    }

    public void visualizzaInventario()
    {
        Scanner scanner = new Scanner(System.in);
        this.eroe.stampaInventario();
        System.out.println("Inserire l'oggetto da utilizzare");
        String oggettoUtilizzato = scanner.nextLine();
        oggettoUtilizzato = oggettoUtilizzato.toUpperCase();
        Oggetto oggettoDaUtilizzare = null;
        for(Oggetto o : eroe.getInventario())
        {
            if(o.getNome().equals(oggettoUtilizzato))
            {
                oggettoDaUtilizzare = o;
                eroe.getInventario().remove(o);
                break;
            }
        }
        usaOggetto(oggettoDaUtilizzare);
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
            this.forziere();
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