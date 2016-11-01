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

import edu.cpp.cs.cs141.prog_assgmnt_2.weapons.*;

/**
 * The purpose of this class is to update the game's logic and change the UI state based on what is occurring
 * in the game. 
 */
public class Application {
	
	/** The UserInterface who's display will be altered by this Application. */
	private UserInterface ui;
	
	/** The Game who's logic will will be updated based on the user's interaction with the UI */
	private Game game;
	
	
	/**
	 * Instantiates a new application.
	 *
	 * @param ui the ui
	 * @param game the game
	 */
	public Application(UserInterface ui, Game game) {
		this.ui = ui;
		this.game = game;
	}
	
	/**
	 * This method decides what state to put the UI into and what message the UI will display based on the outcome of 
	 * the game's probability based combat functions relating to it's player object.
	 */
	public void handlePlayerCombat() {
		if (game.getPlayerCurrentAmmo() != 0) {
			if(game.attemptShootEnemy()) {
				ui.setStatus("Your " + game.getPlayerWeaponName() + " hits the mummy for " +
							  game.getPlayerWeaponDamage() + " points of damage. Only " + 
							  game.getEnemyHealth() + "HP remains.\n" +
							  "Your " + game.getPlayerWeaponName() + " Now has " + game.getPlayerCurrentAmmo() + " shots left.\n");
			} else {
				ui.setStatus("Your " + game.getPlayerWeaponName() + " misses the mummy.\n" +
				"Your " + game.getPlayerWeaponName() + " Now has " + game.getPlayerCurrentAmmo() + " shots left.\n");
			}
		} else {
			ui.setStatus("Your " + game.getPlayerWeaponName() + " is out of ammo. RUN!");
		}
		
		if (game.isEnemyAlive()) {
			ui.setState(UserInterface.STATE_WAITING);
		} else {
			ui.setStatus("You defeated the mummy!\n" + "Only " + game.getPacesRemaining() + " paces remain! Continue towards the exit.");
			
			if (game.spawnItem()) {
				game.useItem();
				ui.setStatus("You've You defeated the mummy and found a health pack!\n"+
						     "Up to 5HP has been restored. You now have " + game.getPlayerHealth() + "HP.\n" +
						     "Only " + game.getPacesRemaining() + " paces remain! Continue towards the exit.");
			} else {
				game.useItem();
				ui.setStatus("You've defeated the mummy and found an ammo pack!\n"+
						     "Your " + game.getPlayerWeaponName() + " Now has " + game.getPlayerCurrentAmmo() + " shots left.\n\n" +
						     "Only " + game.getPacesRemaining() + " paces remain! Continue towards the exit.");
			}
			
			ui.setState(UserInterface.STATE_TRAVELING);
		}
	}
	
	/**
	 * This method decides what state to put the UI into and what message the UI will display based on the outcome of 
	 * the game's probability based combat functions relating to it's enemy object.
	 */
	public void handleEnemyCombat() {
		if(game.attemptShootPlayer()) {
			ui.setStatus("The mummy's " + game.getEnemyWeaponName() + " hits you for " +
						  game.getEnemyWeaponDamage() + " points of damage.\nYou have " + 
						  game.getPlayerHealth() + "HP left.\n");
		} else {
			ui.setStatus("The mummy's " + game.getEnemyWeaponName() + " misses you.");
		}
		
		if (game.isPlayerAlive()) {
			ui.setState(UserInterface.STATE_BATTLING);
		} else {
			ui.setStatus("The mummy's final shot connects, killing you. Game over. Start new game?");
			ui.setState(UserInterface.STATE_ENDING);
		}
	}
	
	/**
	 * This method initializes the UI class and the game class and sets the UI to display messages
	 * relating to the beginning of the game.
	 */
	public void startNewGame() {
		game = new Game();
		ui = new UserInterface();
		ui.addApplication(this);
		ui.setStatus("Welcome to James' Dungeon Escape\n\n" +
					 "Type 1 for a " + Pistol.WEP_NAME + 
					 	" (Damage: " + Pistol.DAMAGE + 
					    ", Accuracy: " + Pistol.ACCURACY + 
						", Ammo Capacity: " + Pistol.MAX_AMMO +")\n" +
							
					"Type 2 for a " + Rifle.WEP_NAME + 
						" (Damage: " + Rifle.DAMAGE + 
						", Accuracy: " + Rifle.ACCURACY + 
						", Ammo Capacity: " + Rifle.MAX_AMMO +")\n" +
						
					"Type 3 for a " + Shotgun.WEP_NAME + 
						" (Damage: " + Shotgun.DAMAGE + 
						", Accuracy: " + Shotgun.ACCURACY + 
						", Ammo Capacity: " + Shotgun.MAX_AMMO +")\n");
				
		ui.init(this);
	}

	/**
	 * This method decides what state to put the UI into and what message the UI will display based on the outcome of 
	 * the game's probability based flee function.
	 */
	public void attemptFlee() {
		
		if(game.attemptPlayerFlee()) { 
			
			ui.setStatus("You escaped the mummy, but you moved back one pace.\n" +
					"The exit is only " + game.getPacesRemaining() + " paces away, keep moving!");
			ui.setState(UserInterface.STATE_TRAVELING);
		}
		else {
			ui.setStatus("Your attempt to flee failed.");
			ui.setState(UserInterface.STATE_WAITING);
		}
	}

	/**
	 * This method decides what state to put the UI into and what message the UI will display based on whether or not
	 * the game is over and if not, then on the outcome of the game's probability based spawning function.
	 */
	public void walkForward() {
		
		game.movePlayerForward();
		
		if (game.getPacesRemaining() == 0) {
			ui.setStatus("You've made it to the exit. You win! Start new Game?");
			ui.setState(UserInterface.STATE_ENDING);
			return;
		}
		
		
		
		if (game.attemptSpawnEnemy()) {
			ui.setStatus("A mummy with a " + game.getEnemyWeaponName() + " has appeared!");
			ui.setState(UserInterface.STATE_BATTLING);
		} else {
			ui.setStatus("The exit is only " + game.getPacesRemaining() + " paces away, keep moving!");
		}
	}

	/**
	 * Sets the game's player object to use a weapon type chosen by the user.
	 *
	 * @param wepChoice the weapon choice
	 */
	public void chooseWeapon(int wepChoice) {
		game.init(wepChoice);
		ui.setStatus("You've chosen the " + game.getPlayerWeaponName() + "."
				+ "The exit is only 10 paces away, try to make your escape!");
		ui.setState(UserInterface.STATE_TRAVELING);
	}

	/**
	 * Closes the program.
	 */
	public void close() {
		System.exit(0);
	}
	

}
