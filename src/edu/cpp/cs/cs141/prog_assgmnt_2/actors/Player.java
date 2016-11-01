package edu.cpp.cs.cs141.prog_assgmnt_2.actors;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player extends Actor implements ActiveAgents {
	
	/** The Constant HP. */
	private static final int HP = 20;
	
	/** The Constant FLEE_CHANCE. */
	public static final double FLEE_CHANCE = 0.10;
	
	/** The position. */
	private int position;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param weapon the weapon
	 */
	public Player(Weapon weapon){
		super(HP, weapon);
		position = 0;
	}
	
	/**
	 * Move.
	 *
	 * @param displacement the displacement
	 */
	public void move(int displacement) {
		position+=displacement;
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}
}
