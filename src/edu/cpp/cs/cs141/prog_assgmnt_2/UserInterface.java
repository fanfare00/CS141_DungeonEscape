package edu.cpp.cs.cs141.prog_assgmnt_2;

import java.awt.event.ActionEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UserInterface extends JFrame {

	private static final int WINDOW_WIDTH = 360;
	private static final int WINDOW_HEIGHT = 640;
	
	private Application application;
	
	private JLabel statusLabel;
	
	private JButton leftButton;
	private JButton rightButton;
	private JButton centerButton;
	private JButton topButton;
	
	private GraphicsPanel graphicsPanel;
	
	public UserInterface() {
		init();
	}
	
	public void init() {
		
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("J. Donald's Dungeon Escape");
		this.setLayout(null);
		
		statusLabel = new JLabel("Choose Your Weapon", SwingConstants.CENTER);
		statusLabel.setBounds(0, 10, WINDOW_WIDTH, 30);
		this.add(statusLabel);
		
		leftButton = new JButton("Pistol");
		leftButton.setBounds(10, WINDOW_HEIGHT-65, 100, 25);
		leftButton.addActionListener((ActionEvent e) -> {
			application.chooseWeapon(leftButton.getText());
		});
		leftButton.setVisible(true);
		this.add(leftButton);
		
		rightButton = new JButton("Shotgun");
		rightButton.setBounds(WINDOW_WIDTH-115, WINDOW_HEIGHT-65, 100, 25);
		rightButton.addActionListener((ActionEvent e) -> {
			application.chooseWeapon(rightButton.getText());
		});
		rightButton.setVisible(true);
		this.add(rightButton);
		
		
		centerButton = new JButton("Rifle");
		centerButton.setBounds(WINDOW_WIDTH/2 - 65, WINDOW_HEIGHT-65, 125, 25);
		centerButton.addActionListener((ActionEvent e) -> {
			application.chooseWeapon(centerButton.getText());
		});
		centerButton.setVisible(true);
		this.add(centerButton);
		
		topButton = new JButton("Continue");
		topButton.setBounds(WINDOW_WIDTH/2 - 65, WINDOW_HEIGHT-95, 125, 25);
		topButton.addActionListener((ActionEvent e) -> {
			application.enemyCombat();
		});
		topButton.setVisible(false);
		this.add(topButton);
		
		graphicsPanel = new GraphicsPanel(11, 25, 0, 400, WINDOW_WIDTH/2);
		graphicsPanel.setBounds(0, 75, WINDOW_WIDTH, WINDOW_HEIGHT-200);
		this.add(graphicsPanel);
	}
	
	public void updateBallPosition(int ballPosition) {
		graphicsPanel.setBallPosition(ballPosition);
		graphicsPanel.update(graphicsPanel.getGraphics());
	}
	
	
	public void state_Begin() {
		
		centerButton.setText("Walk Forward");
		centerButton.removeActionListener(centerButton.getActionListeners()[0]); 
		centerButton.addActionListener((ActionEvent e) -> {
			application.walkForward();
		});
		
		rightButton.setText("Flee");
		rightButton.removeActionListener(rightButton.getActionListeners()[0]); 
		rightButton.addActionListener((ActionEvent e) -> {
			application.attemptFlee();
		});
		
		leftButton.setText("Shoot");
		leftButton.removeActionListener(leftButton.getActionListeners()[0]); 
		leftButton.addActionListener((ActionEvent e) -> {
			application.playerCombat();
		});
		
		state_Traveling();
	}
	
	public void state_Traveling() {

		
		centerButton.setVisible(true);
		rightButton.setVisible(false);
		leftButton.setVisible(false);
		topButton.setVisible(false);
		
		graphicsPanel.setBall2Visibility(false);
	}
	
	public void state_Battling() {
		centerButton.setVisible(false);
		rightButton.setVisible(true);
		leftButton.setVisible(true);
		topButton.setVisible(false);
		
		graphicsPanel.setBall2Visibility(true);
	}
	
	public void state_Waiting() {

		
		centerButton.setVisible(false);
		rightButton.setVisible(false);
		leftButton.setVisible(false);
		topButton.setVisible(true);
		
	}
	
	public void state_Ending() {
		centerButton.setVisible(true);
		rightButton.setVisible(false);
		leftButton.setVisible(false);
		topButton.setVisible(false);
		
		centerButton.setText("New Game");
		centerButton.removeActionListener(centerButton.getActionListeners()[0]); 
		centerButton.addActionListener((ActionEvent e) -> {
			application.startNewGame();
		});
	}
	
	public void setStatus(String status) {
		statusLabel.setText(status);
	}
	
	public void addApplication(Application application) {
		this.application = application;
	}
	
}
