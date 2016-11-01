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
package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

/**
 * This class represents the base Weapon class for which all special weapon types are subclasses of. 
 * Base Weapon fields include the shared qualities of all special weapon types: damage, accuracy, ammo count, 
 * the name of the weapon, and whether or not it is loaded.
 */
public abstract class Weapon {
	
	/** The {@link Weapon}'s probability of successfully reducing hitpoints. */
	private double accuracy;
	
	/** The amount of hitpoints to be reduced by the {@link Weapon}. */
	private int damage;
	
	/** The maximum amount of continuous uses of the {@link Weapon} before needing to calling {@link #reload()}. */
	private int maxAmmo;
	
	/** The current amount of uses of the {@link Weapon} remaining before needing to call {@link #reload()} . */
	private int currentAmmo;
	
	/** The name of the {@link Weapon} in String form */
	private String name;
	
	/** boolean value representing whether or not the {@link Weapon} has any more uses remaining */
	private boolean isLoaded;
	
	/**
	 * Instantiates a new weapon.
	 *
	 * @param name the name of the weapon
	 * @param accuracy the accuracy of the weapon
	 * @param damage the damage of the weapon
	 * @param maxAmmo the max ammo of the weapon
	 */
	public Weapon(String name, double accuracy, int damage, int maxAmmo) {
		this.accuracy = accuracy;
		this.damage = damage;
		this.maxAmmo = maxAmmo;
		this.currentAmmo = maxAmmo;
		this.name = name;
	}
	
	/**
	 * Instantiates a new weapon.
	 */
	public Weapon() {}
	
	/**
	 * Reduces the value stored in {@link currentAmmo}
	 */
	public void reduceAmmo() {
		if ((currentAmmo - 1) <= 0) {
			isLoaded = false;
		} else {
			currentAmmo -= 1;
		}
	}
	
	/**
	 * Resets the value stored in {@link currentAmmo} to the maximum value represented by {@link maxAmmo} 
	 */
	public void reload() {
		currentAmmo = maxAmmo;
	}
	
	/**
	 * Gets the name of the {@link Weapon in String form.
	 *
	 * @return the name of the weapon
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the accuracy of the {@link Weapon} .
	 *
	 * @return the accuracy
	 */
	public double getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Gets the damage value of {@link Weapon}.
	 *
	 * @return the damage value
	 */
	public int getDamage() { 
		return damage;
	}
	
	/**
	 * Gets the current ammo remaining in the {@link Weapon}.
	 *
	 * @return the current ammo
	 */
	public int getCurrentAmmo() {
		return currentAmmo;
	}
}
