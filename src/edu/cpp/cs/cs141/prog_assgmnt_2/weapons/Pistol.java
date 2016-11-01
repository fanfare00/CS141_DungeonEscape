package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

// TODO: Auto-generated Javadoc
/**
 * The Class Pistol.
 */
public class Pistol extends Weapon {

	/** The Constant ACCURACY. */
	public final static double ACCURACY = 0.75;
	
	/** The Constant DAMAGE. */
	public final static int DAMAGE = 1;
	
	/** The Constant MAX_AMMO. */
	public final static int MAX_AMMO = 15;
	
	/** The Constant WEP_NAME. */
	public static final String WEP_NAME = "Pistol";
	
	/**
	 * Instantiates a new pistol.
	 */
	public Pistol() {
		super(WEP_NAME, ACCURACY, DAMAGE, MAX_AMMO);
	}
	
}
