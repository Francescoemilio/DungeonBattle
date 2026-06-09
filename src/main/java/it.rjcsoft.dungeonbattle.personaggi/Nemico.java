package it.rjcsoft.dungeonbattle.personaggi;

public abstract class Nemico extends Personaggio
{
    private int stamina;
    private int stamina_gain;
    public Nemico(String nome,int max_health,int attacco_base)
    {
        super(nome,max_health,attacco_base);
        this.stamina = 0;
    }

    public abstract special_ability();

    public void gainStamina()
    {
        this.stamina += this.stamina_gain;
    }

}