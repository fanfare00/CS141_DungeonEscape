package edu.cpp.cs.cs141.prog_assgmnt_2.actors;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

public class Actor {
	private int hitPoints;
	private Weapon currentWeapon;
	
	public Actor(int HP, Weapon weapon) {
		hitPoints = HP;
		currentWeapon = weapon;
	}
	
	public Actor(Weapon weapon) {
		currentWeapon = weapon;
	}
	
	
	
}
