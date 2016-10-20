package CSBS;

/* Note: need to modify
 * 
 * card1 name: late for class
 * Play in  any space outside Forbidden parking
 * get 1 craft chip and teleport to Lactation Lounge
 */
public class CardNo13 extends Card{
	
	public CardNo13(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,0);
		rewards = "1 chip of craft and teleport to Lactation Lounge";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddCraft(1);
				//teleport to Lactation Lounge
				aPlayer.changeRoom(20);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}