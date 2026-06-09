package oggetti;

import it.rjcsoft.dungeonbattle.personaggi.Personaggio;

public abstract class Oggetto {
		private String nome;
		private String descrizione;
		
		public Oggetto(String nome, String descrizione) {
			this.nome=nome;
			this.descrizione=descrizione;
		}
		public abstract void usa(Personaggio p);
}