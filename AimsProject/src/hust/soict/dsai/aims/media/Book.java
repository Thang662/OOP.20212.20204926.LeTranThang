package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.naming.LimitExceededException;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	private String content;
	
	public Book() {
		super();
	}
	
	// Constructor with title, category, cost, authors, content
		public Book(String title, String category, float cost, String[] authors, String content) {
			super(title, category, cost);
			this.authors.addAll(Arrays.asList(authors));
			this.content = content;
		}

	// Constructor with title, category, cost, authors
	public Book(String title, String category, float cost, String[] authors) {
		super(title, category, cost);
		this.authors.addAll(Arrays.asList(authors));
	}
	
	// Constructor with title, category, cost, content
	public Book(String title, String category, float cost, String content) {
		super(title, category, cost);
		this.content = content;
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
	
	public String getContent() {
		return content;
	}
	
	// Add author(s) to the book
	public void addAuthor(String authorName) throws IllegalArgumentException {
		if (authors.contains(authorName)) {
			System.out.println("The author's name is already in the book");
			throw new IllegalAccessError("ERROR: author is already in the list");
		}
		else {
			authors.add(authorName);
			System.out.println("The author's name has been successfully added to the book");
		}
	}
	
	// Remove author(s) from the book
	public void removeAuthor(String authorName) throws LimitExceededException {
		if (authors.isEmpty()) {
			System.out.println("There isn't any author for this book");
			throw new LimitExceededException("ERROR: the list of authors is empty");
		}
		else if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("The author's name has been successfully removed to the book");
		}
		else {
			System.out.println("The author's name is not in the book");
		}
	}
	
	// Process content of the book
	public TreeMap<String, Integer> processContent() {
		TreeMap<String, Integer> wordFrequency = new TreeMap<String, Integer>();
		if (!(this.getContent() == null)) {
			String[] contentTokens = this.getContent().split("[,. ()\":!?]");
			for (String str: contentTokens) {
				if (str.matches("[\\W]") || str.isEmpty()) continue;
				else if (wordFrequency.containsKey(str)) wordFrequency.put(str, wordFrequency.get(str) + 1);
				else wordFrequency.put(str, 1);
			}
		}
		return wordFrequency;
	}
	
	
	// Format the way to print book
	@Override
	public String toString() {
		String str = String.format("Book - Title:%-20s - Category:%-20s - Author(s):%-20s - Content length:%-10d - Cost:%.2f$", this.getTitle(),
				this.getCategory(), this.getAuthors(), this.processContent().values().stream().collect(Collectors.summingInt(Integer::intValue)), this.getCost());
		str += " - Token list: " + this.processContent().keySet() + " - Words frequency: " + this.processContent();
		return str;
	}
	
	@Override
	public String getDetails () {
		String str = String.format("Book - Title:%-20s - Category:%-20s - Author(s):%-20s - Content length:%-10d - Cost:%.2f$", this.getTitle(),
				this.getCategory(), this.getAuthors(), this.processContent().values().stream().collect(Collectors.summingInt(Integer::intValue)), this.getCost());
		return str;
	}
}