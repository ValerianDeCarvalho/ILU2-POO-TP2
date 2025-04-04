package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] nomVendeurProduit(String produit) {
		int taille = village.rechercherVendeursProduit(produit).length;
		String[] donnees = new String[taille];
		for(int i=0; i<taille;i++) {
			donnees[i] = village.rechercherVendeursProduit(produit)[i].getNom();
		}
		return donnees;
	}
	
	public int[] acheterEtalVendeur(String vendeur, int nb) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		int quantite = etal.getQuantite();
		if (etal.getQuantite()>nb) {
			etal.acheterProduit(nb);
			return new int[] {0};
		} else if (etal.getQuantite()>1 && etal.getQuantite()<nb) {
			etal.acheterProduit(nb);
			return new int[] {1, quantite - nb};
		} else {
			return new int[] {2};
		}
	}
}
