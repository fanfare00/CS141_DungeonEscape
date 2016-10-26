package edu.cpp.cs.cs141.prog_assgmnt_2.actors;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

public class Enemy extends Actor {
	private static final int HP = 5;
	
	public Enemy(Weapon weapon){
		super(HP, weapon);
	}
}
