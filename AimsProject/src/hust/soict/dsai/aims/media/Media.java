package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	private static int nbMedia = 0;
	private LocalDate dateAdded;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
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
				if (tokens1[i].toLowerCase().contains(tokens2[j].toLowerCase())) {
					check = true;
					break;
				}
			}
		}
		return check;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Media)) {
			return false;
		}
		else {
			return this.getId() == ((Media) o).getId();
		}
	}

	@Override
	public int compareTo(Media media) throws NullPointerException {
		// TODO Auto-generated method stub
		if (media == null) {
			throw new NullPointerException("ERROR: null object");
		}
		else if (this.getTitle().compareTo(media.getTitle()) < 0) {
			return -1;
		}
		else if (this.getTitle().compareTo(media.getTitle()) == 0 & this.getCategory().compareTo(media.getCategory()) < 0) {
			return -1;
		}
		return 1;
	}
	
	public abstract String getDetails();
}
