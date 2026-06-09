public abstract class Nemico extends Personaggio
{
    private int stamina;
    public Nemico(String nome,int max_health,int attacco_base)
    {
        super(nome,max_health,attacco_base);
        this.stamina = 0;
    }

    public abstract special_ability();

}