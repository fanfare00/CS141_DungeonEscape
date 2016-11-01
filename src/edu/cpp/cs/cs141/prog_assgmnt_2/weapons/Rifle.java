package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

// TODO: Auto-generated Javadoc
/**
 * The Class Rifle.
 */
public class Rifle extends Weapon{
	
	/** The Constant ACCURACY. */
	public final static double ACCURACY = 0.65;
	
	/** The Constant DAMAGE. */
	public final static int DAMAGE = 2;
	
	/** The Constant MAX_AMMO. */
	public final static int MAX_AMMO = 10;
	
	/** The Constant WEP_NAME. */
	public static final String WEP_NAME = "Rifle";
	
	/**
	 * Instantiates a new rifle.
	 */
	public Rifle(){
		super(WEP_NAME, ACCURACY, DAMAGE, MAX_AMMO);
	}
}
