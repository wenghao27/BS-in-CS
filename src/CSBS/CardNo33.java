package CSBS;

/* need to modify
 * 
 * card33 name: Professor Hoffman
 * Play in any room in ECS except Lactation lounge
 * pre: learning 3
 * get 5 QP and 2 card
 * fail: -5 QP and  go toLactation lounge
 */
public class CardNo33 extends Card{
	
	public CardNo33(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,3,0,0);
		rewards = "5 QP and 2 card";
		 Learning  = 3;
		 Craft = 0;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddQualityPoint(5);
				CSBS.Tryframe.DrawCard(aPlayer);
				CSBS.Tryframe.DrawCard(aPlayer);
				//get two cards
			}
			else {
				aPlayer.AddQualityPoint(-5);
				aPlayer.changeRoom(20);//go toLactation lounge
			}
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}