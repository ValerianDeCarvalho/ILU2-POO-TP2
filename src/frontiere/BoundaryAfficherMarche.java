package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] donnees = controlAfficherMarche.donnerInfosMarche();
		if(donnees.length>0) {
			System.out.println(nomAcheteur + ", vous trouverez au marché: \n");
			for(int i=0; i<donnees.length;i=i+3) {
				System.out.println(donnees[i] + " qui vend " + donnees[i+1] + " " + donnees[i+2] + ".");
			}
		} else {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
	}
}
