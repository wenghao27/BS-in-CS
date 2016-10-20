package CSBS;

/* note: need to modify
 * 
 * card21 name: Score a Goal
 * Play in Geoge Allen Field
 * pre: Craft 3
 * get 5 QP, 1 Integrity chip
 * fail: go to student parking
 */
public class CardNo21 extends Card{
	
	public CardNo21(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,3,0);
		rewards = "5 QP and 1 Integrity chip ";
		 Learning  = 0;
		 Craft = 3;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddQualityPoint(5);
				aPlayer.AddIntegrity(1);
			}
			else
				aPlayer.changeRoom(2);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}