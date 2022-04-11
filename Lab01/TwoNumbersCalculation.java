// Exercise 2.2.5

import javax.swing.JOptionPane;

public class TwoNumbersCalculation {
	public static void main(String[] args) {
		String strNum1, strNum2;
		String rs = "";
		strNum1 = JOptionPane.showInputDialog(null, "Please type the 1st number:	", "Input the 1st number", JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please type the 2nd number:	", "Input the 2nd number", JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		rs += "Sum: " + (num1 + num2) + "\n";
		rs += "Difference: " + (num1 - num2) + "\n";
		rs += "Product: " + (num1 * num2) + "\n";
		if(num2 != 0){
			rs += "Division: " + (num1 / num2); 
		}
		else {
			rs += "Division: Can't devide by zero";
		}
		JOptionPane.showMessageDialog(null, rs, "Result", JOptionPane.INFORMATION_MESSAGE);
	}
}

