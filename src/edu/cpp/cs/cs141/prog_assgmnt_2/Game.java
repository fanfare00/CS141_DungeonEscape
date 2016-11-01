/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #2
 *
 * A miniature dungeon escape game.
 *
 * @author J. Donald McCarthy
 */

package edu.cpp.cs.cs141.prog_assgmnt_2;

import edu.cpp.cs.cs141.prog_assgmnt_2.actors.*;
import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;
import edu.cpp.cs.cs141.prog_assgmnt_2.items.*;

/**
 * This class contains the logic of the game. It's methods are called by the application class which also
 * updates the UI accordingly.
 */
public class Game {

	/** Constant for the probability that a medpac spawns after encounter. */
	public static final double HEALTH_SPAWN_CHANCE = 0.30;
	
	/** Constant for the probability that an enemy spawns on any step */
	public static final double ENEMY_SPAWN_CHANCE = 0.15;
	
	/** Constant for the probability that an enemy will spawn with a pistol */
	public static final double PISTOL_ENEMY_CHANCE = 0.50;
	
	/** Constant for the probability that an enemy will spawn with a rifle */
	public static final double RIFLE_ENEMY_CHANCE = 0.35;
	
	/** Constant for the probability that an enemy will spawn with a shotgun */
	public static final double SHOTGUN_ENEMY_CHANCE = 0.15;
	
	/** Constant for the total number of steps until the end is reached */
	public static final int TOTAL_PACES = 10;
	
	/** Constant for the {@link player} potential starting pistol. */
	private static final int CHOICE_PISTOL = 1;
	
	/** Constant for the {@link player} potential starting rifle. */
	private static final int CHOICE_RIFLE = 2;
	
	/** Constant for the {@link player} potential starting shotgun. */
	private static final int CHOICE_SHOTGUN = 3;
	
	/** The {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Player} who's data will be manipulated by this game class's logic. */
	private Player player;
	
	/** The {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Enemy} who's data will be manipulated by this game class's logic. */
	private Enemy enemy;
	
	/** The {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Item} that will be generated after every encounter */
	private Item currentItem;
	
	/**
	 * Instantiates a new game.
	 */
	public Game() {}
	
	/**
	 * Initializes the {@link player} with starting weapon data.
	 *
	 * @param wepChoice the choice of starting weapon.
	 */
	public void init(int wepChoice) {
		if (wepChoice == CHOICE_PISTOL) player = new Player(new Pistol());
		if (wepChoice == CHOICE_RIFLE) player = new Player(new Rifle());
		if (wepChoice == CHOICE_SHOTGUN) player = new Player(new Shotgun());
	}
	
	/**
	 * Attempts to spawn an {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Enemy} based on the value of {@value #ENEMY_SPAWN_CHANCE} with
	 * a random weapon generated by {@link #getRandomWeapon()}
	 *
	 * @return true, if successful
	 */
	public boolean attemptSpawnEnemy() {
		double d = Math.random();
		if (d < ENEMY_SPAWN_CHANCE) {
			enemy = new Enemy(getRandomWeapon());
			return true;
		}
		else return false;
	}
	
	/**
	 * Attempts to move player position backwards by 1 based on the value of {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Player#FLEE_CHANCE}
	 *
	 * @return true, if successful
	 */
	public boolean attemptPlayerFlee() {
		double d = Math.random(); 
		 if (d < player.FLEE_CHANCE) {
			 player.move(-1);
			 return true;
		 }
		 else return false;
	}
	
