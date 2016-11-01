package edu.cpp.cs.cs141.prog_assgmnt_2.actors;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Actor.
 */
public abstract class Actor {
	
	/** The alive. */
	private boolean alive;
	
	/** The max hit points. */
	private int maxHitPoints;
	
	/** The hit points. */
	private int hitPoints;
	
	/** The current weapon. */
	private Weapon currentWeapon;
	
	/** The position. */
	private int position;
	
	/**
	 * Instantiates a new actor.
	 *
	 * @param HP the hp
	 * @param weapon the weapon
	 */
	public Actor(int HP, Weapon weapon) {
		maxHitPoints = HP;
		hitPoints = HP;
		currentWeapon = weapon;
		alive = true;
		position = 0;
	}
	
	/**
	 * Instantiates a new actor.
	 *
	 * @param weapon the weapon
	 */
	public Actor(Weapon weapon) {
		currentWeapon = weapon;
	}
	
	/**
	 * Gets the weapon.
	 *
	 * @return the weapon
	 */
	public Weapon getWeapon() {
		return currentWeapon;
	}
	
	/**
	 * Gets the health.
	 *
	 * @return the health
	 */
	public int getHealth() {
		return hitPoints;
	}
	
	/**
	 * Restore hit points.
	 *
	 * @param value the value
	 */
	public void restoreHitPoints(int value) {
		if ((hitPoints + value) < maxHitPoints) {
			hitPoints+=value;
		} else {
			hitPoints = maxHitPoints;
		}
	}
	
	/**
	 * Reduce hit points.
	 *
	 * @param damage the damage
	 */
	public void reduceHitPoints(int damage) {
		if ((hitPoints - damage) <= 0) {
			alive = false;
		} else {
			hitPoints -= damage;
		}
	}
	
	/**
	 * Checks if is alive.
	 *
	 * @return true, if is alive
	 */
	public boolean isAlive() {
		return alive;
	}
	
}
