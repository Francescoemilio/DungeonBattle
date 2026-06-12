package it.rjcsoft.dungeonbattle.oggetti;

public class Ascia extends Arma {
    private static final String NOME = "ASCIA";
    private static final String DESCRIZIONE = "Arma gigante ed in grado di affettare un Cinghiale con un singolo colpo.\n Puoi facilmente mancare e salti il turno dopo.";
    private static final int ATTACCO = 30;

    public Ascia()
    {
        super(NOME,DESCRIZIONE,ATTACCO);
    }
}
