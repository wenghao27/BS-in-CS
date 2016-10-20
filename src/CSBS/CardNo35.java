package CSBS;

/* need to modify
 * 
 * card35 name: The OUtpost
 * Play in  any space outside ECS except Forbidden parking
 * get 1 chip of choice
 * 
 */
public class CardNo35 extends Card{
	
	public CardNo35(String name, String imagePath, int[] newValidRoomsID) {
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
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				Tryframe.popDialogForChipSelecting(aPlayer,true,true,true);
			}

		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}