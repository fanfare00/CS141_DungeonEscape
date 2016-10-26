package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

public class Rifle extends Weapon{
	
	private final static double ACCURACY = 0.65;
	private final static int DAMAGE = 2;
	private final static int MAX_AMMO = 10;
	
	public Rifle(){
		super(ACCURACY, DAMAGE, MAX_AMMO);
	}
}
