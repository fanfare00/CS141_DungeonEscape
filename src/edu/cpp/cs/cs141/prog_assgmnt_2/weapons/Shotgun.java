package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

public class Shotgun extends Weapon {
	private final static int DAMAGE = 5;
	private final static double ACCURACY = 0.40;
	private final static int MAX_AMMO = 5;
	
	public Shotgun(){
		super(ACCURACY, DAMAGE, MAX_AMMO);
	}
}
