package edu.cpp.cs.cs141.prog_assgmnt_2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {
	
	private int delimiterCount;
	private int ballRadius;
	private int ballPosition;
	private int lineLength;
	private int linePosition;
	private int delimiterLength;
	
	public GraphicsPanel(int delimiterCount, int ballRadius, int ballPosition, int lineLength, int linePosition) {
		this.delimiterCount = delimiterCount;
		this.ballRadius = ballRadius;
		this.ballPosition = ballPosition;
		this.lineLength = lineLength;
		this.linePosition = linePosition;
		
		delimiterLength = lineLength / delimiterCount;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(4));
		g2.drawLine(linePosition, -25, linePosition, lineLength);
		
		for (int i = 0; i <= delimiterCount; i++) {
			g2.fillOval(linePosition - 5, delimiterLength * i, 10, 10);
		}
		g2.setColor(Color.GREEN);
		g2.fillRect(linePosition-20, -10, 40, 40);
		
		g2.setColor(Color.BLUE);
		g2.fillOval(linePosition - ballRadius/2, lineLength - (delimiterLength * ballPosition) - ballRadius/2, ballRadius, ballRadius);
	}
	
	public void setDelimiterCount(int delimiterCount) {
		this.delimiterCount = delimiterCount;
	}
	
	public void setBallRadius(int ballRadius) {
		this.ballRadius = ballRadius;
	}
	
	public void setBallPosition(int ballPosition) {
		this.ballPosition = ballPosition;
	}
	
	
}
