package CSBS;

/* need to modify
 * 
 * card37 name:make a friend
 * Play in elevator
 * pre: integrity 2
 * get 3 QP and 1 chip of choice
 * fail: -1 Card
 */
public class CardNo37 extends Card{
	
	public CardNo37(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,2);
		rewards = "3 QP and 1 chip of choice";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 2;
		 
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
				CSBS.Tryframe.discardCard(aPlayer,cardName);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}