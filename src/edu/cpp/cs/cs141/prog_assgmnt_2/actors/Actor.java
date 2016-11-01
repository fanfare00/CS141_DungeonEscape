/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #2
 *
 * A miniature dungeon escape game.
 *
 * @author J. Donald McCarthy
 */

package edu.cpp.cs.cs141.prog_assgmnt_2.actors;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

// TODO: Auto-generated Javadoc
/**
 * This class is the superclass for all game object types who act upon each other through the game's logic.
 * Shared fields and methods for all actor subtypes are contained within this class, including the amount of
 * health an actor has, the actor's current weapon and position, and whether or not the actor is alive.
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
