package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

public class Shotgun extends Weapon {
	public final static int DAMAGE = 5;
	public final static double ACCURACY = 0.40;
	public final static int MAX_AMMO = 5;
	public static final String WEP_NAME = "Shotgun";
	
	public Shotgun(){
		super(WEP_NAME, ACCURACY, DAMAGE, MAX_AMMO);
	}
}
