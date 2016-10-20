package CSBS;


import java.util.Random;


public class AI extends Player{
	public AI(String name, int learn,int cra, int inte, int id){
		super(name, learn,cra,inte,id);
	}
	
	public int move(int length){
		Random rand = new Random();
		return rand.nextInt()%length;
	}
	
	public int playCard(Card[] cardlist){
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
			//if(cardlist[i].getRoomID() == super.getRoomID()){
				return i;
		//	}
		return rand.nextInt()%6;
	}
	
	public Card getCard(int number){
		return Cardlist.get(number);
	}
	
	public int checkCard(){
		for (int i = 0; i < Cardlist.size(); i++){
			if(Cardlist.get(i).checkSuccess(this))
				return i;
		}
		return -1;
	}
}
