package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String[] donnees = controlAcheterProduit.nomVendeurProduit(produit);
		System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
		for (int i=0;i<donnees.length;i++) {
			System.out.println((i+1) + " - " + donnees[i]);
		}
		int x = Clavier.entrerEntier("");
		controlAcheterProduit.acheterEtalVendeur(donnees[x-1]);
	}
}
