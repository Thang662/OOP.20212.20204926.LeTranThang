// Ex 2.2.5

import javax.swing.JOptionPane;

public class TwoNumbersCalculation {
	public static void main(String[] args) {
		String strNum1, strNum2;
		String output = "";
		strNum1 = JOptionPane.showInputDialog(null, "Please type the 1st number:	", "Input the 1st number", JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "Please type the 2nd number:	", "Input the 2nd number", JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		output += "Sum: " + sum(num1,num2) + "\n";
		output += "Difference: " + diff(num1,num2) + "\n";
		output += "Product: " + product(num1,num2) + "\n";
		output += "Division: " + division(num1,num2); 
		JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
	}
	public static double sum(double num1, double num2 ) {
		return num1 + num2 ;

	}
	public static double diff(double num1, double num2) {
		return num1 - num2;
		
	}
	public static double product(double num1, double num2) {
		return num1 * num2;
	}
	
	public static String division(double num1, double num2) {
		if (num2 == 0) {
			return "You can not divide a number by 0";
			
		}
		else {
			return String.valueOf(num1 /num2);
		}
	}
	
}

