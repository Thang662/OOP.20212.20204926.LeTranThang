package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	
	// Constructor with title, category, director, cost, artist, tracks
	public CompactDisc(String title, String category, String director, float cost, String artist, Track[] tracks) {
		super(title, category, director, cost);
		this.artist = artist;
		this.tracks.addAll(Arrays.asList(tracks));
	}
	
	// Constructor with title, category, director, cost, artist
	public CompactDisc(String title, String category, String director, float cost, String artist) {
		super(title, category, director, cost);
		this.artist = artist;
	}
	
	// Constructor with title, category, director, cost
	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	// Constructor with title, category, cost
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	// Constructor with title
	public CompactDisc(String title) {
		super(title);
	}
	
	/*
	 * Getters and setters
	 */
	public String getArtist() {
		return artist;
	}
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}
	
	// Add track to the tracks list
	public void addTrack(Track track) {
		if (track == null) {
			System.out.println("Can not add a null object to the track list");
		}
		else if (this.tracks.contains(track)) {
			System.out.println(String.format("The track %s is already in the track list", track.getTitle()));
		}
		else {
			this.tracks.add(track);
			System.out.println(String.format("The track %s has been added to the track list", track.getTitle()));
		}
	}

	// Remove track from the tracks list
	public void removeTrack(Track track) {
		if (track == null) {
			System.out.println("Can not remove a null object from the track list");
		}
		else if (!this.tracks.contains(track)) {
			System.out.println(String.format("The track %s is not in the track list", track.getTitle()));
		}
		else {
			this.tracks.remove(track);
			System.out.println(String.format("The track %s has been removed from the track list", track.getTitle()));
		}
	}
	
	// Compute the length of all track(s)
	@Override
	public int getLength() {
		int totalLength = 0;
		for (Track track: this.tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	// Implements play method
	@Override
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("The CD " + this.getTitle() + " can't be played because the length is 0");
		}
		else {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD total length: " + this.getLength());
			for (Track track: this.tracks) {
				track.play();
			}
		}
	}
	
	// Format the way to print cd
	@Override
	public String toString() {
		String str = String.format("CD - Title:%-20s - Category:%-20s - Artist:%-20s - Director:%-20s - Length:%-10d - Cost:%.2f$\n", this.getTitle(),
				this.getCategory(),this.getArtist(), this.getDirector(), this.getLength(), this.getCost());
		for (Track track: this.getTracks()) {
			str += "Track - Title:" + track.getTitle() + " - Length: " + track.getLength();
		}
		return str;
	}
	
	// Format the way to get cd's details
	@Override
	public String getDetails () {
		String str = String.format("CD - Title:%-20s - Category:%-20s - Artist:%-20s - Director:%-20s - Length:%-10d - Cost:%.2f$\n", this.getTitle(),
				this.getCategory(),this.getArtist(), this.getDirector(), this.getLength(), this.getCost());
		return str;
	}
}
