package it.rjcsoft.dungeonbattle.personaggi;

public abstract class Nemico extends Personaggio
{
    private int stamina;
    private int stamina_gain;
    public Nemico(String nome,int max_health,int attacco_base, int stamina_gain)
    {
        super(nome,max_health,attacco_base);
        this.stamina = 0;
        this.stamina_gain = stamina_gain;
    }

    public int getStamina()
    {
       return this.stamina;
    }

    public abstract void special_ability();

    public void setStamina(int stamina)
    {
        this.stamina = stamina;
    }

}