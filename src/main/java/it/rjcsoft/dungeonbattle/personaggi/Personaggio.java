package it.rjcsoft.dungeonbattle.personaggi;

public abstract class Personaggio {

    private String nome;
    private int health;
    private int attaccoBase;
    private int maxHealth;
    private boolean isAlive;

    public Personaggio(String nome, int maxHealth, int attaccoBase) {
        this.nome = nome;
        this.maxHealth = maxHealth;
        this.attaccoBase = attaccoBase;
        this.health = this.maxHealth;
        this.isAlive = true;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void setStatus(boolean status) {
        this.isAlive = status;
    }

    public boolean getStatus() {
        return this.isAlive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttaccoBase() {
        return this.attaccoBase;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (!(obj instanceof Personaggio))
            return false;
        else {
            Personaggio personaggio = (Personaggio) obj;

            return this.getNome().equals(personaggio.getNome()) && this.getMaxHealth() == personaggio.getMaxHealth()
                    && this.getAttaccoBase() == personaggio.getAttaccoBase();
        }
    }

    @Override
    public String toString() {
        return "Personaggio [nome=" + nome + ", health=" + health + ", attacco_base=" + attaccoBase + ", max_health="
                + maxHealth + ", isAlive=" + isAlive + "]";
    }

    public abstract void sprite();

}