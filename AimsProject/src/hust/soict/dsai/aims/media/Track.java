package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			System.out.println("The track " + this.getTitle() + " can't be played since the length is 0");
			throw new PlayerException("ERROR: Track length is non-positive !");
		}
		else {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Track)) {
			return false;
		}
		else {
			return (this.getTitle() == ((Track) o).getTitle() & this.getLength() == ((Track) o).getLength());
		}
	}
}
