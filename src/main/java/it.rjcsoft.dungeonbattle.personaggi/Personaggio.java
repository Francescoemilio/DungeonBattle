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
        return this.armour
    }
    public boolean getStatus()
    {
        return this.isAlive;
    }

    public int getAttacco_base()
    {
        return this.attacco_base;
    }
    public String getNome()
    {
        return this.nome;
    }

    public boolean isDead()
    {
        if(this.getHealth() <= 0)
        {
            this.isAlive = false;
            return true;
        }
        else
            return false;
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

            return this.getNome().equals(personaggio.getNome) && this.getMax_health() == personaggio.getMax_health() && this.getAttacco_base() == personaggio.getAttacco_base();
        }
    }

    public void takeDamage(int damage)
    {
        this.health -= damage;
        if(isDead())
            health = 0;

    }

    public void heal()
    {
        this.health += healing;
        if(this.health > this.max_health)
           this.health = this.max_health;
    }


    public String toString()
    {
        System.out.println("{\n");
        System.out.println("\tNome: " + thisg + "\n");
        System.out.println("\t" + this.getHealth() + "/" + this.getMax_health() + "\n");
        System.out.println("}\n");
    }

    public abstract int attack();
    public abstract void sprite();




}