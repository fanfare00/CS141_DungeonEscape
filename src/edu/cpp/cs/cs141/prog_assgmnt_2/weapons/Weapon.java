package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

// TODO: Auto-generated Javadoc
/**
 * The Class Weapon.
 */
public abstract class Weapon {
	
	/** The accuracy. */
	private double accuracy;
	
	/** The damage. */
	private int damage;
	
	/** The max ammo. */
	private int maxAmmo;
	
	/** The current ammo. */
	private int currentAmmo;
	
	/** The name. */
	private String name;
	
	/** The is loaded. */
	private boolean isLoaded;
	
	/**
	 * Instantiates a new weapon.
	 *
	 * @param name the name
	 * @param accuracy the accuracy
	 * @param damage the damage
	 * @param maxAmmo the max ammo
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
	 * Reduce ammo.
	 */
	public void reduceAmmo() {
		if ((currentAmmo - 1) <= 0) {
			isLoaded = false;
		} else {
			currentAmmo -= 1;
		}
	}
	
	/**
	 * Reload.
	 */
	public void reload() {
		currentAmmo = maxAmmo;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the accuracy.
	 *
	 * @return the accuracy
	 */
	public double getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Gets the damage.
	 *
	 * @return the damage
	 */
	public int getDamage() { 
		return damage;
	}
	
	/**
	 * Gets the current ammo.
	 *
	 * @return the current ammo
	 */
	public int getCurrentAmmo() {
		return currentAmmo;
	}
}
