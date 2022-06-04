package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class Store {
	private static ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	
	// Add a list of dvd
	public static void addDVD(DigitalVideoDisc... dvds) {
		for (DigitalVideoDisc dvd: dvds){
			itemsInStore.add(dvd);
			System.out.println("The disc has been added to the store");
		}
	}
	
	// Remove all the dvd(s) with the same title from the store
	public static void removeDVD(String title) {
		int i = 0;
		boolean check = false;
		while (i < itemsInStore.size()) {
			if (itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
				itemsInStore.remove(i);
				check = true;
				continue;
			}
			i += 1;
		}
		if (!check) System.out.println("There's is no dvd with that name!");
		else System.out.println("Successfully delete the dvd(s) from the store");
	}
	
	// Display all the dvds in the store
	public static void display() {
		System.out.println("Display all the dvds available in the store");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(String.format("%02d", i + 1) + "." + itemsInStore.get(i).toString());
		}
	}
	
	// Search dvd by title
	public static DigitalVideoDisc searchByTitle(String title) {
		DigitalVideoDisc tempdvd = null;
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
				tempdvd = itemsInStore.get(i);
			};
		}
		return tempdvd;
	}
}