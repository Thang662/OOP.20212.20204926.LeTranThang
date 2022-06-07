package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class DiskTest {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);
		anOrder.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addMedia(dvd3);
				
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("King Kong", "Action", 20.99f);
		anOrder.addMedia(dvd4);
		
		//Test the isMatch method
		System.out.println(dvd1.isMatch("King Athur"));  //true
		System.out.println(dvd2.isMatch("King Athur"));  //false
		
		//Test the searchByTitle method
		anOrder.searchByTitle("King Athur"); //display 2 matching DVDs
		anOrder.searchByTitle("Gumball"); //no match found
	}

}
