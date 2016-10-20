package CSBS;

/* 
 * 
 * card29 name: press the right floor
 * Play in elevator
 * pre: learning 4
 * get 2 craft
 * fail: -2 QP
 */
public class CardNo29 extends Card{
	
	public CardNo29(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,4,0,0);
		rewards = " 2 craft ";
		 Learning  = 4;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddCraft(2);
			else
				aPlayer.AddQualityPoint(-2);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}