package CSBS;

/* 
 * 
 * card19 name: Choosing a Major
 * Play in CECS conference
 * pre: integrity 3
 * get 5 QP
 * fail: -3 QP
 */
public class CardNo19 extends Card{
	
	public CardNo19(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,3);
		 rewards = "5 QP";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 3;
		 
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