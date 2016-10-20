package CSBS;

/* Note: need to modify
 * 
 * card23 name: Make the Dean's List
 * Play in North or South Halls
 * pre: learning 6
 * get 5 QP
 * fail: go to Student Parking
 */
public class CardNo23 extends Card{
	
	public CardNo23(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,6,0,0);
		rewards = "5 QP ";
		 Learning  = 6;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddQualityPoint(5);
			else
				aPlayer.changeRoom(2);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}