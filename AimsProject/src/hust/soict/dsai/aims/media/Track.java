package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	public Track() {
		// TODO Auto-generated constructor stub
	}
	
	// Constructor with title, length
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	/*
	 * Getters and setters
	 */
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	@Override
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("The track " + this.getTitle() + " can't be played since the length is 0");
		}
		else {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
	}
}
