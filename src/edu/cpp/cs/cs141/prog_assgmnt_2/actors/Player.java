package edu.cpp.cs.cs141.prog_assgmnt_2.actors;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

public class Player extends Actor {
	
	private static final int HP = 20;
	private int position;
	
	public Player(Weapon weapon){
		super(HP, weapon);
		position = 0;
	}
	
	public void move(int displacement) {
		position+=displacement;
	}
	
	public int getPosition() {
		return position;
	}
}
