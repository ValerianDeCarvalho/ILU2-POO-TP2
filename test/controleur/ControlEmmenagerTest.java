package controleur;
import villagegaulois.*;
import personnages.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlEmmenagerTest {
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
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
		System.out.println("testControlEmmenager : OK \n");
	}
	
	@Test
	void testHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Edwardos"));
		controlEmmenager.ajouterDruide("Popo", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Popo"));
		for(int i=0;i<15;i++) {
			controlEmmenager.ajouterGaulois("Gaulois" + i, 5);
		}
		assertTrue(controlEmmenager.isHabitant("Gaulois7"));
		assertFalse(controlEmmenager.isHabitant("Gaulois8"));
		System.out.println("testHabitant : OK \n");
	}
	

}
