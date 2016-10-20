package CSBS;

/* need to modify
 * 
 * card31 name: Elective Class
 * Play in library
 * pre: learning 2
 * get 1 learning, 1 card
 * fail: - 2 QP
 */
public class CardNo31 extends Card{
	
	public CardNo31(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,2,0,0);
		rewards = "1 learning, 1 card";
		 Learning  = 2;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddLearning(1);
				CSBS.Tryframe.DrawCard(aPlayer);
			}
			else
				aPlayer.AddQualityPoint(-2);	
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}