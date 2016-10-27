package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

public class Pistol extends Weapon {

	public final static double ACCURACY = 0.75;
	public final static int DAMAGE = 1;
	public final static int MAX_AMMO = 15;
	public static final String WEP_NAME = "Pistol";
	
	public Pistol() {
		super(WEP_NAME, ACCURACY, DAMAGE, MAX_AMMO);
	}
	
}
