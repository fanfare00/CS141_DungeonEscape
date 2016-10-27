package edu.cpp.cs.cs141.prog_assgmnt_2.actors;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

public abstract class Actor {
	private boolean alive;
	private int hitPoints;
	private Weapon currentWeapon;
	private int position;
	
	public Actor(int HP, Weapon weapon) {
		hitPoints = HP;
		currentWeapon = weapon;
		alive = true;
		position = 0;
	}
	
	public Actor(Weapon weapon) {
		currentWeapon = weapon;
	}
	
	public Weapon getWeapon() {
		return currentWeapon;
	}
	
	public int getHealth() {
		return hitPoints;
	}
	
	public void reduceHitPoints(int damage) {
		if ((hitPoints - damage) <= 0) {
			alive = false;
		} else {
			hitPoints -= damage;
		}
	}
	
	public boolean isAlive() {
		return alive;
	}
	
}
