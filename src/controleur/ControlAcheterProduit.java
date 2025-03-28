package controleur;

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
	
	public void acheterEtalVendeur(String vendeur) {
	}
}
