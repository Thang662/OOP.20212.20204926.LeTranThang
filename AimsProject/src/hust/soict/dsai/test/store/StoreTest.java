package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("King Kong", "Action", 20.99f);
		
		Store.addDVD(dvd1);
		Store.addDVD(dvd2);
		Store.addDVD(dvd3);
		Store.addDVD(dvd4);
		Store.addDVD(dvd2, dvd4);
		Store.display();
		
		System.out.println("-----------------------------------------------------------------");
		
		Store.removeDVD("King Kong");
		Store.display();
	}

}
