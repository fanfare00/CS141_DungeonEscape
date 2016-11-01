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


package edu.cpp.cs.cs141.prog_assgmnt_2.items;

import edu.cpp.cs.cs141.prog_assgmnt_2.actors.Actor;

// TODO: Auto-generated Javadoc
/**
 * This class represents an implementation of the Item interface that will restore health to the player.
 */
public class Medpac implements Item{

	/** Constant for the amount of health restored by the {@link Medpac}. */
	private static int HEALTH_RESTORED = 5;
	
	/**
	 * @see edu.cpp.cs.cs141.prog_assgmnt_2.items.Item#consume(edu.cpp.cs.cs141.prog_assgmnt_2.actors.Actor)
	 */
	@Override
	public void consume(Actor consumer) {
		consumer.restoreHitPoints(HEALTH_RESTORED);
	}

}
