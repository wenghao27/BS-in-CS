package CSBS;

/* need to modify
 * 
 * card32 name: Oral communication
 * Play in any building not Ecs
 * pre: integrity 4
 * get 4QP and 1 chip of choice
 * fail: discard one card
 */
public class CardNo32 extends Card{
	
	public CardNo32(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,4);
		rewards = "4QP and 1 chip of choice";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 4;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddQualityPoint(4);	
				Tryframe.popDialogForChipSelecting(aPlayer,true,true,true);
			}
				
			else
				CSBS.Tryframe.discardCard(aPlayer,cardName);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}