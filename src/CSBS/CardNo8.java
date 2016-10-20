package CSBS;

/* 
 * 
 * card1 name: Parking vialation
 * Play in  Forbidden parking
 * get 1 learning chip, discard 1 card to get one more learning chip
 */
public class CardNo8 extends Card{
	
	public CardNo8(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		rewards = " 1 learning chip";
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
				CSBS.Tryframe.discardCard(aPlayer,cardName);
				aPlayer.AddLearning(1);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}