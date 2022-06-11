package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;
public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	/*
	 * Getters and setters
	 */
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
	// Add a list of media
	public  void addMedia(Media... medias) {
		for (Media media: medias){
			itemsInStore.add(media);
			System.out.println("The media has been added to the store");
		}
	}
	
	// Remove all the media(s) with the same title from the store
	public  void removeMedia(String title) {
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
		if (!check) System.out.println("There's is no media with that name!");
		else System.out.println("Successfully delete the media(s) with name from the store");
	}
	
	// Display all the medias in the store
	public ArrayList<Media> display() {
		System.out.println("**************************STORE**************************");
		System.out.println("Ordered Items:");
		Media temp;
		for (int i = 0; i < this.itemsInStore.size(); i++) {
			for (int j = i + 1; j < this.itemsInStore.size(); j++) {
				if (this.itemsInStore.get(j).getClass().toString().compareTo(this.itemsInStore.get(i).getClass().toString()) < 0) {
					temp = this.itemsInStore.get(i);
					this.itemsInStore.set(i, this.itemsInStore.get(j));
					this.itemsInStore.set(j, temp);
				}
				else if (this.itemsInStore.get(j).getClass().toString().compareTo(this.itemsInStore.get(i).getClass().toString()) < 0 
						&& MediaUtils.compareByTitle(this.itemsInStore.get(i), this.itemsInStore.get(j)) == 0) {
					temp = this.itemsInStore.get(i);
					this.itemsInStore.set(i, this.itemsInStore.get(j));
					this.itemsInStore.set(j, temp);
				}
				else if (this.itemsInStore.get(j).getClass().toString().compareTo(this.itemsInStore.get(i).getClass().toString()) < 0
						&& MediaUtils.compareByTitle(this.itemsInStore.get(i), this.itemsInStore.get(j)) == 0
						&& MediaUtils.compareByCost(this.itemsInStore.get(i), this.itemsInStore.get(j)) == 0) {
					temp = this.itemsInStore.get(i);
					this.itemsInStore.set(i, this.itemsInStore.get(j));
					this.itemsInStore.set(j, temp);
				}
			}
		}
		System.out.println("Display all the medias available in the store");
		return itemsInStore;
	}
	
	// Search media by title
	public  Media searchByTitle(String title) {
		Media tempMedia = null;
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
				tempMedia = itemsInStore.get(i);
			};
		}
		return tempMedia;
	}
}