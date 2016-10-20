package CSBS;

/* 
 * 
 * card44 name: PHil 270
 * Play in  EAT club
 * prerequisites:  6 integrity
 * get 5 QP
 * fail:  -5QP
 */
public class CardNo50 extends Card{
	
	public CardNo50(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,6);
		rewards = " 5 QP";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 6;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddQualityPoint(5);
				
			}
			else
				aPlayer.AddQualityPoint(-5);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}