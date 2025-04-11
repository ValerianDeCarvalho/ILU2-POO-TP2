package frontiere;

import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;

public class BoundaryAcheterProduit {
    private final ControlAcheterProduit controlAcheterProduit;

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) {
        if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
            System.out.println("Je suis désolée " + nomAcheteur + ", il faut être un habitant de notre village pour commercer ici.");
            return;
        }

        String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
        String[] vendeurs = controlAcheterProduit.nomVendeurProduit(produit);

        if (vendeurs == null || vendeurs.length == 0) {
            System.out.println("Désolé, personne ne vend ce produit au marché.");
            return;
        }

        System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
        for (int i = 0; i < vendeurs.length; i++) {
            System.out.println((i + 1) + " - " + vendeurs[i]);
        }

        int choixVendeur = Clavier.entrerEntier("Votre choix : ") - 1;
        if (choixVendeur < 0 || choixVendeur >= vendeurs.length) {
            System.out.println("Choix invalide.");
            return;
        }

        int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
        int[] resultat = controlAcheterProduit.acheterEtalVendeur(vendeurs[choixVendeur], quantite);

        switch (resultat[0]) {
            case 0:
                System.out.println(nomAcheteur + " achète " + quantite + " " + produit + " à " + vendeurs[choixVendeur] + ".");
                break;
            case 1:
                System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", mais il n'en reste que " + resultat[1] + ".");
                break;
            case 2:
                System.out.println("Malheureusement, il n'y en a plus !");
                break;
            default:
                System.out.println("Erreur inconnue lors de l'achat.");
                break;
        }
    }
}