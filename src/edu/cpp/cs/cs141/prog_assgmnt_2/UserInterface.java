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

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for displaying information to the user, taking input from the
 * user, and telling the application how to proceed based on the input.
 */
public class UserInterface {

	/** Constant for the state UI beginning state. */
	public static final int STATE_BEGINNING = 0;
	
	/** Constant for the UI state traveling state. */
	public static final int STATE_TRAVELING = 1;
	
	/** Constant for the UI battling state */
	public static final int STATE_BATTLING = 2;
	
	/** Constant for the UI ending state */
	public static final int STATE_ENDING = 3;
	
	/** Constant UI waiting state. */
	public static final int STATE_WAITING = 4;
	
	
	/** Constant KEY_SHOOT. */
	private static final char KEY_SHOOT = 's';
	
	/** Constant KEY_FLEE. */
	private static final char KEY_FLEE = 'f';
	
	/** Constant KEY_WALK. */
	private static final char KEY_WALK = 'w';
	
	/** Constant KEY_QUIT. */
	private static final char KEY_QUIT = 'q';
	
	/** Constant KEY_NEW. */
	private static final char KEY_NEW = 'n';
	
	/** Constant KEY_CONT. */
	private static final char KEY_CONT = 'c';
	
	/** Constant KEY_1. */
	private static final char KEY_1 = '1';
	
	/** Constant KEY_2. */
	private static final char KEY_2 = '2';
	
	/** Constant KEY_3. */
	private static final char KEY_3 = '3';
	
	
	/** Constant list containing all keys used in the UI */
	private static final List<Character> KEYS = Arrays.asList(
			KEY_SHOOT, 
			KEY_FLEE, 
			KEY_WALK, 
			KEY_QUIT, 
			KEY_NEW, 
			KEY_CONT, 
			KEY_1, 
			KEY_2, 
			KEY_3 );
	
	/** Array of booleans who's value at any given index represent the active state of the key at the index value */
	private boolean[] activeKeys = new boolean[KEYS.size()];
	
	/** The application that manipulates the UI state */
	private Application application;
	
	/** The state that the UI is currently in. */
	private int state;
	
	/** The scanner that will parse user input into the console. */
	private Scanner scanner;
	
	/** The status message that will display on every update. */
	private String status;
	
	/** The instruction message that will display on every update. */
	private String instructions;
	
	/** The validated character parse that the user enters into the console. */
	private char input;
	
	/**
	 * Instantiates a new user interface.
	 */
	public UserInterface() {
		scanner = new Scanner(System.in);
	}
	
	/**
	 * sets the state to beginning and starts update loop.
	 *
	 * @param application the application
	 */
	public void init(Application application) {
		state = STATE_BEGINNING;
	    update(); 
	}
	
	/**
	 * Updates the list of valid key entries, handles input from user, and gives instructions based on what is happening in the game.
	 * Loops until program ends.
	 */
	public void update() {
		
		Arrays.fill(activeKeys, false);
		
		switch (state) {
			case STATE_BEGINNING:
				instructions = "Choose your weapon:";
				activeKeys[KEYS.indexOf(KEY_1)] = true;
				activeKeys[KEYS.indexOf(KEY_2)] = true;
				activeKeys[KEYS.indexOf(KEY_3)] = true;
				break;
			case STATE_TRAVELING:
				instructions = "Type 'W' to take a step forward\n";
				activeKeys[KEYS.indexOf(KEY_WALK)] = true;
				break;
			case STATE_BATTLING:
				instructions = "Type 'S' to shoot OR type 'F' to flee\n";
				activeKeys[KEYS.indexOf(KEY_FLEE)] = true;
				activeKeys[KEYS.indexOf(KEY_SHOOT)] = true;
				break;
			case STATE_WAITING:
				instructions = "Type 'C' to continue\n";
				activeKeys[KEYS.indexOf(KEY_CONT)] = true;
				break;
			case STATE_ENDING:
				instructions = "Type 'N' to start a new game OR type 'Q' to close\n";
				activeKeys[KEYS.indexOf(KEY_QUIT)] = true;
				activeKeys[KEYS.indexOf(KEY_NEW)] = true;
				break;
		}
		
		System.out.println(status + "\n" + instructions);
		
		handleInput();
		update();
	}
	
	/**
	 * Validates user input and performs commands based on what was input by the user and what was a valid
	 * input at the time the user made the input. Otherwise reports failure to acquire valid input to user.
	 */
	public void handleInput() {
		
		input = getUserInput();
		
		if (wasTyped(KEY_CONT)) application.handleEnemyCombat();
		else if (wasTyped(KEY_SHOOT)) application.handlePlayerCombat();
		else if (wasTyped(KEY_FLEE)) application.attemptFlee();
		else if (wasTyped(KEY_WALK)) application.walkForward();
		else if (wasTyped(KEY_NEW)) application.startNewGame();
		else if (wasTyped(KEY_QUIT)) application.close();
		else if (wasTyped(KEY_1)) application.chooseWeapon(Character.getNumericValue(input));
		else if (wasTyped(KEY_2)) application.chooseWeapon(Character.getNumericValue(input));
		else if (wasTyped(KEY_3)) application.chooseWeapon(Character.getNumericValue(input));
		else System.out.println("Invalid input, please try again.\n");
		
	}
	
	/**
	 * Gets and parses user input from console.
	 *
	 * @return the user input
	 */
	private char getUserInput() {
		
		return Character.toLowerCase(scanner.next().trim().charAt(0));
		
	}
	
	/**
	 * Checks if a key command is active
	 *
	 * @param key the key
	 * @return true, if is active
	 */
	private boolean isActive(char key) {
		if (activeKeys[KEYS.indexOf(key)]) return true;
		return false;
	}
	
	/**
	 * Checks if a key command was active and valid at the time user entered it.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	private boolean wasTyped(char key) {
		if ((input == key) && (isActive(key))) return true;
		return false;
	}
	
	/**
	 * Sets the UI state.
	 *
	 * @param state the new state
	 */
	public void setState(int state) {	
		this.state = state;
	}
	
	/**
	 * Sets the status message to be displayed on update.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Adds the application that controls UI states.
	 *
	 * @param application the application
	 */
	public void addApplication(Application application) {
		this.application = application;
	}
	
}
