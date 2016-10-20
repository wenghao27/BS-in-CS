package CSBS;

/* 
 * 
 * card1 name: Physics 151
 * Play in  ECS 308
 * get 5 QP
 * fail:  -3 QP
 */
public class CardNo14 extends Card{
	
	public CardNo14(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,3,0);
		rewards = "5 QP";
		 Learning  = 0;
		 Craft = 3;	
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