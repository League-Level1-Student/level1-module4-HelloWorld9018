package _08_calculator;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorRunner {
	
	double calculated;
	
public static void main(String[] args) {
	
	
	Calculator idk =  new Calculator();
	
    idk.makeButtons();
	
	//////////////JLabel answer = new JLabel("" + calculated);
	
	//////////////calculated = idk.add(3, 5);
	
    
	
	System.out.println(idk.add(6.3, 2.5));
	
	System.out.println(idk.subtract(4, 6));
	
	System.out.println(idk.multiply(5.5, 5.25));
	
	System.out.println(idk.divide(7, 3));
}
}
