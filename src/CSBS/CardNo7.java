package CSBS;

/* 
 * 
 * card1 name: Exercising mind and body
 * Play in  Student Recreation
 * get 1 integrity chip
 */
public class CardNo7 extends Card{
	
	public CardNo7(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		rewards = "1 integrity chip";
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