package _11_whack_a_mole;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackaMole implements ActionListener {

	JButton mole;
	int missed = 0;
	int scored = 0;
	JFrame frame;
	
	Date timeAtStart = new Date();
	
	void makeButtons(int randomNum) {
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(300, 300));
		
		GridLayout layout = new GridLayout(3, 3);
		
		JPanel panel1 = new JPanel();

		panel1.setLayout(layout);
		
		frame.add(panel1);

		
		for(int i = 0; i<9; i++) {
			JButton button = new JButton();
			panel1.add(button);
			button.addActionListener(this);
			//button.setPreferredSize(new Dimension(100, 50));
			if (i == randomNum) {
				mole = button;
				button.setText("mole");
			}
			
		}
		
		frame.pack();
	
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String check = mole.getText();
		if (check == "mole") {
			scored = scored ++;
		}
		
		else {
			speak("miss");
			missed = missed ++;
		}
		
		int tries = missed + scored;
		
		if(tries >= 10) {
			
			// does not run
			
			endGame(timeAtStart ,scored);
			
			System.out.println("Game Finished");
		}
		
		frame.dispose();
		
		int ran = new Random().nextInt(9);	
		System.out.println(ran);
		makeButtons(ran);
		
		
	}
	
	
	
	static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }

	
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	} 
	
}
