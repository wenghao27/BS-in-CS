package CSBS;

/* 
 * 
 * card1 name: professor Murgolo's CECS 174 class
 * Play in ECS302
 * get 1 learning chip
 */
public class CardNo4 extends Card{
	
	public CardNo4(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		rewards = "1 learning chip";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddLearning(1);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}