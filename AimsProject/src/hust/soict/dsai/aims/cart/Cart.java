package hust.soict.dsai.aims.cart;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	private static int qtyOrdered;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	// Add a single dvd to the current cart
	public int addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered + 1 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
		return qtyOrdered;
	}
	
	// Add a list of dvds to the current cart 
		public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
			if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
				for (int i = 0; i < dvdList.length; i++) {
					itemsOrdered[qtyOrdered] = dvdList[i];
					qtyOrdered++;
				}
				System.out.println("The disc has been added");
			}
			else {
				System.out.println("The cart is almost full");
			}
		}
		
	// Add a dvd with multiple times to the current cart
		public void addDigitalVideoDisc(DigitalVideoDisc disc, int times) {
			if (qtyOrdered + times <= MAX_NUMBERS_ORDERED) {
				for (int i = 0; i < times; i++) {
					itemsOrdered[qtyOrdered] = disc;
					qtyOrdered++;
				}
				System.out.println("The disc has been added");
			}
			else {
				System.out.println("The cart is almost full");
			}
		}
		
	// Add two different dvds to the current cart
		public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
			if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = dvd1;
				qtyOrdered++;
				itemsOrdered[qtyOrdered] = dvd2;
				qtyOrdered++;
				System.out.println("The disc has been added");
			}
			else {
				System.out.println("The cart is almost full");
			}
		}
	
	// Remove all the dvd(s) with the same title from the current cart
		public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
			int numDvdRemoved = 0;
			for (int i = 0; i < qtyOrdered; i++) {
				if (itemsOrdered[i].getTitle().equalsIgnoreCase(disc.getTitle())) {
					for (int j = i + 1; j < qtyOrdered; j ++) {
						itemsOrdered[j - 1] = itemsOrdered[j];
					}
					i--;
					numDvdRemoved++;
					qtyOrdered--;
				}
			}
			return numDvdRemoved;
		}
		
	// Compute the cost of the cart 
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	
	// Print the list of ordered items of the cart
	// Sort the items in the cart by alphabetical order, then by cost (decreasing), then by length (decreasing)
	public void print() {
		System.out.println("**************************CART**************************");
		System.out.println("Ordered Items:");
		DigitalVideoDisc temp;
		for (int i = 0; i < qtyOrdered; i++) {
			for (int j = i + 1; j < qtyOrdered; j++) {
				if (DVDUtils.compareByTitle(itemsOrdered[i], itemsOrdered[j]) == -1) {
					temp = itemsOrdered[i];
					itemsOrdered[i] = itemsOrdered[j];
					itemsOrdered[j] = temp;
				}
				else if (DVDUtils.compareByTitle(itemsOrdered[i], itemsOrdered[j]) == 0
					  && DVDUtils.compareByCost(itemsOrdered[i], itemsOrdered[j]) == -1) {
					temp = itemsOrdered[i];
					itemsOrdered[i] = itemsOrdered[j];
					itemsOrdered[j] = temp;
				}
				else if (DVDUtils.compareByTitle(itemsOrdered[i], itemsOrdered[j]) == 0
					  && DVDUtils.compareByCost(itemsOrdered[i], itemsOrdered[j]) == 0
					  && itemsOrdered[i].getLength() > itemsOrdered[j].getLength()) {
					temp = itemsOrdered[i];
					itemsOrdered[i] = itemsOrdered[j];
					itemsOrdered[j] = temp;
				}
			}
		}
		
		System.out.println(qtyOrdered);
		for (int i=0; i < qtyOrdered; i++) {
			System.out.println(String.format("%02d", i + 1) + "." + itemsOrdered[i].toString());
		}
		System.out.println(String.format("Total cost: %.3f", this.totalCost()));
		System.out.println("*********************************************************");
	}
	
	// Sort list of dvds in the cart by cost
	public void sortByCost() {
		DigitalVideoDisc temp;
		for (int i = 0; i < qtyOrdered; i++) {
			for (int j = i + 1; j < qtyOrdered; j++) {
				if (DVDUtils.compareByCost(itemsOrdered[i], itemsOrdered[j]) == -1) {
					temp = itemsOrdered[i];
					itemsOrdered[i] = itemsOrdered[j];
					itemsOrdered[j] = temp;
				}
				else if (DVDUtils.compareByCost(itemsOrdered[i], itemsOrdered[j]) == 0
						  && DVDUtils.compareByTitle(itemsOrdered[i], itemsOrdered[j]) == -1) {
						temp = itemsOrdered[i];
						itemsOrdered[i] = itemsOrdered[j];
						itemsOrdered[j] = temp;
				}
			}
		}
		System.out.println("Items in cart sorted by cost: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(String.format("%02d", i + 1) + "." + itemsOrdered[i].toString());
		}
	}
	
	// Sort list of dvds in the cart by title alphabetically
	public void sortByTitle() {
		DigitalVideoDisc temp;
		for (int i = 0; i < qtyOrdered; i++) {
			for (int j = i + 1; j < qtyOrdered; j++) {
				if (DVDUtils.compareByTitle(itemsOrdered[i], itemsOrdered[j]) == -1) {
					temp = itemsOrdered[i];
					itemsOrdered[i] = itemsOrdered[j];
					itemsOrdered[j] = temp;
				}
				else if (DVDUtils.compareByTitle(itemsOrdered[i], itemsOrdered[j]) == 0
						  && DVDUtils.compareByCost(itemsOrdered[i], itemsOrdered[j]) == -1) {
						temp = itemsOrdered[i];
						itemsOrdered[i] = itemsOrdered[j];
						itemsOrdered[j] = temp;
				}
			}
		}
		System.out.println("Items in cart sorted by title alphabetically: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(String.format("%02d", i + 1) + "." + itemsOrdered[i].toString());
		}
	}
	
	// Search dvd(s) by id and display it/them
	public void searchByID(int id) {
		int i = 0;
		int index = 0;
		int count = 0;
		while (i < qtyOrdered) {
			if (itemsOrdered[i].getId() == id) {
				count += 1;
				index = i;
			}
			i += 1;
		}
		if (count > 0) {
			System.out.println("Found " + count + " DVD(s) in the cart");
			System.out.println(itemsOrdered[index].toString());
		}
		if (count == 0) {
			System.out.println("There is no such DVD in the cart");
		}
	}
	
	// Search dvd(s) by matching title and display it/them
	public void searchByTitle(String title) {
		int check = 0;
		int j = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				check++;
				if (check == 1) System.out.println("Found dvd(s) have matching title");
				System.out.println(String.format("%02d", j + 1) + "." + itemsOrdered[i].toString());
				j++;
			}
		}
		if (check == 0) {
			System.out.println("No match is found");
		}
	}
}
