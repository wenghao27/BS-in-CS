package CSBS;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/*
 *  Abstract class card.
 *  Any class extend it must implement playCard method.
 *  Every card would have a name, 
 */

public abstract class Card {
		
	protected String cardName;
	private String Prerequirement;	//not sure if it is useful
	protected int Learning, Craft, Integrity; 
	protected static final int LOST_TWO_QP = -2;		//penalty for incorrect room
	private int[] validRoomsID;  //a card may have more than one valid room to play
	private ImageIcon Image;
	protected String rewards;
	
	
	public Card(String name, String imagePath, int[] newValidRoomsID, int learning, int craft, int integrity){
		this.Learning = learning;
		this.Craft = craft;
		this.Integrity = integrity;
		this.cardName = name;
		this.Image = new ImageIcon(imagePath);
		this.validRoomsID = newValidRoomsID;
		//System.arraycopy(newValidRoomsID, 0, validRoomsID, 0, newValidRoomsID.length);
	}
	
	public String getRewards() {
		return rewards;
	}
	
	//abstract method
	public abstract void playCard(Player aPlayer);
	
	public boolean checkSuccess(Player aPlayer){
		return checkForValidRoom(aPlayer) && checkForPre(aPlayer,Learning,Craft,Integrity);
	}
	
	//check if player in correct room
	public boolean checkForValidRoom(Player aPlayer) {
		for(int i : validRoomsID) {
			if(aPlayer.getRoomID() == i)  
				return true;
		}	
		return false;
	}
	// check if player prerequisite
	public boolean checkForPre(Player aPlayer, int learning, int craft, int integrity) {
		return (aPlayer.getLearning() >= learning &&
				aPlayer.getCraft() >= craft &&
				aPlayer.getIntegrity() >= integrity);
	}
	
	
	public String toString() {
		return cardName;
	}

	
	public ImageIcon getImage(){
		return Image;
	}
	
	public String getPrerequirment(){
		return Prerequirement;
	}
	
	public int getLearning(){
		return Learning;
	}
	
	public int getCraft(){
		return Craft;
	}
	
	public int getIntegrity(){
		return Integrity;
	}
	

}