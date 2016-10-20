package CSBS;

/* 
 * 
 * card41 name: a good day
 * Play in  library
 * get 2 learning and 1 game card
 * fail:  lose 1 card
 */
public class CardNo41 extends Card{
	
	public CardNo41(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,5);
		rewards = "2 learing and 1 game card";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 5;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddLearning(2);
				CSBS.Tryframe.DrawCard(aPlayer);
			}
			else
				CSBS.Tryframe.discardCard(aPlayer,cardName);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}