package CSBS;
/*
 * This class stores all the data needed for the initial state of the game
 */




import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class GameState {
	private int times;				//This is the value for counting the number time player move
	private Player humanPlayer;
	private AI AIPlayer1;
	private AI AIPlayer2;
	private Room[] Roomlist;
	private ArrayList<Card> freshmentCards;
	private ArrayList<Card> usedCards; //cards been used put in this deck
	
	public GameState() {

		//initialize rooms on the board
		GenerateRoom();
		times = 0;
		
		//initialize players on the board
		//(name, learn, craft, integrity, playerId)
		
		Random r = new Random();
		if (r.nextInt()%3 == 0){
			humanPlayer = new Player("player1",2,2,2,1);
			
			if(r.nextInt() %2 == 0){
				AIPlayer1 = new AI("player2", 3,1,2,2);
				AIPlayer2 = new AI("player3", 0,3,3,3);
			}
			else{
				AIPlayer1 = new AI("player2", 0,3,3,2);
				AIPlayer2 = new AI("player3", 3,1,2,3);
			}
		}
		else if(r.nextInt()%3 == 1){
			humanPlayer = new Player("player1",3,1,2,1);
			if(r.nextInt() %2 == 0){
				AIPlayer1 = new AI("player2", 2,2,2,2);
				AIPlayer2 = new AI("player3", 0,3,3,3);
			}
			else{
				AIPlayer1 = new AI("player2", 0,3,3,2);
				AIPlayer2 = new AI("player3", 2,2,2,3);
			}
		}
		else{
			humanPlayer = new Player("player1",0,3,3,1);
			if(r.nextInt() %2 == 0){
				AIPlayer1 = new AI("player2", 3,1,2,2);
				AIPlayer2 = new AI("player3", 2,2,2,3);
			}
			else{
				AIPlayer1 = new AI("player2", 2,2,2,2);
				AIPlayer2 = new AI("player3", 3,1,2,3);
			}
		}
		humanPlayer.AddQualityPoint(21);
		AIPlayer1.AddQualityPoint(19);
		AIPlayer2.AddQualityPoint(19);
		freshmentCards = new ArrayList<Card>();
		usedCards = new ArrayList<Card>();
		
		//initialize FreshementDeck
		//need to implement shuffle function to shuffle the deck, implement later...
		generateCardLists();
		
		ShuffleArray(freshmentCards);
		//each players get 5 cards at the beginning of the game
		for(int i = 0; i < 5; i++){
			humanPlayer.AddCard(getFirstCard());
			AIPlayer1.AddCard(getFirstCard());
			AIPlayer2.AddCard(getFirstCard());
		}
	}
	
public void generateCardLists() {
		
		//valid roomID to play for each card
		int[] CardNo1ValidRoomID = {14, 17};
		int[] CardNo2ValidRoomID = {7};
		int[] CardNo3ValidRoomID = {7};
		int[] CardNo4ValidRoomID = {14};
		int[] CardNo5ValidRoomID = {9};
		int[] CardNo6ValidRoomID = {17};
		int[] CardNo7ValidRoomID = {5};
		int[] CardNo8ValidRoomID = {6};
		int[] CardNo9ValidRoomID = {16};
		int[] CardNo10ValidRoomID = {13};
		int[] CardNo11ValidRoomID = {1};
		int[] CardNo12ValidRoomID = {18, 0};
		int[] CardNo13ValidRoomID = {0, 1, 2, 3, 4, 5, 7, 8, 9, 10};
		int[] CardNo14ValidRoomID = {17};
		int[] CardNo15ValidRoomID = {3};
		int[] CardNo16ValidRoomID = {0};
		int[] CardNo17ValidRoomID = {14, 17};
		int[] CardNo18ValidRoomID = {20};
		int[] CardNo19ValidRoomID = {19};
		int[] CardNo20ValidRoomID = {0};
		int[] CardNo21ValidRoomID = {0};
		int[] CardNo22ValidRoomID = {1};
		int[] CardNo23ValidRoomID = {12, 15};
		int[] CardNo24ValidRoomID = {11};
		int[] CardNo25ValidRoomID = {12, 15};
		int[] CardNo26ValidRoomID = {18};
		int[] CardNo27ValidRoomID = {20};
		int[] CardNo28ValidRoomID = {19};
		int[] CardNo29ValidRoomID = {16};
		int[] CardNo30ValidRoomID = {0};
		int[] CardNo31ValidRoomID = {7};
		int[] CardNo32ValidRoomID = {3, 2, 5, 7, 8, 9};
		int[] CardNo33ValidRoomID = {11, 12, 13, 14, 15, 16, 17, 18, 19};
		int[] CardNo34ValidRoomID = {2, 5, 7, 8, 9};
		int[] CardNo35ValidRoomID = {1, 2, 3, 4, 5, 7, 8, 9, 10};
		int[] CardNo36ValidRoomID = {11};
		int[] CardNo37ValidRoomID = {12, 15};
		int[] CardNo38ValidRoomID = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] CardNo39ValidRoomID = {2};
		
		//card names from card1 to card 39
		String[] cardNames = {"CECS 105", "Research Compilers", "Math 122", "Professor Murgolo's CECS 174 Class",
				"Lunch at Brawtwurst Hall", "CECS 100", "Exercising Mind and Body", "Parking Violation",
				"Finding the Lab", "Goodbye, Professor", "Enjoying the Peace", "Buddy Up",
				"Late for Class", "Physics 151", "The Big Game", "KIN 253 Learning the Rules of Soccer",
				"Math 123", "Learning Netbeans",  "Choosing a Major", "Pass Soccer Class",
				"Score a Goal!", "Fall in the Pond", "Make the Dean's List", "A New Laptop",
				"Meet the Dean", "Loud Buzzing", "Program Crashes", "Professor Englert",
				"Press the Right Floor", "Soccer Goalie", "Elective Class", "Oral Communication",
				"Professor Hoffman", "CHEM 111", "The Outpost", "Learning Linux",
				"Make a Friend", "Enjoying Nature", "Student Parking"};
		
		
		
		
		//create 39 card objects
		Card CardNo1 = new CardNo1(cardNames[0], "src/cardImages/1.png", CardNo1ValidRoomID);
		Card CardNo2 = new CardNo2(cardNames[1], "src/cardImages/2.png", CardNo2ValidRoomID);
		Card CardNo3 = new CardNo3(cardNames[2], "src/cardImages/3.png", CardNo3ValidRoomID);
		Card CardNo4 = new CardNo4(cardNames[3], "src/cardImages/4.png", CardNo4ValidRoomID);
		Card CardNo5 = new CardNo5(cardNames[4], "src/cardImages/5.png", CardNo5ValidRoomID);
		Card CardNo6 = new CardNo6(cardNames[5], "src/cardImages/6.png", CardNo6ValidRoomID);
		Card CardNo7 = new CardNo7(cardNames[6], "src/cardImages/7.png", CardNo7ValidRoomID);
		Card CardNo8 = new CardNo8(cardNames[7], "src/cardImages/8.png", CardNo8ValidRoomID);
		Card CardNo9 = new CardNo9(cardNames[8], "src/cardImages/9.png", CardNo9ValidRoomID);
		Card CardNo10 = new CardNo10(cardNames[9], "src/cardImages/10.png", CardNo10ValidRoomID);
		Card CardNo11= new CardNo11(cardNames[10], "src/cardImages/11.png", CardNo11ValidRoomID);
		Card CardNo12 = new CardNo12(cardNames[11], "src/cardImages/12.png", CardNo12ValidRoomID);
		Card CardNo13 = new CardNo13(cardNames[12], "src/cardImages/13.png", CardNo13ValidRoomID);
		Card CardNo14 = new CardNo14(cardNames[13], "src/cardImages/14.png", CardNo14ValidRoomID);
		Card CardNo15 = new CardNo15(cardNames[14], "src/cardImages/15.png", CardNo15ValidRoomID);
		Card CardNo16 = new CardNo16(cardNames[15], "src/cardImages/16.png", CardNo16ValidRoomID);
		Card CardNo17 = new CardNo17(cardNames[16], "src/cardImages/17.png", CardNo17ValidRoomID);
		Card CardNo18 = new CardNo18(cardNames[17], "src/cardImages/18.png", CardNo18ValidRoomID);
		Card CardNo19 = new CardNo19(cardNames[18], "src/cardImages/19.png", CardNo19ValidRoomID);
		Card CardNo20 = new CardNo20(cardNames[19], "src/cardImages/20.png", CardNo20ValidRoomID);
		Card CardNo21 = new CardNo21(cardNames[20], "src/cardImages/21.png", CardNo21ValidRoomID);
		Card CardNo22 = new CardNo22(cardNames[21], "src/cardImages/22.png", CardNo22ValidRoomID);
		Card CardNo23 = new CardNo23(cardNames[22], "src/cardImages/23.png", CardNo23ValidRoomID);
		Card CardNo24 = new CardNo24(cardNames[23], "src/cardImages/24.png", CardNo24ValidRoomID);
		Card CardNo25 = new CardNo25(cardNames[24], "src/cardImages/25.png", CardNo25ValidRoomID);
		Card CardNo26 = new CardNo26(cardNames[25], "src/cardImages/26.png", CardNo26ValidRoomID);
		Card CardNo27 = new CardNo27(cardNames[26], "src/cardImages/27.png", CardNo27ValidRoomID);
		Card CardNo28 = new CardNo28(cardNames[27], "src/cardImages/28.png", CardNo28ValidRoomID);
		Card CardNo29 = new CardNo29(cardNames[28], "src/cardImages/29.png", CardNo29ValidRoomID);
		Card CardNo30 = new CardNo30(cardNames[29], "src/cardImages/30.png", CardNo30ValidRoomID);
		Card CardNo31 = new CardNo31(cardNames[30], "src/cardImages/31.png", CardNo31ValidRoomID);
		Card CardNo32 = new CardNo32(cardNames[31], "src/cardImages/32.png", CardNo32ValidRoomID);
		Card CardNo33 = new CardNo33(cardNames[32], "src/cardImages/33.png", CardNo33ValidRoomID);
		Card CardNo34 = new CardNo34(cardNames[33], "src/cardImages/34.png", CardNo34ValidRoomID);
		Card CardNo35 = new CardNo35(cardNames[34], "src/cardImages/35.png", CardNo35ValidRoomID);
		Card CardNo36 = new CardNo36(cardNames[35], "src/cardImages/36.png", CardNo36ValidRoomID);
		Card CardNo37 = new CardNo37(cardNames[36], "src/cardImages/37.png", CardNo37ValidRoomID);
		Card CardNo38 = new CardNo38(cardNames[37], "src/cardImages/38.png", CardNo38ValidRoomID);
		Card CardNo39 = new CardNo39(cardNames[38], "src/cardImages/39.png", CardNo39ValidRoomID);
		
		//add cards to list
		freshmentCards.add(CardNo1);
		freshmentCards.add(CardNo2);
		freshmentCards.add(CardNo3);
		freshmentCards.add(CardNo4);
		freshmentCards.add(CardNo5);
		freshmentCards.add(CardNo6);
		freshmentCards.add(CardNo6);
		freshmentCards.add(CardNo7);
		freshmentCards.add(CardNo8);
		freshmentCards.add(CardNo9);
		freshmentCards.add(CardNo10);
		freshmentCards.add(CardNo11);
		freshmentCards.add(CardNo12);
		freshmentCards.add(CardNo13);
		freshmentCards.add(CardNo14);
		freshmentCards.add(CardNo15);
		freshmentCards.add(CardNo16);
		freshmentCards.add(CardNo17);
		freshmentCards.add(CardNo18);
		freshmentCards.add(CardNo19);
		freshmentCards.add(CardNo20);
		freshmentCards.add(CardNo21);
		freshmentCards.add(CardNo22);
		freshmentCards.add(CardNo23);
		freshmentCards.add(CardNo24);
		freshmentCards.add(CardNo25);
		freshmentCards.add(CardNo26);
		freshmentCards.add(CardNo27);
		freshmentCards.add(CardNo28);
		freshmentCards.add(CardNo29);
		freshmentCards.add(CardNo30);
		freshmentCards.add(CardNo31);
		freshmentCards.add(CardNo32);
		freshmentCards.add(CardNo33);
		freshmentCards.add(CardNo34);
		freshmentCards.add(CardNo35);
		freshmentCards.add(CardNo36);
		freshmentCards.add(CardNo37);
		freshmentCards.add(CardNo38);
		freshmentCards.add(CardNo39);
		//System.out.println(freshmentCards.size());
}

	public void updateNewDeck(){
		usedCards.addAll(freshmentCards);
		usedCards.addAll(humanPlayer.getCardlist1());
		usedCards.addAll(AIPlayer1.getCardlist1());
		usedCards.addAll(AIPlayer2.getCardlist1());
		freshmentCards.clear();
		humanPlayer.removeAllCard();
		AIPlayer1.removeAllCard();
		AIPlayer2.removeAllCard();
		
		
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "CECS 100"){
				usedCards.remove(i);
				i = 0;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "Math 122"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "Professor Murgolo's CECS 174 Class"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "CECS 105"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "Math 123"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "Physics 151"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "KIN 253 Learning the Rules of Soccer"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "Pass Soccer Class"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "Elective Class"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "Oral Communication"){
				usedCards.remove(i);
				break;
			}
		}
		for (int i = 0; i < usedCards.size(); i++){
			if(usedCards.get(i).toString() == "CHEM 111"){
				usedCards.remove(i);
				break;
			}
		}
		/*
		 * This is the adding new card.
		 * */
		int[] CardNo1ValidRoomID = {6};
		int[] CardNo2ValidRoomID = {7};
		int[] CardNo3ValidRoomID = {0};
		int[] CardNo4ValidRoomID = {17};
		int[] CardNo5ValidRoomID = {11};
		int[] CardNo6ValidRoomID = {14};
		int[] CardNo7ValidRoomID = {11};
		int[] CardNo8ValidRoomID = {11};
		int[] CardNo9ValidRoomID = {11};
		int[] CardNo10ValidRoomID = {11};
		int[] CardNo11ValidRoomID = {18};
		int[] CardNo12ValidRoomID = {11};
		String[] cardNames = {"A bad Day", "A good Day", "A scoccer game", "CECS 201","CECS 228",
				"CECS 274", "CECS 277", "CECS 282", "CECS 285", "ENGL 317","PHIL 270", "PHIS 152"};
		Card CardNo1 = new CardNo40(cardNames[0], "src/cardImages/40 A bad day.png", CardNo1ValidRoomID);
		Card CardNo2 = new CardNo41(cardNames[1], "src/cardImages/41 A good day.png", CardNo2ValidRoomID);
		Card CardNo3 = new CardNo42(cardNames[2], "src/cardImages/42 A soccer game.png", CardNo3ValidRoomID);
		Card CardNo4 = new CardNo43(cardNames[3], "src/cardImages/43 CECS 201.png", CardNo4ValidRoomID);
		Card CardNo5 = new CardNo44(cardNames[4], "src/cardImages/44 CECS 228.png", CardNo5ValidRoomID);
		Card CardNo6 = new CardNo45(cardNames[5], "src/cardImages/45 CECS 274.png", CardNo6ValidRoomID);
		Card CardNo7 = new CardNo46(cardNames[6], "src/cardImages/46 CECS 277.png", CardNo7ValidRoomID);
		Card CardNo8 = new CardNo47(cardNames[7], "src/cardImages/47 CECS 282.png", CardNo8ValidRoomID);
		Card CardNo9 = new CardNo48(cardNames[8], "src/cardImages/48 CECS 285.png", CardNo9ValidRoomID);
		Card CardNo10 = new CardNo49(cardNames[9], "src/cardImages/49 ENGL 317.png", CardNo10ValidRoomID);
		Card CardNo11= new CardNo50(cardNames[10], "src/cardImages/50 PHIL 270.png", CardNo11ValidRoomID);
		Card CardNo12 = new CardNo51(cardNames[11], "src/cardImages/51 PHIS 152s.png", CardNo12ValidRoomID);
		
		usedCards.add(CardNo1);
		usedCards.add(CardNo2);
		usedCards.add(CardNo3);
		usedCards.add(CardNo4);
		usedCards.add(CardNo5);
		usedCards.add(CardNo6);
		usedCards.add(CardNo7);
		usedCards.add(CardNo8);
		usedCards.add(CardNo9);
		usedCards.add(CardNo10);
		usedCards.add(CardNo11);
		usedCards.add(CardNo12);
		/*
		 * 
		 */
		for(int i = 0; i < 5; i++){
			humanPlayer.AddCard(getFirstCard());
			AIPlayer1.AddCard(getFirstCard());
			AIPlayer2.AddCard(getFirstCard());
		}
	}


	public ArrayList<Card> getUsedCards(){
		return usedCards;
	}
	
	/*
	 * This function will get the first card on the deck and delete that card. 
	 */
	public Card getFirstCard(){
		if(freshmentCards.isEmpty()){
			freshmentCards.addAll(usedCards);
			usedCards.clear();
			ShuffleArray(freshmentCards);
		}
		Card card = freshmentCards.get(0);
		
		freshmentCards.remove(0);
		return card;
		
	}
	
	public int getNumberofCard(){
		return freshmentCards.size();
	}
	
	public int getNumberofUsedCard(){
		return usedCards.size();
	}
	
	public Player getHumanPlayer(){
		return humanPlayer;	
	}
	public AI getAIPlayer1() {
		return AIPlayer1;
	}
	public AI getAIPlayer2() {
		return AIPlayer2;
	}
	
	public Room getRoom(int roomID){
		return Roomlist[roomID];
	}
	
	public void GenerateRoom(){											//This is the rooom setting.
		
		Roomlist = new Room[21];
		for (int i = 0; i < 21; i++)
			Roomlist[i] = new Room(i);
		Roomlist[0].SetData(new Point(115,80),"George Allen Field");
		Roomlist[1].SetData(new Point(470,45),"Japanese Garden");
		Roomlist[2].SetData(new Point(1000,90),"Student Parking");
		Roomlist[3].SetData(new Point(515,300),"The Pyrimad");
		Roomlist[4].SetData(new Point(45,700),"West WalkWay");
		Roomlist[5].SetData(new Point(480,540),"Health Center");
		Roomlist[6].SetData(new Point(1100,540),"Forbidden Parking");
		Roomlist[7].SetData(new Point(50,1670),"Library");
		Roomlist[8].SetData(new Point(560,1740),"Union");
		Roomlist[9].SetData(new Point(1100,1700),"Bratwurst Hall");
		Roomlist[10].SetData(new Point(1490,1000),"East WalkWay");
		Roomlist[11].SetData(new Point(228,910),"Lab");
		Roomlist[12].SetData(new Point(260,1200),"North Hall");
		Roomlist[13].SetData(new Point(220,1400),"Room of Retirement");
		Roomlist[14].SetData(new Point(660,940),"302");
		Roomlist[15].SetData(new Point(890,1190),"South Hall");
		Roomlist[16].SetData(new Point(630,1360),"Elevators");
		Roomlist[17].SetData(new Point(840,1380),"308");
		Roomlist[18].SetData(new Point(1050,880),"EAT");
		Roomlist[19].SetData(new Point(1250,880),"Conference");
		Roomlist[20].SetData(new Point(1220,1350),"Noisy Room");
	}
	
	
	public int[] getAvailableRoomList(int location){  //This is the Room list which the room can move.
		int [] temp = new int[getAvailableRoom(location)];			//This use to display the room name. 
		switch(location){
		case 0: temp[0] = 1;
		   	    temp[1] = 3;
		   	    temp[2] = 5;
		   	    temp[3] = 4;
		   	    break;
		case 1: temp[0] = 0;
		        temp[1] = 2;
		        temp[2] = 3;
		        break;
		case 2: temp[0] = 1;
		        temp[1] = 3;
		        temp[2] = 5;
		        temp[3] = 6;
		        break;
		case 3: temp[0] = 0;
		        temp[1] = 1;
		        temp[2] = 2;
		        temp[3] = 5;
		        break;
		case 4: temp[0] = 0;
		        temp[1] = 5;
		        temp[2] = 12;
		        temp[3] = 7;
		        break;
		case 5: temp[0] = 0;
		        temp[1] = 3;
		        temp[2] = 2;
		        temp[3] = 4;
		        temp[4] = 6;
		        break;
		case 6: temp[0] = 2;
		        temp[1] = 5;
		        temp[2] = 10;
		        break;
		case 7: temp[0] = 4;
		        temp[1] = 8;
		        break;
		case 8: temp[0] = 7;
		        temp[1] = 9;
		        temp[2] = 16;
		        break;
		case 9: temp[0] = 8;
		        temp[1] = 10;
		        break;
		case 10: temp[0] = 6;
		         temp[1] = 15;
		         temp[2] = 9;
		         break;
		case 11: temp[0] = 12;
		         break;
		case 12: temp[0] = 11;
		         temp[1] = 14;
		         temp[2] = 15;
		         temp[3] = 13;
		         temp[4] = 16;
		         temp[5] = 4;
		         break;
		case 13: temp[0] = 12;
				 break;
		case 14: temp[0] = 12;
		         temp[1] = 15;
		         break;
		case 15: temp[0] = 14;
		         temp[1] = 18;
		         temp[2] = 19;
		         temp[3] = 10;
		         temp[4] = 20;
		         temp[5] = 17;
		         temp[6] = 12;
		         break;
		case 16: temp[0] = 12;
		         temp[1] = 8;
		         break;
		case 17: temp[0] = 15;
		         break;
		case 18: temp[0] = 15;
		         break;
		case 19: temp[0] = 15;
		         break;
		case 20: temp[0] = 15;
		         break;
		default: temp[0] = 0;
		         break;
		}   
		return temp;
	}
	/*
	 * This function is get the length of the available room the player can move. 
	 */
	
	public int getAvailableRoom(int ID){
		switch(ID){
		case 0: return 4;
		case 1: return 3;
		case 2: return 4;
		case 3: return 4;
		case 4: return 4;
		case 5: return 5;
		case 6: return 3;
		case 7: return 2;
		case 8: return 3;
		case 9: return 2;
		case 10: return 3;
		case 11: return 1;
		case 12: return 6;
		case 13: return 1;
		case 14: return 2;
		case 15: return 7;
		case 16: return 2;
		case 17: return 1;
		case 18: return 1;
		case 19: return 1;
		case 20: return 1;
		default: return 0;
		}
	}
	
	public void wasteCard(Card card){
		usedCards.add(card);
	}
	
	/*public void wasteCardlist(){
		usedCards.add(humanPlayer.getCardlist1());
	}*/
	
	/*
	 * This function will return a list of the Room which that location can move. 
	 * This is kind of a table for the function to use
	 */
	public Room[] getRoomList(Player player){
		Room [] name = new Room [player.getRoomID()];
		for (int i = 0; i < getAvailableRoomList(player.getRoomID()).length; i++){
			name [i] = Roomlist[getAvailableRoomList(player.getRoomID())[i]];
		}
		return name;
	}
	
	public void increaseTimes(){
		times++;
	}
	
	public void ShuffleArray(ArrayList<Card> list){
		   Collections.shuffle(list);
	}
	
	public void resetTimes(){
		times = 0;
	}
	
	public int getTimes(){
		return times;
	}
}



