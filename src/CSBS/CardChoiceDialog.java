package CSBS;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardChoiceDialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel messagePanel,
				   choicePanel;
	private JLabel messageLabel;
	private JButton[] cardImageButtons;
	private Player aPlayer;
	private static final int DIALOG_WIDTH = 500;
    private static final int DIALOG_HEIGHT = 300;
	
	
	public CardChoiceDialog(Player aPlayer,String name){
		
		this.aPlayer = aPlayer;
			
		this.setTitle("Diacard a Card!");
	    
	    //set messages on top panel
	    String message = "Choose one of the cards below to discard: ";
		messagePanel = new JPanel();
	    messageLabel = new JLabel(message);
		messageLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		messagePanel.add(messageLabel);
		//set card imageIcon on down panel	
		choicePanel = new JPanel();
		
		int length = aPlayer.getCardlist().length;
		cardImageButtons = new JButton[length];
		for(int i = 0; i < length; i++){
			if(aPlayer.getCardlist()[i].toString() != name){
				cardImageButtons[i] = new JButton(aPlayer.getCardlist()[i].getImage());
				cardImageButtons[i].setPreferredSize(new Dimension
						(aPlayer.getCardlist()[i].getImage().getIconWidth(),
								aPlayer.getCardlist()[i].getImage().getIconHeight()));
				cardImageButtons[i].addActionListener(this);
				choicePanel.add(cardImageButtons[i]);
			}
		}
			
	
		
		//set the layout of dialog
		this.setLayout(new BorderLayout());
		this.add(messagePanel, BorderLayout.NORTH);
		this.add(choicePanel,BorderLayout.CENTER);
		
		//set size of dialog, always on top, modal, center to frame
		//must execute these after adding all the components
		this.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		
		this.setAlwaysOnTop(true);
		this.setModal(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e){
		for(int i = 0; i < aPlayer.getCardlist().length; i++){
			if(e.getSource() == cardImageButtons[i]){
				Card card = aPlayer.getCardlist()[i];
				Tryframe.addUsedCards(card);
				aPlayer.removeCard(card);
				this.setVisible(false);
			}
		}
		
		
	}

	
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	