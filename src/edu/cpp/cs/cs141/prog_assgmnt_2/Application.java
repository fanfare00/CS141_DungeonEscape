package edu.cpp.cs.cs141.prog_assgmnt_2;


public class Application {
	private UserInterface ui;
	private Game game;
	
	
	public Application(UserInterface ui, Game game) {
		this.ui = ui;
		this.game = game;
		
		
	}
	
	public void playerCombat() {
		if(game.shootEnemy()) {
			ui.setStatus("<html><center>Your " + game.getPlayerWeaponName() + " hits the mummy for " +
						  game.getPlayerWeaponDamage() + " points of damage.</center> <center>Only " + 
						  game.getEnemyHealth() + "HP remains.</center></html>");
		} else {
			ui.setStatus("Your " + game.getPlayerWeaponName() + " misses the zombie.");
		}
		
		if (game.isEnemyAlive()) {
			//provides one option leading to enemy combat
			ui.state_Waiting();
		} else {
			ui.setStatus("You defeated the mummy! Continue towards the exit.");
			ui.state_Traveling();
		}
		
	}
	
	public void enemyCombat() {
		if(game.shootPlayer()) {
			ui.setStatus("<html><center>The mummy's " + game.getEnemyWeaponName() + " hits you for " +
						  game.getEnemyWeaponDamage() + " points of damage.</center> <center> You have " + 
						  game.getPlayerHealth() + "HP left.</center></html>");
		} else {
			ui.setStatus("The mummy's " + game.getEnemyWeaponName() + " misses you.");
		}
		
		if (game.isPlayerAlive()) {
			ui.state_Battling();
		} else {
			
			ui.setStatus("You died. Game over. Start new game?");
			ui.state_Ending();
		}

	}
	
	public void startNewGame() {
		game = new Game();
		ui = new UserInterface();
		ui.addApplication(this);
	}

	public void attemptFlee() {
		
		//TODO: add fleeing mechanics
	}

	public void walkForward() {

		
		game.movePlayerForward();
		ui.updateBallPosition(game.TOTAL_PACES - game.getPacesRemaining());
		
		if (game.getPacesRemaining() == 0) {
			ui.setStatus("You've made it to the exit. You win! Start new Game?");
			ui.state_Ending();
			return;
		}
		
		if (game.spawnEnemy()) {
			ui.setStatus("A mummy with a " + game.getEnemyWeaponName() + " has appeared!");
			ui.state_Battling();
		} else {
			ui.setStatus("The exit is only " + game.getPacesRemaining() + " paces away, keep moving!");
		}
	}


	
	public void chooseWeapon(String wepChoice) {
		game.init(wepChoice);
		ui.setStatus("<html><center>You've chosen the " + wepChoice + ".</center>"
				+ "The exit is only 10 paces away, try to make your escape!</html>");
		ui.state_Begin();
		
	}

	

}
