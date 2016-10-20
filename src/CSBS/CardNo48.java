package CSBS;

/* 
 * 
 * card48 name: CECS 285
 * Play in  computer lab
 * prerequisites:  4 learning, 4 integrity
 * get 3 learning
 * fail:  -4QP
 */
public class CardNo48 extends Card{
	
	public CardNo48(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,4,0,4);
		rewards = " 3 learning";
		 Learning  = 4;
		 Craft = 0;	
		 Integrity = 4;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddLearning(4);
				
			}
			else
				aPlayer.AddQualityPoint(-4);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}