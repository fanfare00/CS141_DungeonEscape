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

// TODO: Auto-generated Javadoc
/**
 * This class is a subclass of the base Weapon class. It's values are altered to represent one of 
 * required weapon types outlined in the assignment #2 specifications.
 */
public class Shotgun extends Weapon {
	
	/** Constant for the probability of this type of Weapon to successfully reduce hitpoints. */
	public final static int DAMAGE = 5;
	
	/** Constant for the amount of hitpoints reduced by this type of Weapon. */
	public final static double ACCURACY = 0.40;
	
	/** Constant for the maximum amount of ammo that this type of Weapon can hold*/
	public final static int MAX_AMMO = 5;
	
	/** Constant for the name of this Weapon as a String */
	public static final String WEP_NAME = "Shotgun";
	
	/**
	 * Instantiates a new shotgun.
	 */
	public Shotgun(){
		super(WEP_NAME, ACCURACY, DAMAGE, MAX_AMMO);
	}
}
