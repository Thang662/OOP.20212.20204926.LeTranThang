import javax.swing.JOptionPane;
public class MatrixSum {
	public static void main(String[] args) {
		String row = JOptionPane.showInputDialog(null, "Please type the number of rows of your matrix:	", "The number of rows of your Matrix", JOptionPane.INFORMATION_MESSAGE);
		String column = JOptionPane.showInputDialog(null, "Please type the number of columns of your matrix:	", "The number of columns of your Matrix", JOptionPane.INFORMATION_MESSAGE);
		int n = Integer.parseInt(row) ; 
		int m = Integer.parseInt(column) ; 
		int[][] matrix1 = new int[m][n];
		int[][] matrix2 = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			String[] input = JOptionPane.showInputDialog(null, "Please type row " + (i+1),"Type the value of each row for the 1st matrix", JOptionPane.INFORMATION_MESSAGE).split(" ");
			for (int j = 0; j < n; j++) {
				matrix1[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0; i < m; i++) {
			String[] input = JOptionPane.showInputDialog(null, "Please type row " + (i+1),"Type the value of each row for the 2nd matrix", JOptionPane.INFORMATION_MESSAGE).split(" ");
			for (int j = 0; j < n; j++) {
				matrix2[i][j] = Integer.parseInt(input[j]);
			}
		}
		addTwoMatrices(matrix1,matrix2);
	}
	
	public static void addTwoMatrices(int[][] matrix1, int[][] matrix2) {
		int m = matrix1.length;
		int n = matrix1[0].length;
		String res = "";
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				double r = matrix1[i][j]+ matrix2[i][j];
				res += r + " ";	
			}res += "\n";
		}
		JOptionPane.showMessageDialog(null, res, "Result:", JOptionPane.INFORMATION_MESSAGE);
	}

}
