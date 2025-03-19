package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	public String[] donnerInfosMarche() {
		String [] etatMarche = village.donnerEtatMarche();
		
		return etatMarche;
	}
}
