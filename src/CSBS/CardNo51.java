package CSBS;

/* 
 * 
 * card44 name: Phis 152
 * Play in  computer lab
 * prerequisites:  3 learning, 4 integrity
 * get 5 QP
 * fail:  -4QP
 */
public class CardNo51 extends Card{
	
	public CardNo51(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,3,0,4);
		rewards = " 5 QP";
		 Learning  = 3;
		 Craft = 0;	
		 Integrity = 4;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddQualityPoint(5);
				
			}
			else
				aPlayer.AddQualityPoint(-4);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}