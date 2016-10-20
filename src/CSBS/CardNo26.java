package CSBS;

/* Note: need to modify
 * 
 * card26 name: Loud Buzzing
 * Play in EAT room
 * pre: craft 3
 * get 1 chip of choice
 * fail: -2 QP
 */
public class CardNo26 extends Card{
	
	public CardNo26(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,3,0);
		rewards = " 1 chip of choice ";
		 Learning  = 0;
		 Craft = 3;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				Tryframe.popDialogForChipSelecting(aPlayer,true,true,true);
			else
				aPlayer.AddQualityPoint(-2);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}