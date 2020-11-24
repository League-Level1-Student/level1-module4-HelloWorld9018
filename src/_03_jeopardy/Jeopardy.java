package _03_jeopardy;


/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;


import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import _03_jukebox.Song;
//import javazoom.jl.player.advanced.AdvancedPlayer;


/* Check out the Jeopardy Handout to see what the end result should look like: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton, fifthButton;
	private JPanel quizPanel;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;
//	private Song sound;



	public void run() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		// 1. Make the frame show up
		frame.setVisible(true);
		// 2. Give your frame a title
		frame.setTitle("Lily's Jeopardy Game");
		// 3. Create a JPanel variable to hold the header using the createHeader method
		JPanel headerPanel = createHeader("Classical Composers");
		// 4. Add the header component to the quizPanel
		quizPanel.add(headerPanel);
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);
		// 6. Use the createButton method to set the value of firstButton
		firstButton = createButton("$200");
		// 7. Add the firstButton to the quizPanel
		quizPanel.add(firstButton);
		// 8. Write the code to complete the createButton() method below. Check that your
		// game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.
		
		// 9. Use the secondButton variable to hold a button using the createButton
		// method
		secondButton = createButton("$400");
		// 10. Add the secondButton to the quizPanel
		quizPanel.add(secondButton);
		
		thirdButton = createButton("$600");
		quizPanel.add(thirdButton);
		
		fourthButton = createButton("$800");
		quizPanel.add(fourthButton);
		
		fifthButton = createButton("$1000");
		quizPanel.add(fifthButton);
		// 11. Add action listeners to the buttons (2 lines of code)
		firstButton.addActionListener(this);
		secondButton.addActionListener(this);
		thirdButton.addActionListener(this);
		fourthButton.addActionListener(this);
		fifthButton.addActionListener(this);
		// 12. Write the code to complete the actionPerformed() method below
		
		// 13. Add buttons so that you have $200, $400, $600, $800 and $1000 questions
		
		 /*
		 * [optional] Use the showImage or playSound methods when the user answers a
		 * question
		 */		
		
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}


	private JButton createButton(String dollarAmount) {
		
		// Create a new JButton
		JButton money = new JButton();
		// Set the text of the button to the dollarAmount
		money.setText(dollarAmount);
		// Increment the buttonCount (this should make the layout vertical)
		buttonCount ++;
		// Return your new button instead of the temporary button
		return money;
	}

	public void actionPerformed(ActionEvent e) {
		
		// Remove this temporary message after testing:
		JOptionPane.showMessageDialog(null, "pressed " + ((JButton) e.getSource()).getText() + " button");

		JButton buttonPressed = (JButton) e.getSource();
		// If the buttonPressed was the firstButton
		if (buttonPressed == firstButton) {
			
		
			// Call the askQuestion() method
			askQuestion("What was Mozart's first and middle name?", "Wolfgang Amadeus", 200);
		// Complete the code in the askQuestion() method. When you play the game, the score should change.
			
			firstButton.setText("");
			
		}
		// If the buttonPressed was the secondButton
		else if (buttonPressed == secondButton) {
			// Call the askQuestion() method with a harder question
			askQuestion("How old was Beethoven when he published his first composition?", "12", 400);
			
			secondButton.setText("");
			
		}
		
		else if (buttonPressed == thirdButton) {
			// Call the askQuestion() method with a harder question
			askQuestion("What was Schubert's nickname translated to english?", "Little Mushroom", 600);
			
			thirdButton.setText("");
			
		}
		
		else if (buttonPressed == fourthButton) {
			// Call the askQuestion() method with a harder question
			askQuestion("What did Elgar write his main theme for his cello concerto on?", "Napkin", 800);
			
			fourthButton.setText("");
			
		}
		
		else if (buttonPressed == fifthButton) {
			// Call the askQuestion() method with a harder question
			askQuestion("Both Bach and Handel were blided by which occular surgeon?", "John Taylor", 1000);
			
			fifthButton.setText("");
			
		}
		// Clear the text on the button that was pressed (set the button text to nothing)
		
	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		
		// Use the playJeopardyTheme() method to play music while the use thinks of an answer
	//	playJeopardyTheme();
		// Remove this temporary message and replace it with a pop-up that asks the user the question
		String answer = JOptionPane.showInputDialog(null, question);
		
		// Stop the theme music when they have entered their response. Hint: use the sound variable 
		
		// If the answer is correct
		if (answer .equalsIgnoreCase(correctAnswer) ) {
			System.out.println("correct");
		
			// Increase the score by the prizeMoney
			score = score + prizeMoney;
			// Pop up a message to tell the user they were correct
			JOptionPane.showMessageDialog(null, "Correct!");
			
	//		sound.stop();
		}
		// Otherwise
		else {
			
			// Decrement the score by the prizeMoney
			score = score - prizeMoney;
			// Pop up a message to tell the user they were wrong and give them the correct answer
			JOptionPane.showMessageDialog(null, "Incorrect! The correct answer was '" + correctAnswer + "'");
			
		//	sound.stop();
		}
			
		// Call the updateScore() method
		updateScore();
	}

	public void playJeopardyTheme() {
		/**try {
			sound = JApplet.newAudioClip(getClass().getResource("jeopardy.wav"));
			sound.play();
			Thread.sleep(3400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
	//	sound = new Song("jeopardy.wav");
	//	sound.play();
		
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}










