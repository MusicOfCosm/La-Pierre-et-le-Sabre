package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	protected Humain[] memoire = new Humain[5];
	private Random random = new Random();
	
	private enum TypeHumain {
		Humain("un habitant"),
		Commercant("un commerçant"),
		Yakuza("un yakuza"),
		Ronin("un ronin"),
		Samourai("un samouraï"),
		GrandMere("une grand-mère");
		
		private String nom;

		TypeHumain(String nom) {
			this.nom = nom;
		}
		
		public String toString() {
			return this.nom;
		}
	}
	private TypeHumain[] types = TypeHumain.values();

	
	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	@Override
	protected void memoriser(Humain autreHumain) {
		if (this.nbConnaissance < 5) {
			this.memoire[this.nbConnaissance++] = autreHumain;
		} else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
	}

	private String humainHasard() {
		return types[this.random.nextInt(5)].toString();
	}
	
	public void ragoter() {
		 for (Humain humain : memoire) {
			 if (humain instanceof Traitre) {
				 parler("Je sais que " + humain.getNom() + " est un traître. Petit chenapan !");
			 } else {
				 parler("Je crois que " + humain.getNom() + " est " + humainHasard() + ".");
			 }
		}
	}
}
