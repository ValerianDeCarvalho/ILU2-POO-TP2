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
		
		System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
		for (int i=0;i<donnees.length;i++) {
			System.out.println((i+1) + " - " + donnees[i]);
		}
		int x = Clavier.entrerEntier("");
		System.out.println("Combien de" + produit + " voulez-vous acheter ?");
		int nb = Clavier.entrerEntier("");
		int[] resultat = controlAcheterProduit.acheterEtalVendeur(donnees[x-1], nb);
		switch (resultat[0]) {
			case 0: {
				System.out.println(nomAcheteur + " achète " + " " + nb + " " + produit + " à " + donnees[x-1]);
			}
			case 1: {
				System.out.println(nomAcheteur + " veut acheter " + nb + " " + produit + " , malheureusement il n'en reste plus que " + resultat[1]);
			}
			case 2: {
				System.out.println("Malheureusement il n’y en a plus !");
			}
		}
	}
}
