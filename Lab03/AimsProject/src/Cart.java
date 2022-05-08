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
	
	// Compute the cost of the cart 
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	
}
