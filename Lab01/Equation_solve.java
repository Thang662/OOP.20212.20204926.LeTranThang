// Ex 2.2.6

import javax.swing.JOptionPane;

public class Equation_solve {

	public static void main(String[] args) {
		int userInput = Integer.parseInt(JOptionPane.showInputDialog(null,"What type of equation you want to solve? \n" + 
				"1- The 1st-degree equation (linear equation) with one variable \n " +
				"2- The system of 1st-degree equations (linear system) with two variables \n "+ 
				"3- The second-degree equation with one variable \n", "Calculator", JOptionPane.QUESTION_MESSAGE));
		if (userInput > 4 || userInput < 1 ) {
			JOptionPane.showMessageDialog(null,"Please try again!", "Invalid value", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			
			if (userInput == 1) {
				
				String strA = JOptionPane.showInputDialog(null,"Please type A:	", "Value A", JOptionPane.INFORMATION_MESSAGE);
				String strB = JOptionPane.showInputDialog(null,"Please type B:	", "Value B", JOptionPane.INFORMATION_MESSAGE);
				double a = Double.parseDouble(strA);
				double b = Double.parseDouble(strB);
				firstDegreeOneVariable(a,b);
			}
			
			else if (userInput == 2)	{
				String firstEquation = JOptionPane.showInputDialog(null, "Please enter the coefficient for the first equation: ", "First equation", JOptionPane.INFORMATION_MESSAGE);
				String secondEquation  = JOptionPane.showInputDialog(null, "Please enter the coefficient for the second equation: ", "Second equation", JOptionPane.INFORMATION_MESSAGE);
				String[] firstArray = firstEquation.split(",");
				String[] secondArray = secondEquation.split(",");
				double a11 = Double.parseDouble(firstArray[0]) ;
				double a12 = Double.parseDouble(firstArray[1]) ;
				double b1 = Double.parseDouble(firstArray[2]) ;
				
				double a21 = Double.parseDouble(secondArray[0]) ;
				double a22 = Double.parseDouble(secondArray[1]) ;
				double b2 = Double.parseDouble(secondArray[2]) ;
				systemOfLinearEquation(a11, a12, a21, a22, b1, b2);
			}
			else if (userInput == 3) {
				String strrA = JOptionPane.showInputDialog(null,"Please input A:	", "Input A", JOptionPane.INFORMATION_MESSAGE);
				String strrB = JOptionPane.showInputDialog(null,"Please input B:	", "Input B", JOptionPane.INFORMATION_MESSAGE);
				String strrC = JOptionPane.showInputDialog(null,"Please input C:	", "Input C", JOptionPane.INFORMATION_MESSAGE);
				double A = Double.parseDouble(strrA);
				double B = Double.parseDouble(strrB);
				double C = Double.parseDouble(strrC);
				secondDegreeEquationOneVariable(A, B, C);
			}
		}
	}
	
	
	public static void firstDegreeOneVariable(double a, double b) {
		if (a != 0) {
			double res = (-b/a);
			JOptionPane.showMessageDialog(null, "x= "+ res, "Solution", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "This equation does not have any solution", "Result showing", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public static double computeDetermination(double a11, double a12, double a21, double a22) {
		return (a22 * a11) - (a21 * a12);
	}
	
	public static void systemOfLinearEquation(double a11, double a12, double a21, double a22, double b1, double b2) {
		if (computeDetermination(a11,a12,a12,a22) != 0) {
			double x1 = (b1 * a22 - b2 * a12) / (a11 * a22 - a21 * a12);
			double x2 = (b1 * a21 - b2 * a11) / (a12 * a21 - a11 * a22);
			String output = "";
			output += "x1= " + x1 + "\n";
			output += "x2= " + x2;
			JOptionPane.showMessageDialog(null, output,"Solution", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			if ( (a12 * a22 == a11 * a21) && (b1 * a22 != a11 * b2 )) {
				JOptionPane.showMessageDialog(null,"This system does not have solution","Solution", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "This system has infinitely number of solutions","Solution", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public static void secondDegreeEquationOneVariable(double a, double b, double c) {
		double delta = Math.pow(b,2) - 4*a*c;
		if (delta < 0) {
			JOptionPane.showMessageDialog(null, "This equation does not have solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (delta == 0) {
			double x = -b/(2*a);
			String output = "This equation has single solution x= " + x;
			JOptionPane.showMessageDialog(null, output, "Solution", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			double tmp = Math.sqrt(delta);
			double x1 = (-b + tmp) / (2 * a);
			double x2 = (-b - tmp) / (2 * a);
			String output = "Solutions of the equation is: \n";
			output += "x1= " + x1 + "\n";
			output += "x2= " + x2;
			JOptionPane.showMessageDialog(null, output, "Solution", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	
	
	
}
