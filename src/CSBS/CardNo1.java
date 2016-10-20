   package CSBS;

/* card1 name: CECS 105
 * Play in ECS 302 or 308
 * get 1 learning chip
 */

public class CardNo1 extends Card{
	
	public CardNo1(String name, String imagePath, int[] newValidRoomsID) {
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
			//pass arguments of Player and card's prerequisites
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddLearning(1);
				//CSBS.Tryframe.DrawCard(aPlayer);
			}
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);// -2 QP for incorrect room
	}
}
