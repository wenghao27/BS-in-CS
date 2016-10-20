package CSBS;

/* 
 * 
 * card39 name: Student Parking
 * Play in student Parking
 * get 1 craft, go to Lactation Lounge
 */
public class CardNo39 extends Card{
	
	public CardNo39(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		rewards = "1 craft and go to Lactation Lounge";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)) {
				aPlayer.AddCraft(1);
				aPlayer.changeRoom(20);// go to Lactation Lounge
			}
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}