package CSBS;

/* 
 * 
 * card1 name: CECS 100
 * Play in  CECS308
 * get 1 craft chip
 */
public class CardNo6 extends Card{
	
	public CardNo6(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		rewards = "1 craft chip";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddCraft(1);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}