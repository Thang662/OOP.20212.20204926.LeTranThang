package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import hust.soict.dsai.swing.AWTAccumulator.TFInputListener;

public class SwingAccumulator extends JFrame {
	private JTextField tfInput;
	private JTextField tfOutput;
	int sum = 0;  // Accumulated sum, init to 0
	
	// Constructor to setup the GUI components and event handlers
	public SwingAccumulator() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, 2));
		
		cp.add(new Label("Enter an Integer: "));
		
		tfInput = new JTextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		cp.add(new Label("The Accumalated Sum is: "));
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		
		setTitle("Swing Accumulator");
		setSize(350, 120);
		setLocation((int) ((dimension.getWidth() - this.getWidth()) / 2), (int) ((dimension.getHeight() - this.getHeight()) / 2));
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingAccumulator();
	}
	
	public class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}

}
