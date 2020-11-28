package _05_typing_tutor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TypingTutor implements KeyListener {
	
	Date timeAtStart = new Date();
	
	char currentLetter;
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	int amount = 0;
	
	public static void main(String[] args) {
		
		
		TypingTutor tutor = new TypingTutor();
		tutor.setup(); 
		
		
	}
	
	void setup() {
		JFrame frame = new JFrame();
		
		
		frame.setVisible(true);
		frame.setTitle("Type or Die");
		frame.setSize(new Dimension(600, 600));
	
		currentLetter = generateRandomLetter();
		
		
		label.setText("" + currentLetter);
		
		panel.setPreferredSize(new Dimension(500, 500));
		label.setPreferredSize(new Dimension(500, 500));
					
		label.setFont(label.getFont().deriveFont(150.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
					

		frame.addKeyListener(this);
		panel.add(label);
		frame.add(panel);

			
		
		
		
	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(amount);
		
		if (e.getKeyChar() == currentLetter) {
		System.out.println("correct");
		
		panel.setBackground(Color.GREEN);
		amount++;
	}

	else{
	panel.setBackground(Color.RED);
	}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e);
		
		if (amount >= 20) {
			System.out.println("STOP");
			showTypingSpeed(amount);
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter = 0;
		generateRandomLetter();
		currentLetter = generateRandomLetter();
		label.setText("" + currentLetter);
		
	}
	
	
    
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	    Date timeAtEnd = new Date();
	    long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	    long gameInSeconds = (gameDuration / 1000) % 60;
	    double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	    int charactersPerMinute = (int) (charactersPerSecond * 60);
	    JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	} 
	
}
