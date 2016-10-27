package edu.cpp.cs.cs141.prog_assgmnt_2;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) { 
    	SwingUtilities.invokeLater(() -> {
	    	UserInterface ui = new UserInterface();
	        ui.addApplication(new Application(ui, new Game()));
    	});
        
     }
}
