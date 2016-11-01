package edu.cpp.cs.cs141.prog_assgmnt_2;

import edu.cpp.cs.cs141.prog_assgmnt_2.actors.*;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;
import edu.cpp.cs.cs141.prog_assgmnt_2.items.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */
public class Game {

	/** The Constant HEALTH_SPAWN_CHANCE. */
	public static final double HEALTH_SPAWN_CHANCE = 0.30;
	
	/** The Constant ENEMY_SPAWN_CHANCE. */
	public static final double ENEMY_SPAWN_CHANCE = 0.15;
	
	/** The Constant PISTOL_ENEMY_CHANCE. */
	public static final double PISTOL_ENEMY_CHANCE = 0.50;
	
	/** The Constant RIFLE_ENEMY_CHANCE. */
	public static final double RIFLE_ENEMY_CHANCE = 0.35;
	
	/** The Constant SHOTGUN_ENEMY_CHANCE. */
	public static final double SHOTGUN_ENEMY_CHANCE = 0.15;
	
	/** The Constant TOTAL_PACES. */
	public static final int TOTAL_PACES = 10;
	
	/** The Constant CHOICE_PISTOL. */
	private static final int CHOICE_PISTOL = 1;
	
	/** The Constant CHOICE_RIFLE. */
	private static final int CHOICE_RIFLE = 2;
	
	/** The Constant CHOICE_SHOTGUN. */
	private static final int CHOICE_SHOTGUN = 3;
	
	/** The player. */
	private Player player;
	
	/** The enemy. */
	private Enemy enemy;
	
	/** The current item. */
	private Item currentItem;
	
	/**
	 * Instantiates a new game.
	 */
	public Game() {}
	
	/**
	 * Inits the.
	 *
	 * @param wepChoice the wep choice
	 */
	public void init(int wepChoice) {
		if (wepChoice == CHOICE_PISTOL) player = new Player(new Pistol());
		if (wepChoice == CHOICE_RIFLE) player = new Player(new Rifle());
		if (wepChoice == CHOICE_SHOTGUN) player = new Player(new Shotgun());
	}
	
	/**
	 * Spawn enemy.
	 *
	 * @return true, if successful
	 */
	public boolean spawnEnemy() {
		double d = Math.random();
		if (d < ENEMY_SPAWN_CHANCE) {
			enemy = new Enemy(randomWeapon());
			return true;
		}
		else return false;
	}
	
	/**
	 * Attempt player flee.
	 *
	 * @return true, if successful
	 */
	public boolean attemptPlayerFlee() {
		double d = Math.random(); 
		 if (d < player.FLEE_CHANCE) {
			 return true;
		 }
		 else return false;
	}
	
	/**
	 * Random weapon.
	 *
	 * @return the weapon
	 */
	public Weapon randomWeapon() {
		double d = Math.random();
		if (d <= PISTOL_ENEMY_CHANCE) return new Shotgun();
		if (d <= RIFLE_ENEMY_CHANCE) return new Rifle();
		else return new Pistol();
	}
	
	/**
	 * Attempt shoot enemy.
	 *
	 * @return true, if successful
	 */
	public boolean attemptShootEnemy() {
		player.getWeapon().reduceAmmo();
		
		double d = Math.random();
		if (d <= player.getWeapon().getAccuracy()) {
			enemy.reduceHitPoints(player.getWeapon().getDamage());
			return true;
		}
		else return false;
	}
	
	/**
	 * Attempt shoot player.
	 *
	 * @return true, if successful
	 */
	public boolean attemptShootPlayer() {
		double d = Math.random();
		if (d<= enemy.getWeapon().getAccuracy()) {
			player.reduceHitPoints(enemy.getWeapon().getDamage());
			return true;
		}
		else return false;
	}
	
	/**
	 * Spawn item.
	 *
	 * @return true, if successful
	 */
	public boolean spawnItem() {
		double d = Math.random();
		if (d<= HEALTH_SPAWN_CHANCE) {
			currentItem = new Medpac();
			return true;
		} else {
			currentItem = new Ammo();
			return false;
		}
	}
	
	/**
	 * Use item.
	 */
	public void useItem() {
		currentItem.consume(player);
	}
	
	/**
	 * Move player.
	 *
	 * @param displacement the displacement
	 */
	public void movePlayer(int displacement) {
		player.move(displacement);
	}
	
	/**
	 * Gets the enemy health.
	 *
	 * @return the enemy health
	 */
	public int getEnemyHealth() {
		return enemy.getHealth();
	}
	
	/**
	 * Gets the player health.
	 *
	 * @return the player health
	 */
	public int getPlayerHealth() {
		return player.getHealth();
	}
	
	/**
	 * Gets the enemy weapon name.
	 *
	 * @return the enemy weapon name
	 */
	public String getEnemyWeaponName() {
		return enemy.getWeapon().getName();
	}
	
	/**
	 * Gets the player weapon name.
	 *
	 * @return the player weapon name
	 */
	public String getPlayerWeaponName() {
		return player.getWeapon().getName();
	}
	
	/**
	 * Gets the player weapon damage.
	 *
	 * @return the player weapon damage
	 */
	public int getPlayerWeaponDamage() {
		return player.getWeapon().getDamage();
	}
	
	/**
	 * Gets the enemy weapon damage.
	 *
	 * @return the enemy weapon damage
	 */
	public int getEnemyWeaponDamage() {
		return enemy.getWeapon().getDamage();
	}
	
	/**
	 * Checks if is player alive.
	 *
	 * @return true, if is player alive
	 */
	public boolean isPlayerAlive() {
		return player.isAlive();
	}
	
	/**
	 * Checks if is enemy alive.
	 *
	 * @return true, if is enemy alive
	 */
	public boolean isEnemyAlive() {
		return enemy.isAlive();
	}
	
	/**
	 * Gets the player current ammo.
	 *
	 * @return the player current ammo
	 */
	public int getPlayerCurrentAmmo() {
		return player.getWeapon().getCurrentAmmo();
	}
	
	/**
	 * Checks for escaped.
	 *
	 * @return true, if successful
	 */
	public boolean hasEscaped() {
		if ((TOTAL_PACES - player.getPosition()) <= 0) return true;
		return false;
	}
	
	/**
	 * Gets the paces remaining.
	 *
	 * @return the paces remaining
	 */
	public int getPacesRemaining() {
		return TOTAL_PACES - player.getPosition();
	}




}
