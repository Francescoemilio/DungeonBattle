package it.rjcsoft.dungeonbattle.personaggi;

public abstract class Personaggio
{

    private String nome;
    private int health;
    private int attacco_base;
    private int max_health;
    private int armour;
    private boolean isAlive;

    public Personaggio(String nome,int max_health,int attacco_base)
    {
        this.nome = nome;
        this.max_health = max_health;
        this.attacco_base = attacco_base;
        this.armour = 0;
        this.health = this.max_health;
        this.isAlive = true;
    }

    public int getHealth()
    {
        return this.health;
    }
    public int getMax_health()
    {
        return this.max_health;
    }

    public int getArmour()
    {
        return this.armour;
    }
    public void setStatus(boolean status)
    {
        this.isAlive = status;
    }

    public boolean getStatus()
    {
        return this.isAlive;
    }

    public void setArmour(int armour)
    {
        this.armour = armour;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getAttacco_base()
    {
        return this.attacco_base;
    }
    public String getNome()
    {
        return this.nome;
    }



    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        else if(!(obj instanceof Personaggio))
            return false;
        else
        {
            Personaggio personaggio = (Personaggio) obj;

            return this.getNome().equals(personaggio.getNome()) && this.getMax_health() == personaggio.getMax_health() && this.getAttacco_base() == personaggio.getAttacco_base();
        }
    }



    public String toString()
    {
        String s = "{\n";
        s += "\tNome: " + this + "\n";
        s += "\t" + this.getHealth() + "/" + this.getMax_health() + "\n";
        s += "}\n";
        return s;
    }


    public abstract void sprite();




}