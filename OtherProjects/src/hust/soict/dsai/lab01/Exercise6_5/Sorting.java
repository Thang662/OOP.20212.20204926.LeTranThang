package hust.soict.dsai.lab01.Exercise6_5;
import javax.swing.JOptionPane;

public class Sorting {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input
		String input = JOptionPane.showInputDialog(null, "Please enter an array: ", "Input", JOptionPane.INFORMATION_MESSAGE);
		String[] arr =  input.split(" ");
		double[] numbers = new double[arr.length];
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			numbers[i] = Double.parseDouble(arr[i]);
			sum += numbers[i];
		}
		
		//Sorting
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j ++) {
				if (numbers[i] > numbers[j]) {
					double temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		//Display result
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			res += numbers[i] + " ";
		}
		JOptionPane.showMessageDialog(null,"The array after sorting: " + res + "\n" + "Sum: " + sum + "\n" + "Average: " + (sum / arr.length), "Result", JOptionPane.INFORMATION_MESSAGE);
	}
}
