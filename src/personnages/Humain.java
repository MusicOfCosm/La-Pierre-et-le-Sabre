package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected Humain[] memoire = new Humain[30];
	protected int nbConnaissance = 0;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getArgent() {
		return this.argent;
	}
	
	
	protected void parler(String texte) {
		System.out.println("(" + this.nom + ") - " + texte);
	}
	
	protected void gagnerArgent(int gain) {
		this.argent += gain;
	}
	
	protected void perdreArgent(int perte) {
		this.argent -= perte;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'apelle " + this.nom +
				" et j'aime boire du " + this.boissonFavorite + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + this.boissonFavorite +
				" ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (prix <= this.argent) {
			parler("J'ai " + this.argent + " sous en poche. " + "Je vais pouvoir m'offrir " +
					bien + " à " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + this.argent + " sous en poche. Je ne peux même pas m'offir " +
					bien + " à " + prix + " sous.");
		}
	}
	
	
	private void memoriser(Humain autreHumain) {
		if (this.nbConnaissance < this.memoire.length) {
			this.memoire[this.nbConnaissance++] = autreHumain;
		} else {
			for (int i = 1; i < this.nbConnaissance; ++i) {
				this.memoire[i-1] = this.memoire[i];
			}
			this.memoire[this.nbConnaissance-1] = autreHumain;
		}
	}
	
	private void repondre(Humain autreHumain) {
		autreHumain.direBonjour();
		autreHumain.memoriser(this);
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		this.direBonjour();
		this.repondre(autreHumain);
		this.memoriser(autreHumain);
	}
	
	public void listerConnaissance() {
		String texte = "Je connais beaucoup de monde dont : ";
		for (int i = 0; i < this.nbConnaissance; ++i) {
			if (i != 0) texte += ", ";
			texte += memoire[i].getNom();
		}
		this.parler(texte);
	}
}
