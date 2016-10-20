package CSBS;

/* 
 * 
 * card18 name: learning netbeans
 * Play in Lactation Lounge
 * pre: learning 3
 * get 5 QP
 * fail: -3 QP
 */
public class CardNo18 extends Card{
	
	public CardNo18(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,3,0,0);
		 rewards =" 5 QP ";
		 Learning  = 3;
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
				aPlayer.AddQualityPoint(-3);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}