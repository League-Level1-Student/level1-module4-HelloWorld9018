package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nasty_Surprise implements ActionListener {
	public static void main(String[] args) {
		
		Nasty_Surprise thingy1 = new Nasty_Surprise();
		
		
	}
	
	
	JFrame window = new JFrame();
	JPanel panel =  new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	
	Nasty_Surprise(){
		
		//window.setSize(200, 100);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		window.add(panel);
		
		
		panel.add(button1);
		
		panel.add(button2);
		
		
		button1.add(label1);
		
		button2.add(label2);
		
		label1.setText("Trick");
		
		label2.setText("Treat");
		
		
		
		window.pack();
		
	
	
		
	button1.addActionListener(this);
	button2.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (button1.equals(e.getSource())) {
		showPictureFromTheInternet("https://i.pinimg.com/originals/1b/e8/85/1be885e4f3e2aa106fa28c27ec6ded73.jpg");
		}
		
		else if (button2.equals(e.getSource())) {
			
			showPictureFromTheInternet("https://i.pinimg.com/originals/55/06/82/5506829be7bef4dca4dafc42f848e5df.jpg");
			
		}
		
	}
	
	
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
	
	}


