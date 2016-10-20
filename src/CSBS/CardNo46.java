package CSBS;

/* 
 * 
 * card46 name: CECS 277
 * Play in  computer lab
 * prerequisites: 7 learning
 * get 3 learning
 * fail:  -4QP
 */
public class CardNo46 extends Card{
	
	public CardNo46(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,7,0,0);
		rewards = " 3 learning";
		 Learning  = 7;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddLearning(3);
			}
			else
				aPlayer.AddQualityPoint(-4);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}