import java.util.Arrays;

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
				if (itemsOrdered[i].getTitle() == disc.getTitle()) {
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
	
}
