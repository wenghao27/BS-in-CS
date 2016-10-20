package CSBS;

/* Need to edit later, because player need to make choice
 * 
 * card1 name: Math 122
 * Play in Library
 * get 1 learning chip or 1 Integrity chip  Note: player has to make his choice
 */

public class CardNo3 extends Card{
	
	public CardNo3(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		 rewards = "1 skill chip of choice";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				Tryframe.popDialogForChipSelecting(aPlayer,true,false,true);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}