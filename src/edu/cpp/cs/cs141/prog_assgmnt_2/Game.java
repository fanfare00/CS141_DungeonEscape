package edu.cpp.cs.cs141.prog_assgmnt_2;

import edu.cpp.cs.cs141.prog_assgmnt_2.actors.*;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

public class Game {

	public static final double SPAWN_CHANCE = 0.15;
	public static final double PISTOL_ENEMY_CHANCE = 0.50;
	public static final double RIFLE_ENEMY_CHANCE = 0.35;
	public static final double SHOTGUN_ENEMY_CHANCE = 0.15;
	public static final int TOTAL_PACES = 10;
	
	private Player player;
	private Enemy enemy;
	private Actor currentActor;
	
	
	public Game() {
		
	}
	
	public void init(String wepChoice) {
		if (wepChoice == Pistol.WEP_NAME) player = new Player(new Pistol());
		if (wepChoice == Rifle.WEP_NAME) player = new Player(new Rifle());
		if (wepChoice == Shotgun.WEP_NAME) player = new Player(new Shotgun());
		
		currentActor = player;
	}
	
	public boolean spawnEnemy() {
		double d = Math.random();
		if (d < SPAWN_CHANCE) {
			enemy = new Enemy(randomWeapon());
			return true;
		}
		else return false;
	}
	
	public Weapon randomWeapon() {
		double d = Math.random();
		if (d <= PISTOL_ENEMY_CHANCE) return new Shotgun();
		if (d <= RIFLE_ENEMY_CHANCE) return new Rifle();
		else return new Pistol();
	}
	
	public boolean shootEnemy() {
		double d = Math.random();
		if (d <= player.getWeapon().getAccuracy()) {
			enemy.reduceHitPoints(player.getWeapon().getDamage());
			return true;
		}
		else return false;
	}
	
	public boolean shootPlayer() {
		double d = Math.random();
		if (d<= enemy.getWeapon().getAccuracy()) {
			player.reduceHitPoints(enemy.getWeapon().getDamage());
			return true;
		}
		else return false;
	}
	
	public void movePlayerForward() {
		player.move(1);
	}
	
	public int getEnemyHealth() {
		return enemy.getHealth();
	}
	
	public int getPlayerHealth() {
		return player.getHealth();
	}
	
	public String getEnemyWeaponName() {
		return enemy.getWeapon().getName();
	}
	
	public String getPlayerWeaponName() {
		return player.getWeapon().getName();
	}
	
	public int getPlayerWeaponDamage() {
		return player.getWeapon().getDamage();
	}
	
	public int getEnemyWeaponDamage() {
		return enemy.getWeapon().getDamage();
	}
	
	public boolean isPlayerAlive() {
		return player.isAlive();
	}
	
	public boolean isEnemyAlive() {
		return enemy.isAlive();
	}
	
	public boolean hasEscaped() {
		if ((TOTAL_PACES - player.getPosition()) <= 0) return true;
		return false;
	}
	
	public int getPacesRemaining() {
		return TOTAL_PACES - player.getPosition();
	}
}
