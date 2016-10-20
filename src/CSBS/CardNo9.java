package CSBS;

/* 
 * 
 * card1 name: finding the lab
 * Play in  elevator
 * get 1 integrity chip
 */
public class CardNo9 extends Card{
	
	public CardNo9(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		rewards = " 1 integrity chip";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddIntegrity(1);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}