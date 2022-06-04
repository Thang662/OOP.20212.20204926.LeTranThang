package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spider-Man",
				"Action", 20.99f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 90, 21.95f);
		cart.addDigitalVideoDisc(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 20.95f);
		cart.addDigitalVideoDisc(dvd6);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 86, 20.95f);
		cart.addDigitalVideoDisc(dvd7);
		cart.addDigitalVideoDisc(dvd7);
		cart.addDigitalVideoDisc(dvd7);
		cart.addDigitalVideoDisc(dvd7);
		
		//Test the sort method
		cart.sortByCost();
		cart.sortByTitle();
		
//		//Test the search method
		cart.searchByID(1);  
		cart.searchByID(5);  
		cart.searchByTitle("King");
		cart.removeDigitalVideoDisc(dvd6);
		
		//Test the print method
		cart.print();
	}

}