package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	private LocalDate dateAdded = LocalDate.now();
	private static int nbDigitalVideoDisc = 0;
	// Constructor with title, category, director, length, cost
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = DigitalVideoDisc.nbDigitalVideoDisc;
		DigitalVideoDisc.nbDigitalVideoDisc++;
	}
	
	// Constructor with title, category, director, cost
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = DigitalVideoDisc.nbDigitalVideoDisc;
		DigitalVideoDisc.nbDigitalVideoDisc++;
	}
	
	// Constructor with title, category, cost
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = DigitalVideoDisc.nbDigitalVideoDisc;
		DigitalVideoDisc.nbDigitalVideoDisc++;
	}
	
	// Constructor with title
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = DigitalVideoDisc.nbDigitalVideoDisc;
		DigitalVideoDisc.nbDigitalVideoDisc++;
	}
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	// Format the way to print dics
	@Override
	public String toString() {
		String str = String.format("DVD - Title:%-20s - Category:%-20s - Director:%-20s - Length:%-20d - Cost:%.2f$", this.getTitle(),
				this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
		return str;
	}
	
	// Check if the corresponding disk of the current object contains any token of title
	public boolean isMatch(String title) {
		boolean check = false;
		String[] tokens1 = this.getTitle().split(" ");
		String[] tokens2 = title.split(" ");
		for (int i = 0; i < tokens1.length; i++) {
			for (int j = 0; j < tokens2.length; j++) {
				if (tokens1[i].equalsIgnoreCase(tokens2[j])) {
					check = true;
					break;
				}
			}
		}
		return check;
	}
}

