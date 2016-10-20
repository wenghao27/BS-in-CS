package CSBS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Deck is the all of the Card. That include the card which player own. All of the card have an ID
 * ID is used to identify all of the card. What card is it. For the Shuffle, shuffle will only change the 
 * ID of the card. The card which player own will locate it as the start of the array.
 * For this function also 
 */
public class Deck {
    private int AvailableCard;		//
    private int Year;
	private ArrayList<Card> freshmentCards;
	private ArrayList<Card> usedCards; //cards been used put in this deck
	
	
	public Deck() {
		
	}
	
    public Deck(ArrayList<Card> freshmentCards, ArrayList<Card> usedCards){
    	this.freshmentCards = freshmentCards;
    	this.usedCards = usedCards;
		//initialize FreshementDeck
		//need to implement shuffle function to shuffle the deck, implement later...
		generateCardLists();
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
}


    /*
     * This function is use to shuffle the array. It will shuffle the card from 1,2,3,4, and so on to > then the
     * number of the array point to.
     */
   public void ShuffleArray(ArrayList<Card> list){
	   Collections.shuffle(list);
   }
    
	public int getAvailableCard(){
		return AvailableCard;
	}
	
}
