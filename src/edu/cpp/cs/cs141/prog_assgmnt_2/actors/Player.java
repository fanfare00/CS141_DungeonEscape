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
 * This class represents the user controlled Actor who's data is manipulated through the game's logic.
 * In addition to all methods and fields of its super class, it also contains additional methods
 * relating to schemes of user control.
 */
public class Player extends Actor implements ActiveAgents {
	
	/** Constant for the {@link Player}'s initial and maximum HP. */
	private static final int HP = 20;
	
	/** Constant {@link Player}'s probability of successfully fleeing an encounter. */
	public static final double FLEE_CHANCE = 0.10;
	
	/** The {@link Player}'s current position. */
	private int position;
	
	/**
	 * Instantiates a new {@link Player}.
	 *
	 * @param weapon the weapon
	 */
	public Player(Weapon weapon){
		super(HP, weapon);
		position = 0;
	}
	
	/**
	 * Moves the {@link Player} forward or backward based on the given value.
	 *
	 * @param displacement the displacement
	 */
	public void move(int displacement) {
		position+=displacement;
	}
	
	/**
	 * Gets the {@link Player}'s position.
	 *
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
}
