package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.w3c.dom.events.Event;

public class ChuckleClicker implements ActionListener {
	
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	
	Random ran = new Random();
	int num = ran.nextInt(2);
	
	
void makeButtons(){
	//JOptionPane.showMessageDialog(null, "Make Buttons");
	JFrame frame = new JFrame();
	frame.setVisible(true);
	JPanel panel = new JPanel();
	
	
	frame.add(panel);
	panel.add(button1);
	panel.add(button2);
	
	button1.addActionListener(this);
	button2.addActionListener(this);
	
	button1.setText("Joke");
	button2.setText("Punchline");
	
	frame.pack();
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	System.out.println("hi");
	
	
	
	if (num == 0) {
		
			if (e.getSource() == button1) {
		JOptionPane.showMessageDialog(null, "A horse walks into a bar, what does the bartender say?");
	}
	
			else if (e.getSource() == button2) {
		JOptionPane.showMessageDialog(null, "\"What's with the long face?\"");
	}
			
	}
	
	else if (num == 1) {
		
		if (e.getSource() == button1) {
			JOptionPane.showMessageDialog(null, "A man into a bar, what does he say?");
		}
		
		else if (e.getSource() == button2) {
			JOptionPane.showMessageDialog(null, "\"Ouch!\"");
		}
		
	}
	

	
}

}
