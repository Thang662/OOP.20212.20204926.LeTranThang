package hust.soict.dsai.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// File size 113KB, takes 2203 miliseconds
		String filename = "C:\\Users\\Thang\\Downloads\\SAMPLE_1- Academic-manuscriptsA.ppt";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b: inputBytes) {
			outputString += (char)b;
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
