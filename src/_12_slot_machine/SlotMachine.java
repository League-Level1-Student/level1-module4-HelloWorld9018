package _12_slot_machine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {

	//int numA = 1;
	//int numB = 1;
	//int numC = 1;
	
	String image;
	
	JLabel slot1 = loadImage("cherriesResized.jpg");
	JLabel slot2 = loadImage("lemon.jpg");
	JLabel slot3 = loadImage("seven.png"); 
	
	JFrame frame = new JFrame();
	
	void spin() {
		
	
		JPanel slotPanel = new JPanel();
		
		
		
		for (int i = 0; i<3; i++) {
			int ran = new Random().nextInt(3);
			
			
		if(ran == 0) {
			image = "cherriesResized.jpg";
		}
		
		else if (ran == 1) {
			image = "lemon.jpg";
		}
		
		else {
			image = "seven.png";
		}
		
		
		JLabel label = loadImage(image);
		
			if (i == 0) {
				slot1 = label;
				System.out.println(i);
			}
			
			else if (i == 1) {
				slot2 = label;
				System.out.println(i);
			}
			
			else {
				slot3 = label;
				System.out.println(i);
			}	
			
		}
		
		
		JButton button = new JButton();
		button.setText("SPIN!");
		
		frame.setVisible(true);
		frame.add(slotPanel);
		
		frame.setSize(650, 300);
		
		slotPanel.add(slot1);
		slotPanel.add(slot2);
		slotPanel.add(slot3);
		slotPanel.add(button);
		
		button.addActionListener(this);
		
		
		if (slot1.getName() .equals(slot2.getName()) && slot2.getName() .equals(slot3.getName())) {
			JOptionPane.showMessageDialog(null, "YOU WIN!!!");
		}
	}
	
	
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel label = new JLabel(icon);
		label.setName(fileName);
		return label;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//numA = new Random().nextInt(3);
		//numB = new Random().nextInt(3);
		//numC = new Random().nextInt(3);
		frame.dispose();
		spin();
		
	}
	
}

