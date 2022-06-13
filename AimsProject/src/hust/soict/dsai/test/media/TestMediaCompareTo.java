package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("King Kong", "Action", 20.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spider-Man", "Action", 20.99f);
		
		Collection collection = new ArrayList();
		collection.add(dvd1);
		collection.add(dvd5);
		collection.add(dvd4);
		collection.add(dvd3);
		collection.add(dvd2);
		
		Iterator iterator = collection.iterator ();
		
		System.out.println("The DVDs currently in the order are: ");

		while (iterator.hasNext()) {
		System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		Collections.sort((List) collection, Media.COMPARE_BY_COST_TITLE);
		
		System.out.println("The DVDs in sorted order are: ");
		iterator = collection.iterator ();
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		Collections.sort((List) collection, Media.COMPARE_BY_TITLE_COST);
		
		System.out.println("The DVDs in sorted order are: ");
		iterator = collection.iterator ();
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
	}
}
