package it.rjcsoft.dungeonbattle.oggetti;

import javax.management.Descriptor;

public class Pugno extends Arma{
    private static final String NOME = "PUGNO";
    private static final String DESCRIZIONE = "I veri uomini vanno a cazzotti";
    private static final int ATTACCO = 0;

    public Pugno()
    {
        super(NOME,DESCRIZIONE,ATTACCO);
    }


}
