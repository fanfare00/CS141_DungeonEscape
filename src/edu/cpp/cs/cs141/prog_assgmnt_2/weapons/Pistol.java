package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

public class Pistol extends Weapon {

	private final static double ACCURACY = 0.75;
	private final static int DAMAGE = 1;
	private final static int MAX_AMMO = 15;
	
	public Pistol() {
		super(ACCURACY, DAMAGE, MAX_AMMO);
	}
	
}
