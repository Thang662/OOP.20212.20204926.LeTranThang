package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
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
}