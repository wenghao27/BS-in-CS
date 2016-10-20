package CSBS;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChipChoiceDialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel messagePanel,
				   choicePanel;
	private JLabel messageLabel;
	private JButton learningButton,
					craftButton,
					integrityButton;
	private Player aPlayer;
	private static final int DIALOG_WIDTH = 500;
    private static final int DIALOG_HEIGHT = 150;
	
	
	public ChipChoiceDialog(Player aPlayer,boolean Learn,boolean Craft, boolean Inte){
		
		this.aPlayer = aPlayer;
			
		this.setTitle("Choose a chip!");
	    
	    //set messages on top panel
	    String message = "Choose one of the chips below as rewards: ";
		messagePanel = new JPanel();
	    messageLabel = new JLabel(message);
		messageLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		messagePanel.add(messageLabel);
		
		//set buttons of choice on down panel
		choicePanel = new JPanel();
		learningButton = new JButton("1 Learning Chip");
		craftButton = new JButton("1 Craft Button");
		integrityButton = new JButton("1 Integrity Button");
		//flow layout
		if(Learn)
			choicePanel.add(learningButton);
		if(Craft)
			choicePanel.add(craftButton);
		if(Inte)
			choicePanel.add(integrityButton);
		//action listener
		learningButton.addActionListener(this);
		craftButton.addActionListener(this);
		integrityButton.addActionListener(this);
		
		
		
		//set the layout of dialog
		this.setLayout(new BorderLayout());
		this.add(messagePanel, BorderLayout.NORTH);
		this.add(choicePanel,BorderLayout.CENTER);
		
		//set size of dialog, always on top, modal, center to frame
		//must execute these after adding all the components
		this.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setModal(true);
		this.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == learningButton){

			aPlayer.AddLearning(1);
			setVisible(false);
		}
		if(e.getSource() == craftButton){

			aPlayer.AddCraft(1);
			setVisible(false);
		}
		if(e.getSource() == integrityButton){

			aPlayer.AddIntegrity(1);
			setVisible(false);
		}
		
	}



}
