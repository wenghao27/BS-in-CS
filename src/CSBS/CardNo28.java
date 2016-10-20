package CSBS;

/* need to modify
 * 
 * card28 name: professor Englert
 * Play in CECS conference
 * pre: integrity 3
 * get 1 chip of choice
 * fail: discard one card
 */
public class CardNo28 extends Card{
	
	public CardNo28(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,3);
		rewards = "1 chip of choice";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 3;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				Tryframe.popDialogForChipSelecting(aPlayer,true,true,true);
			else
				CSBS.Tryframe.discardCard(aPlayer,cardName);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}