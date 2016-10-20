package CSBS;

/* need to modify
 * 
 * card36 name: Learning Linux
 * Play in Computer Lab
 * pre: integrity 3, craft 2
 * get 3 QP and 1 chip of choice
 * fail: -1 QP
 */
public class CardNo36 extends Card{
	
	public CardNo36(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,3,3);
		rewards = "3 QP and 1 chip of choice";
		 Learning  = 0;
		 Craft = 3;	
		 Integrity = 3;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddQualityPoint(3);
				Tryframe.popDialogForChipSelecting(aPlayer,true,true,true);
			}
			else
				aPlayer.AddQualityPoint(-1);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}