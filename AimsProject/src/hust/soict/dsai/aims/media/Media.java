package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	private static int nbMedia = 0;
	private LocalDate dateAdded;
	public Media() {
		// TODO Auto-generated constructor stub
		super();
		this.id = Media.nbMedia;
		Media.nbMedia++;
		this.dateAdded = LocalDate.now();
	}
	
	// Constructor with title, category, cost
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = Media.nbMedia;
		Media.nbMedia++;
		this.dateAdded = LocalDate.now();
	}
	
	// Constructor with title
	public Media(String title) {
		super();
		this.title = title;
		this.id = Media.nbMedia;
		Media.nbMedia++;
		this.dateAdded = LocalDate.now();
	}
	
	/*
	 * Getters and setters
	 */
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public static int getNbMedia() {
		return nbMedia;
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