	/**
	 * Attempts to generate a {@link edu.cpp.cs.cs141.prog_assgmnt_2.weapons.Shotgun} based on the probability represented by {@value #SHOTGUN_ENEMY_CHANCE}.
	 * If unsuccessful, attempts to generate a {@link edu.cpp.cs.cs141.prog_assgmnt_2.weapons.Rifle} based on the probability represented by {@value #RIFLE_ENEMY_CHANCE}.
	 * Finally if no weapon has been generated, generates a {@link edu.cpp.cs.cs141.prog_assgmnt_2.weapons.Pistol}.
	 *
	 * @return the weapon generated
	 */
	public Weapon getRandomWeapon() {
		double d = Math.random();
		if (d <= PISTOL_ENEMY_CHANCE) return new Shotgun();
		if (d <= RIFLE_ENEMY_CHANCE) return new Rifle();
		else return new Pistol();
	}
	
	/**
	 * Reduces the player's ammo count and makes an attempt based on the probability 
	 * {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Weapon#accuracy} to remove hit points 
	 * from the enemy based on the damage value {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Weapon#damage}
	 * of the player's weapon.
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
	 * Reduces the enemy's ammo count and makes an attempt based on the probability 
	 * {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Weapon#accuracy} to remove hit points 
	 * from the player based on the damage value {@link edu.cpp.cs.cs141.prog_assgmnt_2.actors.Weapon#damage}
	 * of the enemy's weapon.
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
	 * Attempts to generate a {@link edu.cpp.cs.cs141.prog_assgmnt_2.items.Medpac} and assign it to the
	 * variable {@value currentItem} based on the probability {@value #HEALTH_SPAWN_CHANCE}.
	 * If unsuccessful, generates ammo and assigns to {@value currentItem} instead.
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
	 * Executes the method {@link edu.cpp.cs.cs141.prog_assgmnt_2.items.Item#consume(Actor)} on player.
	 */
	public void useItem() {
		currentItem.consume(player);
	}
	
	/**
	 * Moves the player forward in the positive direction, bringing them closer to the end.
	 *
	 * @param displacement the displacement
	 */
	public void movePlayerForward() {
		player.move(1);
	}
	
	/**
	 * Gets the current hitPoint value for the currently active {@link enemy}.
	 *
	 * @return the {@link enemy} health
	 */
	public int getEnemyHealth() {
		return enemy.getHealth();
	}
	
	/**
	 * Gets the {@link player} current health value.
	 *
	 * @return the {@link player} health
	 */
	public int getPlayerHealth() {
		return player.getHealth();
	}
	
	/**
	 * Gets the {@link enemy} weapon name.
	 *
	 * @return the {@link enemy} weapon name
	 */
	public String getEnemyWeaponName() {
		return enemy.getWeapon().getName();
	}
	
	/**
	 * Gets the {@link player} weapon name.
	 *
	 * @return the {@link player} weapon name
	 */
	public String getPlayerWeaponName() {
		return player.getWeapon().getName();
	}
	
	/**
	 * Gets the {@link player} weapon damage.
	 *
	 * @return the {@link player} weapon damage
	 */
	public int getPlayerWeaponDamage() {
		return player.getWeapon().getDamage();
	}
	
	/**
	 * Gets the {@link enemy} weapon damage.
	 *
	 * @return the {@link enemy} weapon damage
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
	 * Checks if is {@link enemy} alive.
	 *
	 * @return true, if {@link enemy} is alive
	 */
	public boolean isEnemyAlive() {
		return enemy.isAlive();
	}
	
	/**
	 * Gets the {@link player} current ammo.
	 *
	 * @return the {@link player} current ammo
	 */
	public int getPlayerCurrentAmmo() {
		return player.getWeapon().getCurrentAmmo();
	}
	
	/**
	 * Checks to see if the {@link player} has completed the required number of steps to end the game.
	 *
	 * @return true, if successful
	 */
	public boolean hasEscaped() {
		if ((TOTAL_PACES - player.getPosition()) <= 0) return true;
		return false;
	}
	
	/**
	 * Gets the number of steps remaining before the {@link player} ends the game.
	 *
	 * @return the paces remaining
	 */
	public int getPacesRemaining() {
		return TOTAL_PACES - player.getPosition();
	}




}
