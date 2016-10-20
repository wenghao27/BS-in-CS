

package CSBS;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Tryframe extends JFrame implements ActionListener, ListSelectionListener{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // How is serialVersionUID working?

	// boardImageLabel is an object type of JLabel  that is used to store map image and string of player's name on the map
	private TryImageLabel	boardImageLabel;  	
	private JScrollPane imageScroll;
	
	//basic structure of the GUI
	private JPanel 		upPanel,
						downPanel,
						leftDownPanel,
						middleDownPanel,
						rightDownPanel;
	private JButton		moveButton,
						playCard,
						drawCard,
						cardButton;	
	private JList		roomList;
	
	private static  JTextArea	gameInfo;
	private JTextArea			 gameRecord;
	private DefaultListModel  listModel = new DefaultListModel();
	private boolean update = false;
	
	private static GameState  gameState;	// gameState Object that store initial state of the game
	private String Record = "";	  // use to store String value of game information and shows on gameRecord text area on panel.
	private ImageIcon   card1;	// store imageIcon that shows on the panel;
	//private JLabel carLabel1;
	private int order = 0;

	
	
	public Tryframe(GameState gameState){
		
	Tryframe.gameState = gameState;


	//set title, set size of frame, response to close, set resizable
	setTitle("BSCS Challenge");
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(true);
	
	
	//initiate borad image and make it scrollable in upper panel
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	boardImageLabel = new TryImageLabel(gameState);
	upPanel = new JPanel();
	upPanel.add(boardImageLabel);	
	imageScroll = new JScrollPane(upPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	imageScroll.setPreferredSize(new Dimension((int)screen.getWidth(),(int)screen.getHeight()/3*2));
	
	//Here is setting the size of the Panel
	
	
	//downPanel contains leftDownPanel, middleDownPanel and rightDownPanel
	downPanel = new JPanel();
	
	//leftDownPanel will contain drawCard button, move button, play card button, and room List from top to down
	leftDownPanel = new JPanel();
	Box left = Box.createVerticalBox();
	
	
	
	
	//middleDownPanel contains only card image icon
	
	middleDownPanel = new JPanel();
	
	card1 = gameState.getHumanPlayer().getCardlist()[4].getImage();
	cardButton = new JButton(card1);
	cardButton.setPreferredSize(new Dimension(card1.getIconWidth(),card1.getIconHeight()));
	middleDownPanel.setPreferredSize(new Dimension(card1.getIconWidth(),card1.getIconHeight()));
	middleDownPanel.add(cardButton);
	cardButton.addActionListener(this);

	
	
	//rightDownPanel contains Two textAreas from top to down
	
	rightDownPanel = new JPanel();
	Box right = Box.createVerticalBox();
	downPanel.setPreferredSize(new Dimension((int)screen.getWidth(),(int) (screen.getHeight()/3)));
	right.setPreferredSize(new Dimension((int)(screen.getWidth()*2/3),(int) (screen.getHeight()/3)));
	
	gameInfo = new JTextArea(13, 100);
	gameInfo.setLineWrap(true);
	gameInfo.setWrapStyleWord(true);
	gameInfo.setEditable(false);
	gameInfo.setPreferredSize(new Dimension((int)screen.getWidth()*2/3,(int) (screen.getHeight()/9*2)));
	right.add(gameInfo);
	right.add(Box.createRigidArea(new Dimension(0,8)));
	
	gameRecord = new JTextArea(6, 100);
	gameRecord.setLineWrap(true);
	gameRecord.setWrapStyleWord(true);
	gameRecord.setEditable(false);
	
	JScrollPane gameRecordScroll = new JScrollPane(gameRecord, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
	ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
	gameRecordScroll.setPreferredSize(new Dimension((int)(screen.getWidth()*2/3),(int) (screen.getHeight()/9-8)));
	right.add(gameRecordScroll);
	//rightDownPanel.setPreferredSize(new Dimension((int)right.getWidth(),right.getHeight()));
	rightDownPanel.add(right);
	
	//set size of component will depends on what layout is using, in this case of 
	//using box layout, the horizontal can not be set prefered size
	drawCard = new JButton("drawCard");
	Dimension width = drawCard.getMaximumSize();
	left.add(drawCard);
	left.add(Box.createRigidArea(new Dimension(0,6)));//create space between buttons
	drawCard.addActionListener(this);
	
	
	moveButton = new JButton("Move");
	moveButton.setMaximumSize(new Dimension(width));
	left.add(moveButton);
	left.add(Box.createRigidArea(new Dimension(0,6)));
	moveButton.addActionListener(this);
	
	playCard = new JButton("playCard");
	playCard.setMaximumSize(new Dimension(width));
	left.add(playCard);
	left.add(Box.createRigidArea(new Dimension(0,6)));
	playCard.addActionListener(this);		
	
	roomList = new JList(listModel);
	roomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	roomList.setLayoutOrientation(JList.VERTICAL);
	roomList.setVisibleRowCount(10);
	JScrollPane listScroller = new JScrollPane(roomList);
	listScroller.setPreferredSize(new Dimension((int)width.getWidth(), (int)(screen.getHeight()/3-width.getHeight()*3-8*3)));
	left.add(listScroller);
	//left.setPreferredSize(new Dimension((int)width.getWidth()+100,downPanel.getHeight()));
	
	leftDownPanel.add(left);
	roomList.getSelectionModel();
	
	//flow layout on downPanel
	downPanel.add(leftDownPanel);
	downPanel.add(middleDownPanel);
	downPanel.add(rightDownPanel);
	
	
	add(downPanel, BorderLayout.SOUTH);
	add(imageScroll,BorderLayout.CENTER);

 
	drawCard.setEnabled(true);
	moveButton.setEnabled(false);
	playCard.setEnabled(false);
	updateGameInfo();
	setVisible(true);


	}
	public void updateBoardImage(){
		boardImageLabel.repaint();
		
	}
		
	//************************Level 0**************************************************
		/*
		 * This function is for AI turns. Since the whole Human turn will process in the Action Listener
		 * Therefore it is not necessary to create Human turns
		 * Human turns is also level 0 but it will contain in the actionlistener.
		 */
		public void AIturns(AI ai){	
			DrawCard(ai);
			for(int i = 0; i < 3; i++){
				AIMove(ai);
				/*
				 * This function is checking is there any function match the room AI in. otherwise random move again
				 */
				if(ai.checkCard() != -1){
					AIPlay(ai);
					break;
				}
				if(i == 2){
					int arraylength = ai.getCardlist().length;
					Random r = new Random();
					playerplay(ai,ai.getCard(r.nextInt(Integer.SIZE - 1)%arraylength));
				}
			}
		}
		
	//************************Level 1***************************************************
		/*
		 * If the function have a component of the player, it means both Human player and the AI player will
		 * use the function. Otherwise it will seperate as AI and Human. For example the AIMove and the Human
		 * Move. 
		 */
		/*
		 * DrawCard is for AI and also the Human player to draw the card. So this function will need to get
		 * which player the user want to change. 
		 * */
		public static void DrawCard(Player player){			
			player.AddCard(gameState.getFirstCard());
			updateGameInfo();
		}
		/*
		 * This function is for the AI to move.
		 */
		public void AIMove(AI ai){					//This function is use for the AI to move
			Random Rand = new Random();
			int number1 = Rand.nextInt(gameState.getAvailableRoom(ai.getRoomID()));
			playerMove(ai,getRoom(ai.getRoomID(),number1));
		}	
		
		public void AIPlay(AI ai){
			playerplay(ai,ai.getCard(ai.checkCard()));
		}
		/*
		 * This is the Player Move, Since the player move is different than the AIMove.
		 * Player move will get the destination of Human or AI select. And change the room of the player destination
		 * This will work in the player function. Not in the Controller
		 */
		public void playerMove(Player player,int destination){	//This function is use to change the Player and the location of the player 
			player.changeRoom(destination);	
			updateBoardImage();
		}		
		
		public void playerplay(Player player, Card card){
			updateCP(card,player); 
			card.playCard(player);
			updateBoardImage();
			//gamestate.getHumanPlayer().getCardlist()[number].playCard(player);
			gameState.getUsedCards().add(card);
			player.removeCard(card);
			/*
			 * This is checking the Total QualityPoint for all player. if the sum is > 60, add card
			 */
			if(gameState.getHumanPlayer().getTotalQualityPoint()+gameState.getAIPlayer1().getTotalQualityPoint()+gameState.getAIPlayer2().getTotalQualityPoint() > 60 && !update){
				gameState.updateNewDeck();
				Record += "Add and delete Card\n";
				update = true;
			}
			if(player.getTotalQualityPoint()>100){
				System.out.println(player + " win the game");
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,
					    "Congratulations, "+player + " win this game :)",
					    "Win Game",
					    JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		}
		
		public static void discardCard(Player aPlayer,String name) {
			if(aPlayer.getID() == 1){
				CardChoiceDialog c = new CardChoiceDialog(aPlayer,name);
			}else{
				int number = aPlayer.getCardlist().length;
				Random r = new Random();
				Card card = aPlayer.getCardlist()[r.nextInt() % number];
				Tryframe.addUsedCards(card);
				aPlayer.removeCard(card);
			}
		}
		
		public static void addUsedCards(Card card){
			gameState.getUsedCards().add(card);
		}
		
		
	//************************Level 2***************************************************
		/*
		 * This is the level 2 function. This level will only read by the upper level or same level.
		 */
		
		/*
		 * This function will get the specific room for the player. This function is kind of useless but 
		 * it will be more organize to create this function
		 */
		public int getRoom(int room,int target){
			return gameState.getAvailableRoomList(room)[target];
		}
		
		/*
		 * This function is create a list of the room
		 * */
		public Room[] getRoomList(Player player){
			Room [] name = new Room [gameState.getAvailableRoomList(player.getRoomID()).length];
			for (int i = 0; i < name.length; i++){
				name [i] = gameState.getRoom(gameState.getAvailableRoomList(player.getRoomID())[i]);
			}
			return name;
		}
		
		//************************Level 3***************************************************
		/*
		 * This function is update the List of the Room Model. Since we are using the Room model for now.
		 * This is use to display in the display panel
		 */
		public void updateListRoomModel(){
			listModel.clear();
			for(Room value: getRoomList(gameState.getHumanPlayer())){
				listModel.addElement(value);
			}
		}
		
		public void updateListCardModel(){
			listModel.clear();
			for(Card value: gameState.getHumanPlayer().getCardlist()){
				listModel.addElement(value);
			}
		}
		
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == moveButton){
				Room r = (Room) roomList.getSelectedValue();
				playerMove(gameState.getHumanPlayer(),r.getID());
				updateListRoomModel();
				//System.out.println("HumanPlayer: "+gameState.getRoom(gameState.getHumanPlayer().getRoomID()));
				//this.repaint();
				gameState.increaseTimes();
				updateGameInfo();
				if(gameState.getTimes() > 2){
					moveButton.setEnabled(false);
				}
			}
			else if(e.getSource() == playCard){
				{
					//initially, play last card of the list, because last card is shown on the panel
					if(order == 0)
						order = gameState.getHumanPlayer().getCardlist().length; 
					//play the card(last idx), and remove the card
					playerplay(gameState.getHumanPlayer(),gameState.getHumanPlayer().getCardlist()[order-1]);
					//if order is 1, means the current card image index is 0, remove the current one, show the last index of card
					//else show prior index of card image
					//System.out.println(order);
					//if(order == 1)
						card1 = gameState.getHumanPlayer().getCardlist()[gameState.getHumanPlayer().getCardlist().length - 1].getImage();
					//else
					//	card1 = gameState.getHumanPlayer().getCardlist()[order - 2].getImage();
					//System.out.println(order);
					card1.getImage();
					cardButton.setIcon(card1);
					cardButton.repaint();
					gameState.resetTimes();
					
					updateBoardImage();
					updateGameInfo();
					
					//System.out.println("Play the card");
					drawCard.setEnabled(true);
					moveButton.setEnabled(false);
					playCard.setEnabled(false);
					
					AIturns(gameState.getAIPlayer1());
					AIturns(gameState.getAIPlayer2());
					updateGameInfo();
				}

			}
			else if(e.getSource() == drawCard){
				DrawCard(gameState.getHumanPlayer());
				updateListRoomModel();
				//System.out.println("Draw the card");
				drawCard.setEnabled(false);
				moveButton.setEnabled(true);
				playCard.setEnabled(true);
				order = 0;
				card1 = gameState.getHumanPlayer().getCardlist()[gameState.getHumanPlayer().getCardlist().length-1].getImage();
				cardButton.setIcon(card1);
				if(gameState.getHumanPlayer().getCardlist().length>7)
					discardCard(gameState.getHumanPlayer(),null);
				updateGameInfo();
				moveButton.repaint();
			}
			else if(e.getSource() == cardButton){
				if(order >= gameState.getHumanPlayer().getCardlist().length){
					order = 0;
				}
				card1 = gameState.getHumanPlayer().getCardlist()[order].getImage();
				cardButton.setIcon(card1);
				cardButton.repaint();
				order++;
			}
		}

		
		public void updateCP(Card card,Player player){
			Record += player + " played " + card;
			Record +=" for " + card.getRewards();
			gameRecord.setText(Record);
			if(card.checkSuccess(player)){
				Record += " | successful! \n";
				gameRecord.setText(Record);
			}
			else{
				Record += " | failed! \n";
				gameRecord.setText(Record);
			}
		}

		public static void updateGameInfo() {
			gameInfo.setText("\tLearning\tCraft\tIntegrity\tQuality Points\n" +
					gameState.getHumanPlayer() + "\t" +
					gameState.getHumanPlayer().getLearning() + "\t" +
					gameState.getHumanPlayer().getCraft() + "\t" +
					gameState.getHumanPlayer().getIntegrity() + "\t" +
					gameState.getHumanPlayer().getTotalQualityPoint() + "\t" + "\n"+
					gameState.getAIPlayer1() + "\t" +
					gameState.getAIPlayer1().getLearning() + "\t" +
					gameState.getAIPlayer1().getCraft() + "\t" +
					gameState.getAIPlayer1().getIntegrity() + "\t" +
					gameState.getAIPlayer1().getTotalQualityPoint() + "\t" + "\n" +
					gameState.getAIPlayer2() + "\t" +
					gameState.getAIPlayer2().getLearning() + "\t" +
					gameState.getAIPlayer2().getCraft() + "\t" +
					gameState.getAIPlayer2().getIntegrity() + "\t" +
					gameState.getAIPlayer2().getTotalQualityPoint() +
					"\nTotal accumulated Quality Point: "+ (gameState.getHumanPlayer().getTotalQualityPoint() 
							+ gameState.getAIPlayer1().getTotalQualityPoint() 
							+ gameState.getAIPlayer2().getTotalQualityPoint())+
					"\n\nCards in deck: " + gameState.getNumberofCard() +  "\t\t" +
					"Discards out of play: " + gameState.getNumberofUsedCard() +
					"\nYou are " + gameState.getHumanPlayer() + " and you are in " + 
					gameState.getRoom(gameState.getHumanPlayer().getRoomID())
					
			);	
		}
		
		public static void popDialogForChipSelecting(Player aPlayer,boolean Learn,boolean Craft, boolean Inte){
			/*
			 * This is in the Human Player case
			 * */
			if(aPlayer.getID()==1){
				ChipChoiceDialog d = new ChipChoiceDialog( aPlayer ,Learn, Craft, Inte);
			}
			/*
			 * This is in the AI Player case
			 */
			else{
				if(Learn&&Craft&&Inte){
					Random r = new Random();
					if(r.nextInt()%3 == 0)
						aPlayer.AddLearning(1);
					else if(r.nextInt() %3 ==1)
						aPlayer.AddCraft(1);
					else
						aPlayer.AddIntegrity(1);
				}
				else if(Learn&&Inte){
					Random r = new Random();
					if(r.nextInt()%2 == 0)
						aPlayer.AddLearning(1);
					else
						aPlayer.AddIntegrity(1);
				}
				else if(Learn&&Craft){
					Random r = new Random();
					if(r.nextInt()%2 == 0)
						aPlayer.AddLearning(1);
					else
						aPlayer.AddCraft(1);
				}
				else if(Inte&&Craft){
					Random r = new Random();
					if(r.nextInt()%2 == 0)
						aPlayer.AddIntegrity(1);
					else
						aPlayer.AddCraft(1);
				}
			}
			updateGameInfo();
		}
	@Override
	public void valueChanged(ListSelectionEvent e) {
	
	
	}


	

	
}
