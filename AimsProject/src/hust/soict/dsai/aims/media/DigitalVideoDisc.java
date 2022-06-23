package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	// Constructor with title, category, director, length, cost
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	// Constructor with title, category, director, cost
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	// Constructor with title, category, cost
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	// Constructor with title
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	// Format the way to print dvd
	@Override
	public String toString() {
		String str = String.format("DVD - Title:%-20s - Category:%-20s - Director:%-20s - Length:%-20d - Cost:%.2f$", this.getTitle(),
				this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
		return str;
	}
	
	// Format the way to get dvd's details
		@Override
		public String getDetails () {
			String str = String.format("DVD - Title:%-20s - Category:%-20s - Director:%-20s - Length:%-20d - Cost:%.2f$", this.getTitle(),
					this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
			return str;
		}
	
	// Implements play method
	@Override
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("The DVD " + this.getTitle() + " can't be played since the length is 0");
		}
		else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
	}
}

