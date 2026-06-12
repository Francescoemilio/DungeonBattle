package it.rjcsoft.dungeonbattle.oggetti;



public abstract class Oggetto {
	private String nome;
	private String descrizione;

	public Oggetto(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Oggetto{" +
				"nome='" + nome + '\'' +
				", descrizione='" + descrizione + '\'' +
				'}';
	}

	public String getNome() {
		return nome;
	}

	public boolean equals(Object o)
	{
		if(o == null)
			return false;
		else if(!(o instanceof Oggetto))
			return false;
		else
		{
			Oggetto oggetto = (Oggetto) o;
			return this.nome.equals(oggetto.getNome());
		}
	}
}