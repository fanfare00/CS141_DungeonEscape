package edu.cpp.cs.cs141.prog_assgmnt_2.items;

import edu.cpp.cs.cs141.prog_assgmnt_2.actors.Actor;

// TODO: Auto-generated Javadoc
/**
 * The Class Medpac.
 */
public class Medpac implements Item{

	/** The health restored. */
	private static int HEALTH_RESTORED = 5;
	
	/* (non-Javadoc)
	 * @see edu.cpp.cs.cs141.prog_assgmnt_2.items.Item#consume(edu.cpp.cs.cs141.prog_assgmnt_2.actors.Actor)
	 */
	@Override
	public void consume(Actor consumer) {
		consumer.restoreHitPoints(HEALTH_RESTORED);
	}

}
