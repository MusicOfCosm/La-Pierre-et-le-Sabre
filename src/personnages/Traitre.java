package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;
	private Random random = new Random();

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Mais je suis un traître et mon niveau de traîtrise est : " +
					this.niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (this.niveauTraitrise < 3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconne = argentCommercant * 2 / 10;
			
			commercant.perdreArgent(argentRanconne);
			this.gagnerArgent(argentRanconne);
			niveauTraitrise++;
			
			this.parler("Si tu veux ma protection contre les Yakuza, il va falloir payer ! Donne-moi " +
						argentRanconne + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + this.getNom() + ".");
		} else {
			this.parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (this.nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			Humain ami = this.memoire[this.random.nextInt(this.nbConnaissance)];
			int don = this.getArgent() * 1 / 20;
			
			String nomAmi = ami.getNom();
			
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " +
					nomAmi + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			this.perdreArgent(don);
			
			String nom = this.getNom();
			ami.parler("Merci " + nom + ". Vous êtes quelqu'un de bien.");
			
			if (niveauTraitrise > 0)
				niveauTraitrise--;
		}
	}
}
