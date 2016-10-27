package edu.cpp.cs.cs141.prog_assgmnt_2.weapons;

public abstract class Weapon {
	private double accuracy;
	private int damage;
	private int maxAmmo;
	private int currentAmmo;
	private String name;
	
	public Weapon(String name, double accuracy, int damage, int maxAmmo) {
		this.accuracy = accuracy;
		this.damage = damage;
		this.maxAmmo = maxAmmo;
		this.currentAmmo = maxAmmo;
		this.name = name;
	}
	
	public Weapon() {}
	
	public void reload() {
		currentAmmo = maxAmmo;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAccuracy() {
		return accuracy;
	}
	
	public int getDamage() { 
		return damage;
	}
}
