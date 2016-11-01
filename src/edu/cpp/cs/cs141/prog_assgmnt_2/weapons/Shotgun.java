package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

// TODO: Auto-generated Javadoc
/**
 * The Class Shotgun.
 */
public class Shotgun extends Weapon {
	
	/** The Constant DAMAGE. */
	public final static int DAMAGE = 5;
	
	/** The Constant ACCURACY. */
	public final static double ACCURACY = 0.40;
	
	/** The Constant MAX_AMMO. */
	public final static int MAX_AMMO = 5;
	
	/** The Constant WEP_NAME. */
	public static final String WEP_NAME = "Shotgun";
	
	/**
	 * Instantiates a new shotgun.
	 */
	public Shotgun(){
		super(WEP_NAME, ACCURACY, DAMAGE, MAX_AMMO);
	}
}
