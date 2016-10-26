package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

public abstract class Weapon {
	private double accuracy;
	private int damage;
	private int maxAmmo;
	private int currentAmmo;
	
	public Weapon(double accuracy, int damage, int maxAmmo) {
		this.accuracy = accuracy;
		this.damage = damage;
		this.maxAmmo = maxAmmo;
		this.currentAmmo = maxAmmo;
	}
	
	public Weapon() {}
	
	public void reload() {
		currentAmmo = maxAmmo;
	}
}
