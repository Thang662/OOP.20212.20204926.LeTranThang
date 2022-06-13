package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.MediaUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered =  FXCollections.observableArrayList();
	
	/*
	 * Getters and setters
	 */
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	// Add a single media to the current cart
	public void addMedia(Media media) {
		if (this.itemsOrdered.size() + 1 <= MAX_NUMBERS_ORDERED & !(this.itemsOrdered.contains(media))) {
			this.itemsOrdered.add(media);
			System.out.println("The media has been added");
		}
		else if (this.itemsOrdered.contains(media)) {
			System.out.println("The media " + media.getTitle() + " is already in the cart");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	// Add a list of medias to the current cart 
	public void addMedia(Media... medias) {
		if (this.itemsOrdered.size() + medias.length <= MAX_NUMBERS_ORDERED) {
			for (Media media: medias) {
				if (this.itemsOrdered.contains(media)) {
					System.out.println("The media " + media.getTitle() + " is already in the cart");
				}
				else {
					this.itemsOrdered.add(media);
					System.out.println("The media has been added");
				}
			}
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
		
	// Add a media with multiple times to the current cart
//	public void addMedia(Media media, int times) {
//		if (this.itemsOrdered.size() + times <= MAX_NUMBERS_ORDERED) {
//			for (int i = 0; i < times; i++) {
//				this.itemsOrdered.add(media);
//			}
//			System.out.println("The disc has been added");
//		}
//		else {
//			System.out.println("The cart is almost full");
//		}
//	}
		
	// Add two different medias to the current cart
	public void addMedia(Media media1, Media media2) {
		if (this.itemsOrdered.size() + 2 <= MAX_NUMBERS_ORDERED) {
			if (this.itemsOrdered.contains(media1)) {
				System.out.println("The media " + media1.getTitle() + " is already in the cart");
			}
			else {
				this.itemsOrdered.add(media1);
				System.out.println("The media has been added");
			}
			if (this.itemsOrdered.contains(media2)) {
				System.out.println("The media " + media2.getTitle() + " is already in the cart");
			}
			else {
				this.itemsOrdered.add(media2);
				System.out.println("The media has been added");
			}
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	// Remove all the media(s) with the same title from the current cart
	public int removeMedia(Media disc) {
		int nummediaRemoved = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getTitle().equalsIgnoreCase(disc.getTitle())) {
				this.itemsOrdered.remove(i);
				i--;
				nummediaRemoved++;
			}
		}
		return nummediaRemoved;
	}
		
	// Compute the cost of the cart 
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			cost += this.itemsOrdered.get(i).getCost();
		}
		return cost;
	}
	
	// Compute the cost of the cart with one free item
	public float totalCost(int luckyNum) {
		float cost = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (i == luckyNum) continue;
			else cost += this.itemsOrdered.get(i).getCost();
		}
		return cost;
	}
	
	// Randomly pick an item for free if order equal or greater than 5 items
	public int getALuckyItem() {
		int luckyNum = (int) (Math.random() * this.itemsOrdered.size());
		System.out.println("The " + this.itemsOrdered.get(luckyNum).getTitle() + " media is a free and lucky item");
		return luckyNum;
	}
	
	// Print the list of ordered items of the cart
	// Sort the items in the cart by class, alphabetical order, then by cost (decreasing)
	public void print() {
		System.out.println("**************************CART**************************");
		System.out.println("Ordered Items:");
		Media temp;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			for (int j = i + 1; j < this.itemsOrdered.size(); j++) {
				if (this.itemsOrdered.get(j).getClass().toString().compareTo(this.itemsOrdered.get(i).getClass().toString()) < 0) {
					temp = this.itemsOrdered.get(i);
					this.itemsOrdered.set(i, this.itemsOrdered.get(j));
					this.itemsOrdered.set(j, temp);
				}
				else if (this.itemsOrdered.get(j).getClass().toString().compareTo(this.itemsOrdered.get(i).getClass().toString()) == 0 
						&& MediaUtils.compareByTitle(this.itemsOrdered.get(i), this.itemsOrdered.get(j)) < 0) {
					temp = this.itemsOrdered.get(i);
					this.itemsOrdered.set(i, this.itemsOrdered.get(j));
					this.itemsOrdered.set(j, temp);
				}
				else if (this.itemsOrdered.get(j).getClass().toString().compareTo(this.itemsOrdered.get(i).getClass().toString()) == 0
						&& MediaUtils.compareByTitle(this.itemsOrdered.get(i), this.itemsOrdered.get(j)) == 0
						&& MediaUtils.compareByCost(this.itemsOrdered.get(i), this.itemsOrdered.get(j)) < 0) {
					temp = this.itemsOrdered.get(i);
					this.itemsOrdered.set(i, this.itemsOrdered.get(j));
					this.itemsOrdered.set(j, temp);
				}
			}
		}
		
		System.out.println(this.itemsOrdered.size());
		for (int i=0; i < this.itemsOrdered.size(); i++) {
			System.out.println(String.format("%02d", i + 1) + "." + this.itemsOrdered.get(i).toString());
		}
		if (this.itemsOrdered.size() < 5) System.out.println(String.format("Total cost: %.3f", this.totalCost()));
		else System.out.println(String.format("Total cost: %.3f", this.totalCost((getALuckyItem()))));
		System.out.println("*********************************************************");
	}
	
	// Print the list of ordered items of the cart
	// Sort the items in the cart by class, alphabetical order, then by cost (decreasing)
	public ObservableList<Media> display() {
		System.out.println("**************************CART**************************");
		System.out.println("Ordered Items:");
		Media temp;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			for (int j = i + 1; j < this.itemsOrdered.size(); j++) {
				if (this.itemsOrdered.get(j).getClass().toString().compareTo(this.itemsOrdered.get(i).getClass().toString()) < 0) {
					temp = this.itemsOrdered.get(i);
					this.itemsOrdered.set(i, this.itemsOrdered.get(j));
					this.itemsOrdered.set(j, temp);
				}
				else if (this.itemsOrdered.get(j).getClass().toString().compareTo(this.itemsOrdered.get(i).getClass().toString()) == 0 
						&& MediaUtils.compareByTitle(this.itemsOrdered.get(i), this.itemsOrdered.get(j)) < 0) {
					temp = this.itemsOrdered.get(i);
					this.itemsOrdered.set(i, this.itemsOrdered.get(j));
					this.itemsOrdered.set(j, temp);
				}
				else if (this.itemsOrdered.get(j).getClass().toString().compareTo(this.itemsOrdered.get(i).getClass().toString()) == 0
						&& MediaUtils.compareByTitle(this.itemsOrdered.get(i), this.itemsOrdered.get(j)) == 0
						&& MediaUtils.compareByCost(this.itemsOrdered.get(i), this.itemsOrdered.get(j)) < 0) {
					temp = this.itemsOrdered.get(i);
					this.itemsOrdered.set(i, this.itemsOrdered.get(j));
					this.itemsOrdered.set(j, temp);
				}
			}
		}
		System.out.println("Display all the medias in the cart");
		return itemsOrdered;
	}
	
	// Sort list of medias in the cart by cost
	public void sortByCost() {
		Media temp;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			for (int j = i + 1; j < this.itemsOrdered.size(); j++) {
				if (MediaUtils.compareByCost(this.itemsOrdered.get(i), this.itemsOrdered.get(j))== -1) {
					temp = this.itemsOrdered.get(i);
					itemsOrdered.set(i, itemsOrdered.get(j));
					itemsOrdered.set(j, temp);
				}
				else if (MediaUtils.compareByCost(this.itemsOrdered.get(i), this.itemsOrdered.get(j)) == 0
						  && MediaUtils.compareByTitle(this.itemsOrdered.get(i), this.itemsOrdered.get(j))== -1) {
						temp = this.itemsOrdered.get(i);
						itemsOrdered.set(i, itemsOrdered.get(j));
						itemsOrdered.set(j, temp);
				}
			}
		}
		System.out.println("Items in cart sorted by cost: ");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(String.format("%02d", i + 1) + "." + this.itemsOrdered.get(i).toString());
		}
	}
	
	// Sort list of medias in the cart by title alphabetically
	public void sortByTitle() {
		Media temp;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			for (int j = i + 1; j < this.itemsOrdered.size(); j++) {
				if (MediaUtils.compareByTitle(this.itemsOrdered.get(i), this.itemsOrdered.get(j))== -1) {
					temp = this.itemsOrdered.get(i);
					itemsOrdered.set(i, itemsOrdered.get(j));
					itemsOrdered.set(j, temp);
				}
				else if (MediaUtils.compareByTitle(this.itemsOrdered.get(i), this.itemsOrdered.get(j)) == 0
						  && MediaUtils.compareByCost(this.itemsOrdered.get(i), this.itemsOrdered.get(j))== -1) {
						temp = this.itemsOrdered.get(i);
						itemsOrdered.set(i, itemsOrdered.get(j));
						itemsOrdered.set(j, temp);
				}
			}
		}
		System.out.println("Items in cart sorted by title alphabetically: ");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(String.format("%02d", i + 1) + "." + this.itemsOrdered.get(i).toString());
		}
	}
	
	// Search media(s) by id and display it/them
	public void searchByID(int id) {
		int i = 0;
		int index = 0;
		int count = 0;
		while (i < this.itemsOrdered.size()) {
			if (this.itemsOrdered.get(i).getId() == id) {
				count += 1;
				index = i;
			}
			i += 1;
		}
		if (count > 0) {
			System.out.println("Found " + count + " media(s) in the cart");
			System.out.println(itemsOrdered.get(index).toString());
		}
		if (count == 0) {
			System.out.println("There is no such media in the cart");
		}
	}
	
	// Search media(s) by matching title and display it/them
	public void searchByTitle(String title) {
		int check = 0;
		int j = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).isMatch(title)) {
				check++;
				if (check == 1) System.out.println("Found media(s) have matching title");
				System.out.println(String.format("%02d", j + 1) + "." + this.itemsOrdered.get(i).toString());
				j++;
			}
		}
		if (check == 0) {
			System.out.println("No match is found");
		}
	}
}
