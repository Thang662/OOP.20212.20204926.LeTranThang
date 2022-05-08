
public class Aims {

	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();
		// Create a new dvd object and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd4);
		
		// Remove dvd from the cart
		anOrder.removeDigitalVideoDisc(dvd3);
		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3, dvd4};
		anOrder.addDigitalVideoDisc(dvdList);
		anOrder.addDigitalVideoDisc(dvd4, dvd2);
		anOrder.addDigitalVideoDisc(dvd1, 4);
		anOrder.addDigitalVideoDisc(dvd1, 4);
		anOrder.addDigitalVideoDisc(dvd1, 4);
		anOrder.addDigitalVideoDisc(dvd1, 4);
		
		// print total cost of the items in the cart
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
	}

}
