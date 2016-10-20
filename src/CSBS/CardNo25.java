package CSBS;

/* note: need to modify
 * 
 * card25 name: Meet the Dean
 * Play in North or South Hall
 * pre: learning 3, craft 3, integrity 3
 * get 5 QP, gain one card
 * fail: -1 card
 */
public class CardNo25 extends Card{
	
	public CardNo25(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,3,3,3);
		rewards = " 5 QP and 1 card ";
		 Learning  = 3;
		 Craft = 3;	
		 Integrity = 3;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)) {
				aPlayer.AddQualityPoint(5);
				//aPlayer.AddCard();
				Tryframe.DrawCard(aPlayer);
			}
			else
				CSBS.Tryframe.discardCard(aPlayer,cardName);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}