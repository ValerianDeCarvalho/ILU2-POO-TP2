package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
    private final Village village;
    private final ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private final ControlVerifierIdentite controlVerifierIdentite;

    public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
                                 ControlTrouverEtalVendeur controlTrouverEtalVendeur,
                                 Village village) {
        this.village = village;
        this.controlVerifierIdentite = controlVerifierIdentite;
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public boolean verifierIdentite(String nomVendeur) {
        return controlVerifierIdentite.verifierIdentite(nomVendeur);
    }

    public String[] nomVendeurProduit(String produit) {
        Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
        if (gaulois == null || gaulois.length == 0) {
            return null;
        }

        String[] vendeurs = new String[gaulois.length];
        for (int i = 0; i < gaulois.length; i++) {
            vendeurs[i] = gaulois[i].getNom();
        }
        return vendeurs;
    }

    public int[] acheterEtalVendeur(String vendeur, int nb) {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
        if (etal == null || etal.getQuantite() == 0) {
            return new int[] {2};
        }

        int quantiteDisponible = etal.getQuantite();

        if (quantiteDisponible >= nb) {
            etal.acheterProduit(nb);
            return new int[] {0};
        } else {
            etal.acheterProduit(quantiteDisponible);
            return new int[] {1, quantiteDisponible};
        }
    }
}