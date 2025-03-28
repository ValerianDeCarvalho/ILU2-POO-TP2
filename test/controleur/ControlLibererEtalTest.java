package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.Village;

class ControlLibererEtalTest {
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
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
		System.out.println("testControlLibererEtal : OK \n");
	}
	
	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTouverEtalVendeur);
		Gaulois gaulois = new Gaulois("John", 5);
		assertFalse(controlLibererEtal.isVendeur("John"));
		village.ajouterHabitant(gaulois);
		assertFalse(controlLibererEtal.isVendeur("John"));
		village.installerVendeur(gaulois, "Drogue dur", 10);
		assertTrue(controlLibererEtal.isVendeur("John"));
		assertEquals(village.getNom(),"le village des irréductibles");
		String[] test = controlLibererEtal.libererEtal("John");
		assertEquals(test[3], "10");
		assertEquals(test[4], "0");
		System.out.println("testIsVendeur : OK \n");
	}

}
