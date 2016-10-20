package CSBS;

/* 
 * 
 * card43 name: CECS 201
 * Play in  ECS 308
 * prerequisites:  6 learning
 * get 5 Qp
 * fail:  -4QP
 */
public class CardNo43 extends Card{
	
	public CardNo43(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,6,0,0);
		rewards = " 5 QP";
		 Learning  = 6;
		 Craft = 0;	
		 Integrity = 0;
		 
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