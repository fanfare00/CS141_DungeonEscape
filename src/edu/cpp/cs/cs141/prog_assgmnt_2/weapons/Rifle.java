package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

public class Rifle extends Weapon{
	
	public final static double ACCURACY = 0.65;
	public final static int DAMAGE = 2;
	public final static int MAX_AMMO = 10;
	public static final String WEP_NAME = "Rifle";
	
	public Rifle(){
		super(WEP_NAME, ACCURACY, DAMAGE, MAX_AMMO);
	}
}
