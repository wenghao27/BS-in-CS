package CSBS;

/* 
 * note need to modify
 * 
 * card24 name: a new laptop
 * Play in computer Lab
 * pre: integrity 4
 * get 3 QP, 1 skill chip(need to choose from 3 skills)
 * fail: discard one card
 */
public class CardNo24 extends Card{
	
	public CardNo24(String name, String imagePath, int[] newValidRoomsID) {
		super(name, imagePath, newValidRoomsID,0,0,4);
		rewards = " 3 QP and 1 skill chip ";
		 Learning  = 0;
		 Craft = 0;	
		 Integrity = 4;
		 
	}

	@Override
	//check room first, and then check prerequisite
	public void playCard(Player aPlayer) {
		if(checkForValidRoom(aPlayer)){   
			if(checkForPre(aPlayer, Learning, Craft, Integrity)) {
				aPlayer.AddQualityPoint(3);
				Tryframe.popDialogForChipSelecting(aPlayer,true,true,true);
			}
			else
				CSBS.Tryframe.discardCard(aPlayer,cardName);
		}
		else
			aPlayer.AddQualityPoint(LOST_TWO_QP);	
	}
}