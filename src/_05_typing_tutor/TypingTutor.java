package _05_typing_tutor;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor {
	
	char currentLetter;
	
	public static void main(String[] args) {
		
	}
	
	void setup() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		currentLetter = generateRandomLetter();
		
		JLabel label = new JLabel();
		label.setText(currentLetter);
		
	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}
	
}
