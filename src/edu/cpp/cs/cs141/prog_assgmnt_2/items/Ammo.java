package edu.cpp.cs.cs141.prog_assgmnt_2.items;

import edu.cpp.cs.cs141.prog_assgmnt_2.actors.Actor;

// TODO: Auto-generated Javadoc
/**
 * The Class Ammo.
 */
public class Ammo implements Item{

	/* (non-Javadoc)
	 * @see edu.cpp.cs.cs141.prog_assgmnt_2.items.Item#consume(edu.cpp.cs.cs141.prog_assgmnt_2.actors.Actor)
	 */
	@Override
	public void consume(Actor consumer) {
		consumer.getWeapon().reload();	
	}

}
