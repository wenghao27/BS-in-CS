package CSBS;

/* Need to edit later, because player need to make choice
 * 
 * card1 name: Enjoying the Peace
 * Play in Japanese Garden
 * get 1 learning chip or 1 Integrity chip  Note: player has to make his choice
 */

public class CardNo11 extends Card{
	
	public CardNo11(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		
		rewards = "1 chip of choice";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				//prompt user to make a choice
				Tryframe.popDialogForChipSelecting(aPlayer,true,false,true); 
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}