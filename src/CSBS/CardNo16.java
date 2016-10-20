package CSBS;

/* Note: need to modify
 * 
 * card1 name: KIN 253
 * Play in  George Allen Field
 * pre: integrity 4,
 * get 2 craft chip 
 * fail: go to room of retirement
 */
public class CardNo16 extends Card{
	
	public CardNo16(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,4);
		rewards = "2 craft chip ";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 4;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddCraft(2);
			else
				aPlayer.changeRoom(13);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}