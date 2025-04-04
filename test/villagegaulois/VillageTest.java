package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;

class VillageTest {
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
	void testGauloisVendeur() {
		Gaulois gaulois = new Gaulois("John", 5);
		village.installerVendeur(gaulois, "pepites", 5);
		assertEquals(village.rechercherVendeursProduit("pepites")[0].getNom() , "John");
		
		System.out.println("testGauloisVendeur : OK\n");
	}

}
