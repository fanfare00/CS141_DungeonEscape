package edu.cpp.cs.cs141.prog_assgmnt_2.actors;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Enemy.
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
