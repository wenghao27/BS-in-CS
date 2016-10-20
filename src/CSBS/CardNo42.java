package CSBS;

/* 
 * 
 * card42 name: a soccer game
 * Play in  George allen field
 * get 2 craft and 1 integrity
 * fail:  lose 1 card
 */
public class CardNo42 extends Card{
	
	public CardNo42(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,5,0);
		rewards = " 2 craft and 1 integrity";
		 Learning  = 0;
		 Craft = 5;	
		 Integrity = 0;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)){
				aPlayer.AddIntegrity(1);
				aPlayer.AddCraft(2);
				
			}
			else
				CSBS.Tryframe.discardCard(aPlayer,cardName);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}