package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {

	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlAcheterProduit controlAcheterProduit;
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiser() {
		System.out.println("Initialisation :");
		village = new Village("le village des irreductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		this.controlVerifierIdentite = new ControlVerifierIdentite(village);
		this.controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		this.controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}
	
	@Test
	public void testVerifierIdentite() {
		assertEquals(controlAcheterProduit.acheterVerifierIdentite("John"), false);
		assertEquals(controlAcheterProduit.acheterVerifierIdentite("Abraracourcix"), true);
		System.out.println("testVerifierIdentite : ok");
	}
	
	@Test
	public void testNomVendeurProduit() {
		Gaulois gaulois = new Gaulois("Edmond", 1);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 3);
		assertEquals(controlAcheterProduit.nomVendeurProduit("fleurs")[0].toString(), "Edmond");
		assertNull(controlAcheterProduit.nomVendeurProduit("fleur"));
		System.out.println("testNomVendeurProduit : ok");
	}
	
	@Test
	public void achterEtalVendeur() {
		Gaulois gaulois = new Gaulois("Edmond", 1);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 3);
		assertEquals(controlAcheterProduit.acheterEtalVendeur(("Edmond"), 2)[0], 0);
		assertEquals(controlAcheterProduit.acheterEtalVendeur(("Edmond"), 3)[1], 1);
		assertEquals(controlAcheterProduit.acheterEtalVendeur(("Edmond"), 3)[0], 2);
		
		System.out.println("testVerifierIdentite : ok");
	}
}
