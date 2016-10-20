package CSBS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TryImageLabel extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private GameState gameState;
	
	
	public TryImageLabel( GameState gameState) {
		
		try {
			this.image = ImageIO.read(new File("src/CSBS/CSULBMap3.png"));
		}
		catch(IOException e) {
			System.out.println("not found");
		}
		this.gameState = gameState;
	}
	
	/*
	 * There are a number of factors that determine when a component needs to be re-painted, ranging from moving, 
	 * re-sizing, changing focus, being hidden by other frames, and so on and so forth. Many of these events are 
	 * detected auto-magically, and paintComponent is called internally when it is determined that that operation is necessary.
	 * 
	 * */
	  @Override
	    public void paintComponent(Graphics g) {
	    	
	        
	        super.paintComponent(g);
	        
	        g.setColor(Color.RED);
	        g.setFont(getFont().deriveFont(25.0f));
	        g.drawImage(image, 0, 0, null);

	        
	        
	        
	        g.drawString(gameState.getHumanPlayer().getName(), 
	        		gameState.getRoom(gameState.getHumanPlayer().getRoomID()).getLocation().x,
	        		gameState.getRoom(gameState.getHumanPlayer().getRoomID()).getLocation().y +
	        		gameState.getHumanPlayer().getID() * 30);
	         
	        
	        g.drawString(gameState.getAIPlayer1().getName(), 
	        		gameState.getRoom(gameState.getAIPlayer1().getRoomID()).getLocation().x,
	        		gameState.getRoom(gameState.getAIPlayer1().getRoomID()).getLocation().y+
	        		gameState.getAIPlayer1().getID() * 30);
	        g.drawString(gameState.getAIPlayer2().getName(), 
	        		gameState.getRoom(gameState.getAIPlayer2().getRoomID()).getLocation().x,
	        		gameState.getRoom(gameState.getAIPlayer2().getRoomID()).getLocation().y+
	        		gameState.getAIPlayer2().getID() * 30);
	        		
	        		
	    
	    }
	  
	  public Dimension getPreferredSize() {
	        return  new Dimension(1670, 2000);
	    }

}
