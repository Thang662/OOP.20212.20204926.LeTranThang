package hust.soict.dsai.lab01.Exercise6_3;
import javax.swing.JOptionPane;
public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//Input
			String strHeight = JOptionPane.showInputDialog(null, "Please enter the height of the triangle: ", "Input", JOptionPane.INFORMATION_MESSAGE);
			int height = Integer.parseInt(strHeight);
			//Display result
			String res = "";
			for (int i = 1; i <= height; i++) {
				res += " ".repeat(height - i);
				res += "*".repeat(i * 2 - 1);
				res += "\n";
			}
			JOptionPane.showMessageDialog(null, res, "Result", JOptionPane.INFORMATION_MESSAGE);
			System.out.print(res);
	}

}
