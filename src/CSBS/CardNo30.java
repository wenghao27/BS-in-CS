package CSBS;

/* need to modify
 * 
 * card30 name: Soccer Goalie
 * Play in George Allen Field
 * pre: learning 3, craft 3
 * get 5 QP and 1 card
 * fail: go to Student Parking
 */
public class CardNo30 extends Card{
	
	public CardNo30(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,3,3,0);
		 rewards = "5 QP and 1 card";
		 Learning  = 3;
		 Craft = 3;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddQualityPoint(5);
				CSBS.Tryframe.DrawCard(aPlayer);
			}
			else
				aPlayer.changeRoom(2);;//go to student Parking
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}