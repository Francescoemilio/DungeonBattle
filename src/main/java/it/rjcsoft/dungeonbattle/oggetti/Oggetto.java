package it.rjcsoft.dungeonbattle.oggetti;

public abstract class Oggetto {
		private int attacco;
		private int cura;
		
		public Oggetto(int attacco, int cura) {
			this.attacco=attacco;
			this.cura=cura;
		}
		
		
		
		public abstract void usa();
	}