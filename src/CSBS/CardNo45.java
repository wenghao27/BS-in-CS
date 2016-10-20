package CSBS;

/* 
 * 
 * card44 name: CECS 274
 * Play in  ECS 302
 * prerequisites: 5 craft
 * get 5 QP
 * fail:  -3QP
 */
public class CardNo45 extends Card{
	
	public CardNo45(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,5,0);
		rewards = " 5 QP";
		 Learning  = 0;
		 Craft = 5;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddQualityPoint(5);
				
			}
			else
				aPlayer.AddQualityPoint(-3);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}