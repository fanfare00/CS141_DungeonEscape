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
 * This interface represents guides objects who implement it towards performing an action on a member of the Actor super class.
 */
public interface Item {
	
	/**
	 * Consume.
	 *
	 * @param consumer the consumer
	 */
	public void consume(Actor consumer);
}

