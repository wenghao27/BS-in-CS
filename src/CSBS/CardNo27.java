package CSBS;

/* need to modify
 * 
 * card27 name: program Crashes
 * Play in Lactation Lounge
 * pre: learning 2
 * get 5 QP  and  1 chip of choice
 * fail: discard 1 card
 */
public class CardNo27 extends Card{
	
	public CardNo27(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,2,0,0);
		
		rewards = " 5 QP and 1 chip of choice";
		 Learning  = 2;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)) {
				aPlayer.AddQualityPoint(5);
				Tryframe.popDialogForChipSelecting(aPlayer,true,true,true);
			}
			else
				CSBS.Tryframe.discardCard(aPlayer,cardName);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}