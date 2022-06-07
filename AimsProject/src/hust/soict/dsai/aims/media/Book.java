package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Arrays;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
	}	

	// Constructor with title, category, cost, authors
	public Book(String title, String category, float cost, String[] authors) {
		super(title, category, cost);
		this.authors.addAll(Arrays.asList(authors));
	}
	
	// Constructor with title, category, cost
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	// Constructor with title
	public Book(String title) {
		super(title);
	}
	
	/*
	 * Getters and setters
	 */
	public ArrayList<String> getAuthors() {
		return authors;
	}
	
	// Add author(s) to the book
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("The author's name is already in the book");
		}
		else {
			authors.add(authorName);
			System.out.println("The author's name has been successfully added to the book");
		}
	}
	
	// Remove author(s) from the book
	public void removeAuthor(String authorName) {
		if (authors.isEmpty()) {
			System.out.println("There isn't any author for this book");
		}
		else if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("The author's name has been successfully removed to the book");
		}
		else {
			System.out.println("The author's name is not in the book");
		}
	}
	
	// Format the way to print book
	@Override
	public String toString() {
		String str = String.format("Book - Title:%-20s - Category:%-20s - Author(s):%-20s - Cost:%.2f$", this.getTitle(),
				this.getCategory(), this.getAuthors(), this.getCost());
		return str;
	}
}