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
 * This class represents an implementation of the Item interface that will reload the player's weapon.
 */
public class Ammo implements Item{

	/**
	 * @see edu.cpp.cs.cs141.prog_assgmnt_2.items.Item#consume(edu.cpp.cs.cs141.prog_assgmnt_2.actors.Actor)
	 */
	@Override
	public void consume(Actor consumer) {
		consumer.getWeapon().reload();	
	}

}
