package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	
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
	
	protected void Parler(String texte) {
		System.out.println("(" + this.nom + ") - " + texte);
	}
	
	protected void gagnerArgent(int gain) {
		this.argent += gain;
	}
	
	protected void perdreArgent(int perte) {
		this.argent -= perte;
	}
	
	public void direBonjour() {
		Parler("Bonjour ! Je m'apelle " + this.nom +
				" et j'aime boire du " + this.boissonFavorite + ".");
	}
	
	public void boire() {
		Parler("Mmmm, un bon verre de " + this.boissonFavorite +
				" ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (prix <= this.argent) {
			Parler("J'ai " + this.argent + " sous en poche. " + "Je vais pouvoir m'offrir " +
					bien + " à " + prix + " sous.");
			perdreArgent(prix);
		} else {
			Parler("Je n'ai plus que " + this.argent + " sous en poche. Je ne peux même pas m'offir " +
					bien + " à " + prix + " sous.");
		}
	}
}
