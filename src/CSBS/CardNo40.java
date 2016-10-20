package CSBS;

/* 
 * 
 * card40 name: a bad day
 * Play in  forbidden parking
 * get 2 integrity
 * fail:  -3 QP
 */
public class CardNo40 extends Card{
	
	public CardNo40(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,6,0);
		rewards = "2 integrity";
		 Learning  = 0;
		 Craft = 6;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddIntegrity(2);
			else
				aPlayer.AddQualityPoint(-3);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}