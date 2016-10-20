package CSBS;

/* 
 * 
 * card1 name: Goodbye Professor
 * Play in  room of retirement
 * Pre learning 6, craft 6, integrity 6
 * get 10 QP. 
 * fail: lose 1 card and leave in RoR( what is RoR?)
 */
public class CardNo10 extends Card{
	
	public CardNo10(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,6,6,6);
		
		rewards = "10 integrity chip";
		 Learning  = 6;
		 Craft = 6;	
		 Integrity = 6;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity))
				aPlayer.AddQualityPoint(10);
			else
				CSBS.Tryframe.discardCard(aPlayer,cardName);//aPlayer.discardCard();// function not implemented yet
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}