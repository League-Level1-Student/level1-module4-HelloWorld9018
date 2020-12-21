package _08_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.im.InputContext;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	
		JButton additionFunction = new JButton();
		JButton subtractionFunction = new JButton();
		JButton multiplicationFunction = new JButton();
		JButton divisionFunction = new JButton();
		
		JTextField box1 = new JTextField(10);
		JTextField box2 = new JTextField(10);
		
		double a = 0;
		double b = 0;
		
		double c;
		
		JLabel equals = new JLabel();
		
		JFrame frame  = new JFrame();
		
	double add(double a, double b){
		double c = a + b;
		return c;
	}
	
	double subtract(double a, double b){
		
		double c = a - b;
		return c;
		
	}
	
	double multiply (double a, double b) {
		double c = a * b;
		return c;
	}
	
	double divide(double a, double b) {
		double c = a/b;
		return c;
	}
	
	void makeButtons (){
		
		frame.setTitle("   Calculator");
		
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		
		
		
		JPanel inputArea1 = new JPanel();
		JPanel inputArea2 = new JPanel();
		JPanel functionArea = new JPanel();
		JPanel outputSign = new JPanel();
		JPanel output = new JPanel();
		
		
		equals.setText(" =    " + c);
		
		
		additionFunction.setText("+");
		subtractionFunction.setText("-");
		multiplicationFunction.setText("x");
		divisionFunction.setText("÷");
		
		
		frame.add(panel);
		panel.add(inputArea1);
		panel.add(functionArea);
		panel.add(inputArea2);
		panel.add(outputSign);
		
		inputArea1.add(box1);
		inputArea2.add(box2);
		
		outputSign.add(equals);
		
		functionArea.add(additionFunction);
		functionArea.add(subtractionFunction);
		functionArea.add(multiplicationFunction);
		functionArea.add(divisionFunction);
		
		frame.pack();
		
		additionFunction.addActionListener(this);
		subtractionFunction.addActionListener(this);
		multiplicationFunction.addActionListener(this);
		divisionFunction.addActionListener(this);
		
		box1.setText("");
		box2.setText("");
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String input1 = box1.getText();
		
		if (input1 .equals ("")) {
			a = 0;
		}
		else {
			a = Double.parseDouble(input1);
		}
		

		String input2 = box2.getText();
		
		if (input2 .equals ("")) {
			b = 0;
		}
		else {
			b = Double.parseDouble(input2);
		}
		
		
		System.out.println("" + a);
		
		System.out.println("" + b);
		
		
		
		if (e.getSource() .equals(additionFunction)) {
			System.out.println("add");
			
			c = add(a, b);
			
			equals.setText(" =    " + c);
			
		}
		
		else if (e.getSource() .equals(subtractionFunction)) {
			System.out.println("subtract");
			
			c = subtract(a, b);
			
			equals.setText(" =    " + c);
			
		}
		
		else if (e.getSource() .equals(multiplicationFunction)) {
			System.out.println("multiply");
			
			c = multiply(a, b);
			
			equals.setText(" =    " + c);
			
		}
		
		else if (e.getSource() .equals(divisionFunction)) {
			System.out.println("divide");
			
			c  = divide(a, b);
			
			equals.setText(" =    " + c);
			
		}
		frame.pack();
	}
	
}
