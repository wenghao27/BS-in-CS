package CSBS;
import java.util.ArrayList;

/*
 * This is the Player Class. Which contain all of the player information for example the Point player get,
 * Location of the player. For the card, Player will only save the array of the Card ID. This make the system
 * use less memory for saving the card. Using the Deck list can avoid regenerate the card mistake.
 * 
 */
public class Player {
	protected int ID;	                         //This is the ID for the player.  
	protected int RoomID;                      //The room Player in 
	protected int Learning;                    //The Learning point the Player get
	protected int Craft;                       //The Craft point the Player get
	protected int Integrity;                   //The Integrity point the Player get
	private int TotalQualityPoint;           //The Total Quality Point the Player get
	private int bonus;
	protected ArrayList<Card> Cardlist;
	private String Name;

	
	
	public Player(String name,int learn,int cra, int inte, int id){
        Learning = learn;                    //Since all of the player have different point, so it get from the main
        Craft = cra;
        Integrity = inte;
        RoomID = 17;                         //Player start in room 17 which is ECS 308
        ID = id;
        bonus = 0;
        Cardlist = new ArrayList<Card>();
        Name = name;
	}
	/*updates points of a player*/
	public void AddLearning(int learn){
		Learning += learn;
	}	
	public void AddCraft(int cra){
		Craft += cra;
	}
	public void AddIntegrity(int Inte){
		Integrity += Inte;
	}	
	public void AddQualityPoint(int QP){
		TotalQualityPoint += QP;
		if (TotalQualityPoint < 0)				//This change the Quality Point to 0 when it is negative
			 TotalQualityPoint = 0;
	}
	
	public void AddCard(Card card){
		Cardlist.add(card);
	}
	
	public boolean checkBonusPoint(){			//If the QP can divide by 15 is greater than the bonus point
		return TotalQualityPoint / 15 > bonus;  //Player get, Player can get one extra point.
	}
	
	public void changebonusPoint(){
		bonus ++ ;
	}
	
	public void discard(Card card){
		for (int i = 0; i < Cardlist.size(); i ++){
			if(Cardlist.get(i) == card)
				Cardlist.remove(i);
		}
	}
	
	public void changeRoom(int room){
		RoomID = room;
	}
	
	public int getID(){
		return ID;
	}
	
	public int getRoomID(){
		return RoomID;
	}
	
	public int getTotalQualityPoint(){
		return TotalQualityPoint;
	}
	
	public int getLearning(){
		return Learning;
	}
	
	public int getCraft(){
		return Craft;
	}
	
	public int getIntegrity(){
		return Integrity;
	}
	
	public Card[] getCardlist(){
		Card[] templist = new Card[Cardlist.size()];
		for(int i = 0; i < Cardlist.size();i++)
			templist[i] = Cardlist.get(i);
		return templist;
	}
	public ArrayList<Card> getCardlist1() {
		return Cardlist;
	}
	
	public void removeCard(Card card){
		Cardlist.remove(card);
	}
	
	public void removeAllCard(){
		Cardlist.clear();
	}
	
	
	public String toString(){
		return Name;
	}

	public String getName() {
		return Name;
		
		
	}

	
}
