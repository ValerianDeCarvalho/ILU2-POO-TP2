package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
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
	void testControlAfficherVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] villageois = controlAfficherVillage.donnerNomsVillageois();
		assertEquals(villageois[0], "Abraracourcix");
		Gaulois gaulois = new Gaulois("John", 5);
		village.ajouterHabitant(gaulois);
		villageois = controlAfficherVillage.donnerNomsVillageois();
		assertEquals(villageois[1], "John");
		System.out.println("testControlAfficherVillageois : OK \n");
	}
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");
		System.out.println("testControlAfficherVillage : OK \n");
	}
	
	@Test
	void testControlDonnerEtal() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
		village.installerVendeur(abraracourcix, "fleurs", 4);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
		System.out.println("testControlDonnerEtal : OK \n");
	}
}
