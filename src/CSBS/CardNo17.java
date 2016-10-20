package CSBS;

/* Note: need to modify
 * 
 * card17 name: Math 123
 * Play in  ECS 302 or 308
 * pre: 5 learning
 * get 5 QP
 * Fail: -3 QP, -1 card
 */
public class CardNo17 extends Card{
	
	public CardNo17(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,5,0,0);
		rewards = " 5 QP ";
		 Learning  = 5;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddQualityPoint(5);
			else {
				aPlayer.AddQualityPoint(-3);
				CSBS.Tryframe.discardCard(aPlayer,cardName);
			}
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}