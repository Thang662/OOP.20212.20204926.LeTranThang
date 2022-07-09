package hust.soict.dsai.test.cart;
import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) throws LimitExceededException, NullPointerException {
		//Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spider-Man",
				"Action", 20.99f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 90, 21.95f);
		cart.addMedia(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 20.95f);
		cart.addMedia(dvd6);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 86, 20.95f);
		cart.addMedia(dvd7);
		cart.addMedia(dvd7);
		cart.addMedia(dvd7);
		cart.addMedia(dvd7);
		
		//Test the sort method
		cart.sortByCost();
		cart.sortByTitle();
		
//		//Test the search method
		cart.searchByID(1);  
		cart.searchByID(5);  
		cart.searchByTitle("King");
		cart.removeMedia(dvd6);
		
		//Create new cd objects and add them to the cart
		CompactDisc cd = new CompactDisc("King Kong", "Action", 20.99f);
		cart.addMedia(cd);
		
		//Test the print method
		cart.print();
	}

}