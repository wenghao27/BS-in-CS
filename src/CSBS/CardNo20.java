package CSBS;

/* 
 * 
 * card20 name: Pass Soccer Class
 * Play in George Allen Field
 * pre: Craft 5
 * get 5 QP
 * fail: -3 QP
 */
public class CardNo20 extends Card{
	
	public CardNo20(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		rewards = "5 QP";
		 Learning  = 0;
		 Craft = 5;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddQualityPoint(5);
			else
				aPlayer.AddQualityPoint(-3);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}