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


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) { 
	    	Application app = new Application(new UserInterface(), new Game());
	    	app.startNewGame();
     }
}
