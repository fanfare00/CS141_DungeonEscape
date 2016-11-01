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
 * This class represents the non user controlled Actor who interacts with the user controlled actor
 * through the game's logic.
 */
public class Enemy extends Actor implements ActiveAgents {
	
	/** The Constant HP. */
	private static final int HP = 5;
	
	/**
	 * Instantiates a new enemy.
	 *
	 * @param weapon the weapon
	 */
	public Enemy(Weapon weapon){
		super(HP, weapon);
	}
}
