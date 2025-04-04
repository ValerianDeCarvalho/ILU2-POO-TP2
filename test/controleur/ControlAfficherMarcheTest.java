package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiser() {
		System.out.println("Initialisation :");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	public void testAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		Gaulois gaulois = new Gaulois("John", 5);
		village.installerVendeur(gaulois, "fleurs", 10);
		String[] infos = controlAfficherMarche.donnerInfosMarche();
		int count = 0;
		for (String info : infos) {
	        if (info.contains("John")) {
	            count++;
	        }
	    }
		assertEquals(count, 1);
		System.out.println("testAfficherMarche : OK \n");
	}

}
