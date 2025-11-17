package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}

	public int getReputation() {
		return this.reputation;
	}
	
	public void direBonjour() {
		super.direBonjour();
		this.parler("Mon clan est celui de " + this.clan + ".");
	}
	
	
	public void extorquer(Commercant victime) {
		super.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		super.parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argentVole = victime.seFaireExtorquer();
		super.gagnerArgent(argentVole);
		this.reputation += 1;
		super.parler("J'ai piqué les " + argentVole + " sous de " + victime.getNom() +
					 ", ce qui me fait " + super.getArgent() + " sous dans ma poche. Hi ! Hi !");
	}
	
	public void perdre() {
		int argentPerdu = super.getArgent();
		super.perdreArgent(argentPerdu);
		super.parler("J'ai perdu mon duel et mes " + argentPerdu +
					 " sous, snif... J'ai déshonoré le clan de " + this.clan + ".");
	}
	
	public void gagner(int argentDepouille) {
		super.gagnerArgent(argentDepouille);
		super.parler("Ce ronin pensait vraiment battre " + super.getNom() + " du clan de " +
					 this.clan + " ? Je l'ai dépouillé de ses " + argentDepouille + " sous.");
	}
}
