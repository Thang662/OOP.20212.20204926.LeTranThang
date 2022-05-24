package hust.soict.dsai.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// File size 326MB, takes 996 miliseconds
		String filename = "C:\\Users\\Thang\\Downloads\\binance-BTCUSDT-1m.csv";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startTime = System.currentTimeMillis();
		StringBuilder outputString = new StringBuilder();
		for (byte b: inputBytes) {
			outputString.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}

