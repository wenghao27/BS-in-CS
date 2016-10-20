package CSBS;

/* note: need to modify
 * 
 * card22 name: fall in the pond
 * Play in Japanese Garden
 * pre: learning 3
 * get 1 Integrity and 1 Craft
 * fail: go to Lactation Lounge
 */
public class CardNo22 extends Card{
	
	public CardNo22(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,3,0,0);
		rewards = "1 Integrity and 1 Craft ";
		 Learning  = 3;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)) {
				aPlayer.AddCraft(1);
				aPlayer.AddIntegrity(1);
			}
				
			else
				aPlayer.changeRoom(20);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}