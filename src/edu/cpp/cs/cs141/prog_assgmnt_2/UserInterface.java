package edu.cpp.cs.cs141.prog_assgmnt_2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * The Class UserInterface.
 */
public class UserInterface {

	/** The Constant STATE_BEGINNING. */
	public static final int STATE_BEGINNING = 0;
	
	/** The Constant STATE_TRAVELING. */
	public static final int STATE_TRAVELING = 1;
	
	/** The Constant STATE_BATTLING. */
	public static final int STATE_BATTLING = 2;
	
	/** The Constant STATE_ENDING. */
	public static final int STATE_ENDING = 3;
	
	/** The Constant STATE_WAITING. */
	public static final int STATE_WAITING = 4;
	
	
	/** The Constant KEY_SHOOT. */
	private static final char KEY_SHOOT = 's';
	
	/** The Constant KEY_FLEE. */
	private static final char KEY_FLEE = 'f';
	
	/** The Constant KEY_WALK. */
	private static final char KEY_WALK = 'w';
	
	/** The Constant KEY_QUIT. */
	private static final char KEY_QUIT = 'q';
	
	/** The Constant KEY_NEW. */
	private static final char KEY_NEW = 'n';
	
	/** The Constant KEY_CONT. */
	private static final char KEY_CONT = 'c';
	
	/** The Constant KEY_1. */
	private static final char KEY_1 = '1';
	
	/** The Constant KEY_2. */
	private static final char KEY_2 = '2';
	
	/** The Constant KEY_3. */
	private static final char KEY_3 = '3';
	
	
	/** The Constant KEYS. */
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
	
	/** The active keys. */
	private boolean[] activeKeys = new boolean[KEYS.size()];
	
	/** The application. */
	private Application application;
	
	/** The state. */
	private int state;
	
	/** The scanner. */
	private Scanner scanner;
	
	/** The status. */
	private String status;
	
	/** The instructions. */
	private String instructions;
	
	/** The input. */
	private char input;
	
	/**
	 * Instantiates a new user interface.
	 */
	public UserInterface() {
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Inits the.
	 *
	 * @param application the application
	 */
	public void init(Application application) {
		state = STATE_BEGINNING;
	    update(); 
	}
	
	/**
	 * Update.
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
	 * Handle input.
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
	 * Gets the user input.
	 *
	 * @return the user input
	 */
	private char getUserInput() {
		
		return Character.toLowerCase(scanner.next().trim().charAt(0));
		
	}
	
	/**
	 * Checks if is active.
	 *
	 * @param key the key
	 * @return true, if is active
	 */
	private boolean isActive(char key) {
		if (activeKeys[KEYS.indexOf(key)]) return true;
		return false;
	}
	
	/**
	 * Was typed.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	private boolean wasTyped(char key) {
		if ((input == key) && (isActive(key))) return true;
		return false;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(int state) {	
		this.state = state;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Adds the application.
	 *
	 * @param application the application
	 */
	public void addApplication(Application application) {
		this.application = application;
	}
	
}
