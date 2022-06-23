package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	
	// Constructor with title, category, director, length, cost
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	// Constructor with title, category, director, cost
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	
	// Constructor with title, category, cost
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	// Constructor with title
	public Disc(String title) {
		super(title);
	}
	
	/*
	 * Getters and setters
	 */
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
