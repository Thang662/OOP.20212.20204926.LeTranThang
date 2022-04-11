// Exercise 2.2.6
import javax.swing.JOptionPane;

public class Equation_solve {
	//Linear equation
	public static void linearEquation(double a, double b) {
		if (a != 0) {
			JOptionPane.showMessageDialog(null, "x =" + (-b / a),"Result", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (a == 0 && b != 0){
			JOptionPane.showMessageDialog(null, "The equation has no solution","Result", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "The equation has infinite solutions","Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Linear system equation
	public static void linearSystemEquation(double a1, double b1, double c1, double a2, double b2, double c2) {
		if (a1 * b2 - a2 * b1 != 0) {
			JOptionPane.showMessageDialog(null, "x1 = " + ((c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1)) + "\n" + "x2 = " + + ((c1 * a2 - c2 * a1) / (b1 * a2 - a1 * b2)),"Result", JOptionPane.INFORMATION_MESSAGE);
		}
		else if ((b1 * b2 == a1 * a2) && (c1 * b2 != c2 * a1)) {
			JOptionPane.showMessageDialog(null, "This system has no solution", "Result", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "This system has infinitely solutions", "Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Second degree equation
	public static void secondDegreeEquation(double a, double b, double c) {
		double delta = Math.pow(b,2) - 4*a*c;
		if (delta < 0) {
			JOptionPane.showMessageDialog(null, "This equation has no solution", "Result", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (delta == 0) {
			double x = -b/(2*a);
			String output = "This equation has one solution x= " + x;
			JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			double temp = Math.sqrt(delta);
			double x1 = (-b + temp) / (2 * a);
			double x2 = (-b - temp) / (2 * a);
			String output = "Solutions of the equation is: \n";
			output += "x1= " + x1 + "\n";
			output += "x2= " + x2;
			JOptionPane.showMessageDialog(null, output, "Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		//Input and display result
		int option = Integer.parseInt(JOptionPane.showInputDialog(null,"What type of equation you want to solve?\n" + 
				"1: The first-degree equation (linear equation) with one variable\n" +
				"2: The system of first-degree equations (linear system) with two variables\n" + 
				"3: The second-degree equation with one variable\n", JOptionPane.QUESTION_MESSAGE));
		if (option > 3 || option < 1) {
			JOptionPane.showMessageDialog(null, "Please choose a number from 1 to 3","Invalid value", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (option == 1) {
			String strA = JOptionPane.showInputDialog(null,"Please input a:	", "Input a", JOptionPane.INFORMATION_MESSAGE);
			String strB = JOptionPane.showInputDialog(null,"Please input b:	", "Input b", JOptionPane.INFORMATION_MESSAGE);
			double a = Double.parseDouble(strA);
			double b = Double.parseDouble(strB);
			linearEquation(a,b);
		}
		else if (option == 2) {
			String strA1 = JOptionPane.showInputDialog(null,"Please input a1:	", "Input a1", JOptionPane.INFORMATION_MESSAGE);
			String strB1 = JOptionPane.showInputDialog(null,"Please input b1:	", "Input b1", JOptionPane.INFORMATION_MESSAGE);
			String strC1 = JOptionPane.showInputDialog(null,"Please input c1:	", "Input c1", JOptionPane.INFORMATION_MESSAGE);
			String strA2 = JOptionPane.showInputDialog(null,"Please input a2:	", "Input a2", JOptionPane.INFORMATION_MESSAGE);
			String strB2 = JOptionPane.showInputDialog(null,"Please input b2:	", "Input b2", JOptionPane.INFORMATION_MESSAGE);
			String strC2 = JOptionPane.showInputDialog(null,"Please input c2:	", "Input c2", JOptionPane.INFORMATION_MESSAGE);
			double a1 = Double.parseDouble(strA1);
			double b1 = Double.parseDouble(strB1);
			double c1 = Double.parseDouble(strC1);
			double a2 = Double.parseDouble(strA2);
			double b2 = Double.parseDouble(strB2);
			double c2 = Double.parseDouble(strC2);
			linearSystemEquation(a1, b1, c1, a2, b2, c2);
		}
		else {
			String strA = JOptionPane.showInputDialog(null,"Please input a:	", "Input a", JOptionPane.INFORMATION_MESSAGE);
			String strB = JOptionPane.showInputDialog(null,"Please input b:	", "Input b", JOptionPane.INFORMATION_MESSAGE);
			String strC = JOptionPane.showInputDialog(null,"Please input c:	", "Input c", JOptionPane.INFORMATION_MESSAGE);
			double a = Double.parseDouble(strA);
			double b = Double.parseDouble(strB);
			double c = Double.parseDouble(strC);
			secondDegreeEquation(a, b, c);
		}
		System.exit(0);
	}
}

