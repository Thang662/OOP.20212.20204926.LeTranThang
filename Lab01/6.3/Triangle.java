

import java.util.Scanner;
public class Triangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int gap = 2 *n +1;
		String res = "";
		for (int i = 0; i< n; i++ ) {
			int m = (gap - (i*2 +1))/2 - 1;
			String line = " ".repeat(m);
			res += line + "*".repeat(i*2 +1) + line + "\n";
		}
		System.out.println(res);}
}
