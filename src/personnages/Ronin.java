package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}

	public void donner(Commercant beneficiaire) {
		int argentDonne = super.getArgent() / 10;
		super.parler(beneficiaire.getNom() + ", prend ces 6 sous.");
		super.perdreArgent(argentDonne);
		beneficiaire.recevoir(argentDonne);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = honneur * 2;
		super.parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		if (force >= adversaire.getReputation()) {
			super.gagnerArgent(adversaire.getArgent());
			this.honneur += 1;
			super.parler("Je t'ai eu petit yakuza !");
			adversaire.perdre();
		} else {
			int argentPerdu = this.getArgent();
			this.perdreArgent(argentPerdu);
			this.honneur -= 1;
			super.parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			adversaire.gagner(argentPerdu);
		}
	}
}
