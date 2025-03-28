package controleur;
import villagegaulois.*;
import personnages.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois john;

	@BeforeEach
	public void initialiser() {
		System.out.println("Initialisation :");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		john = new Gaulois("John", 5);
		village.ajouterHabitant(john);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
		System.out.println("testControlTrouverEtalVendeur : OK \n");
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("John"));
		village.installerVendeur(john, "Drogue", 10);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("John"));
		System.out.println("testTrouverEtalVendeur : OK \n");
	}
	
}
