package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
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
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
		System.out.println("testControlLibererEtal : OK \n");
	}
	
	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals());
		for (int i=0;i<10;i++) {
			Gaulois gaulois = new Gaulois("Gaulois"+i,5);
			village.ajouterHabitant(gaulois);
			village.installerVendeur(gaulois, "drogue", 10);
		}
		assertEquals(village.donnerNbEtal(), 5);
		assertFalse(controlPrendreEtal.resteEtals());
		System.out.println("testControlLibererEtal : OK \n");
	}
	
}
