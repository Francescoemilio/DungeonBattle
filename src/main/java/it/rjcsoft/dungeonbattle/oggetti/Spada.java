package it.rjcsoft.dungeonbattle.oggetti;

public class Spada extends Arma{
    private static final String NOME = "SPADA";
    private static final String DESCRIZIONE = "Una lama leggendaria che conferisce un enorme forza ma con un prezzo sull'agilita'";
    private static final int ATTACCO = 10;

    public Spada()
    {
        super(NOME,DESCRIZIONE,ATTACCO);
    }
}
