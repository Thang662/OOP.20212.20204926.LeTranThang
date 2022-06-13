package hust.soict.dsai.aims;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.CartScreenController;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ObservableList;
public class Aims {

	public static void main(String[] args) {
//		// Create a new cart
//		Cart anOrder = new Cart();
//		// Create a new dvd object and add them to the cart
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addMedia(dvd1);
//		
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		anOrder.addMedia(dvd2);
//		
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "", 90, 18.99f);
//		anOrder.addMedia(dvd3);
//		
//		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", "", 90, 18.99f);
//		anOrder.addMedia(dvd4);
//		
//		// Remove dvd from the cart
//		anOrder.removeDigitalVideoDisc(dvd3);
//		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3, dvd4};
//		anOrder.addMedia(dvdList);
//		anOrder.addMedia(dvd4, dvd2);
//		anOrder.addMedia(dvd1, 4);
//		anOrder.addMedia(dvd1, 4);
////		anOrder.addMedia(dvd1, 4);
////		anOrder.addMedia(dvd1, 4);
//		
//		// print total cost of the items in the cart
//		System.out.println("Total Cost is: ");
//		System.out.println(anOrder.totalCost());
//		anOrder.print();
//		anOrder.sortByCost();
//		anOrder.sortByTitle();
		
		Store store = new Store();
		String content = "The seeds for the eventual rise of the evil Empire are sown in a seemingly routine place: a trade dispute between the Republic and the Trade Federation. Two Jedi, the keepers of peace and justice, are dispatched to negotiate the dispute, but (wait for it) it's a trap! They end up barely escaping with their lives, though they do meet R2-D2, who saves their lives. They end up on remote Tatooine, where they meet slave boy Anakin Skywalker and his protocol droid C3PO. Jedi Qui-Gon Jinn senses the Force in Anakin - and believes he's the \"Chosen One\" who will bring balance to the Force. There's a podrace and Anakin is freed. Qui-Gon wants to train Anakin, but the Jedi Council knows something is up with this boy and rejects it. But he helps the Republic win a battle against the Trade Federation so the Council lets Obi-Wan Kenobi take him as his apprentice.";
		String content1 = "Some people believe that technology has made man more social. To what extent do you agree or disagree with this opinion?\r\n"
				+ "\r\n"
				+ "Experts throughout both the developing and developed world have debated whether the advent of sophisticated modern technology such as mobile phones, laptops and iPad have helped to enhance and improve people's social lives or whether the opposite has become the case.\r\n"
				+ "\r\n"
				+ "Personally, I strongly advocate the former view. This essay will discuss both sides using examples from the UK government and Oxford University to demonstrate points and prove arguments.\r\n"
				+ "\r\n"
				+ "On the one hand there is ample, powerful, almost daily evidence that such technology can be detrimental especially to the younger generation who are more easily affected by it’s addictive nature and which can result in people feeling more isolated from the society.\r\n"
				+ "\r\n"
				+ "The central reason behind this is twofold, firstly, the invention of online social media sites and apps, such as Twitter and Facebook have reduced crucial face-to-face interactions dramatically. Through use of these appealing and attractive mediums, people feel in touch and connected yet lack key social skills and the ability to communicate.\r\n"
				+ "\r\n"
				+ "Secondly, dependence on such devices is built up frighteningly easily which may have a damaging effect on mental health and encourage a sedentary lifestyle. For example, recent scientific research by the UK government demonstrated that 90% of people in their 30s spend over 20 hours per week on Messenger and similar applications to chat with their friends instead of meeting up and spending quality time together or doing sport. As a result, it is conclusively clear that these technology advancements have decreased and diminished our real life interactions.\r\n"
				+ "\r\n"
				+ "On the other hand, although there are significant downsides to technological developments, its’ multifold advantages cannot be denied. This is largely because the popularity of technology such as cellphones allows people to connect freely and easily with no geographical barriers.\r\n"
				+ "\r\n"
				+ "People are able to share any type of news, information, photos and opinions with their loved ones whenever and wherever they want therefore keeping a feeling of proximity and closeness. For example, an extensive study by Oxford University illustrated that people who work, or study abroad and use applications like Facetime and WhatsApp to chat with their families, are less likely to experience loneliness and feel out of the loop than those who do not.\r\n"
				+ "\r\n"
				+ "Consistent with this line of thinking is that businessmen are also undoubtedly able to benefit from these advances by holding virtual real-time meetings using Skype which may increase the chance of closing business deals without the need to fly.\r\n"
				+ "\r\n"
				+ "From the arguments and examples given I firmly believe that overall communication and mans’ sociability has been advanced enormously due to huge the huge technological progress of the past twenty years and despite some potentially serious health implications which governments should not fail to address, it is predicted that its popularity will continue to flourish in the future.";
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("King Kong", "Action", 20.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spider-Man", "Action", 20.99f);
		CompactDisc cd1 = new CompactDisc("The Lion King1", "Animation", "Roger Allers", 19.95f);
		CompactDisc cd2 = new CompactDisc("Star War1", "Sci-fi", "George Lucas", 24.95f);
		CompactDisc cd3 = new CompactDisc("Aladin1", "Animation", 18.99f);
		CompactDisc cd4 = new CompactDisc("King Kong1", "Action", 20.99f);
		CompactDisc cd5 = new CompactDisc("Spider-Man1", "Action", 20.99f);
		Book book1 = new Book("The Lion King2", "Animation", 19.95f);
		Book book2 = new Book("Star War2", "Sci-fi", 24.95f, content);
		Book book3 = new Book("Aladin2", "Animation", 18.99f);
		Book book4 = new Book("King Kong2", "Act1ion", 20.99f);
		Book book5 = new Book("Spider-Man2", "Action", 20.99f, content1);
		
		store.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, cd1, cd2, cd3, cd4, cd5, book1, book2, book3, book4, book5);
		
		boolean stopMenu = false;
		boolean stopStoreMenu = false;
		boolean stopUpdateStore = false;
		boolean stopCartMenu = false;
		int menuOption, storeMenuOption, updateStoreOption, cartMenuOption, filterCartOption, sortCartOption, addMediaMenuOption, idNum;
		String tempStr1, tempStr2, playableMedia;
		float tempFloat;
		ObservableList<Media> tempItemsOrdered;
		Cart anOrder = new Cart();
		Scanner sc = new Scanner(System.in);
		Media tempMedia = null;
		ArrayList<Media> tempMediaList = null;
		
//		anOrder.addMedia(book5, book1, cd1);
//		new CartScreen(anOrder);
//		new StoreScreen(store);
		/*
		 * AIMS Application
		 * The menu consists 3 parts: Store menu, Update store menu, Cart menu
		 * 	I. Store menu consists:
		 * 		1. See media's details
		 * 		2. Add a media to the cart
		 * 		3. Go to cart menu
		 * 		4. Go back to menu
		 * 	II. Update store menu consists:
		 * 		1. Add a media to the store (dvd, cd, book)
		 * 		2. Remove a media from the store
		 * 		3. Go back to menu
		 * 	III. Cart menu consist:
		 * 		1. Filter media(s) in the cart (by id/title)
		 * 		2. Sort media(s) in the cart (by title/cost)
		 * 		3. Remove media(s) from the cart
		 * 		4. Place an order
		 * 		5. Go back to menu
		 */
		while (!stopMenu) {
			Aims.showMenu();
			menuOption = Aims.input(3);
			stopStoreMenu = false;
			stopUpdateStore = false;
			stopCartMenu = false;
			/*
			 * Store options
			 */
			if (menuOption == 1) {
				while (!stopStoreMenu) {
					Aims.storeMenu();
					storeMenuOption = Aims.input(4);
					// See media's details
					if (storeMenuOption == 1) {
						System.out.println("----------------------------------------------------------------------------------");
						System.out.println("Please enter the title of the media:");
						tempMedia = store.searchByTitle(sc.nextLine());
						if (tempMedia == null) {
							System.out.println("There's no matching media in the store!");
						}
						else {
							System.out.println(tempMedia.toString());
						}
						Aims.promptEnterKey();
					}
					// Add a media to the cart
					else if (storeMenuOption == 2) {
						tempMediaList = store.display();
						for (int i = 0; i < tempMediaList.size(); i++) {
							System.out.println(String.format("%02d", i + 1) + "." + tempMediaList.get(i).toString());
						}
						System.out.println("----------------------------------------------------------------------------------");
						System.out.println("Please enter the title of the media to add to the cart:");
						tempMedia = store.searchByTitle(sc.nextLine());
						if (tempMedia == null) {
							System.out.println("There's no matching media in the store!");
						}
						else {
							anOrder.addMedia(tempMedia);
						}
						Aims.promptEnterKey();
					}
					// Go to cart menu 
					else if (storeMenuOption == 3) {
						menuOption = 3;
						stopStoreMenu = true;
					}
					// Play a media in the store
					else if (storeMenuOption == 4) {
						tempMediaList = store.display();
						for (int i = 0; i < tempMediaList.size(); i++) {
							playableMedia = (tempMediaList.get(i) instanceof Playable) ? " - Playble" : "";
							System.out.println(String.format("%02d", i + 1) + "." + tempMediaList.get(i).toString() + playableMedia);
						}
						System.out.println("----------------------------------------------------------------------------------");
						System.out.println("Please enter the title of the media in the store to play:");
						tempMedia = store.searchByTitle(sc.nextLine());
						if (tempMedia == null) {
							System.out.println("There's no matching media in the store!");
						}
						else if (tempMedia instanceof Playable){
							((Playable) tempMedia).play();
						}
						else {
							System.out.println("Can't play this media!");
						}
						Aims.promptEnterKey();
					}
					// Go back to menu
					else if (storeMenuOption == 0) {
						stopStoreMenu = true;
					}
				}
			}
			/*
			 * Update store options
			 */
			if (menuOption == 2) {
				while (!stopUpdateStore) {
					Aims.updateStore();
					updateStoreOption = Aims.input(2);
					// Add a media to the store
					if (updateStoreOption == 1) {
						Aims.addMediaMenu();
						addMediaMenuOption = Aims.input(3);
						if (addMediaMenuOption != 0) {
							System.out.println("Enter the title");
							tempStr1 = sc.nextLine();
							System.out.println("Enter the category");
							tempStr2 = sc.nextLine();
							System.out.println("Enter the cost");
							tempFloat = sc.nextFloat(); sc.nextLine();
							if (addMediaMenuOption == 1) store.addMedia(new DigitalVideoDisc(tempStr1, tempStr2, tempFloat));
							else if (addMediaMenuOption == 2) store.addMedia(new CompactDisc(tempStr1, tempStr2, tempFloat));
							else store.addMedia(new Book(tempStr1, tempStr2, tempFloat));
							Aims.promptEnterKey();
						}
					}
					// Remove a media from the store
					else if (updateStoreOption == 2) {
						System.out.println("Please enter the title of the media that you want to remove from the store:");
						store.removeMedia(sc.nextLine());
						Aims.promptEnterKey();
					}
					// Go back to menu
					else if (updateStoreOption == 0) {
						stopUpdateStore = true;
					}
				}
			}
			/*
			 * Cart options
			 */
			if (menuOption == 3) {
				while (!stopCartMenu) {
					Aims.cartMenu();
					cartMenuOption = Aims.input(5);
					// Filter media(s) in the cart
					if (cartMenuOption == 1) {
						Aims.filterCart();
						filterCartOption = Aims.input(2);
						// Filter by id
						if (filterCartOption == 1) {
							System.out.println("Please enter the ID of the media (from " + 0 + " to " + (Media.getNbMedia() - 1) + "):");
							idNum = Aims.input(Media.getNbMedia() - 1);
							anOrder.searchByID(idNum);
						}
						// Filter by title
						else if (filterCartOption == 2) {
							System.out.println("Please enter the title of the media:");
							anOrder.searchByTitle(sc.nextLine());
						}
						Aims.promptEnterKey();
					}
					// Sort media(s) in the cart
					else if (cartMenuOption == 2) {
						Aims.sortCart();
						sortCartOption = Aims.input(2);
						// Sort media(s) in the cart by title
						if (sortCartOption == 1) {
							anOrder.sortByTitle();
						}
						// Sort media(s) in the cart by cost
						else if (sortCartOption == 2) {
							anOrder.sortByCost();
						}
						Aims.promptEnterKey();
					}
					// Remove media(s) from the cart
					else if (cartMenuOption == 3) {
						System.out.println("Please enter the title of the media that you want to remove from the cart");
						String tempTitle = sc.nextLine();
						int removedMediaNum = anOrder.removeMedia(new DigitalVideoDisc(tempTitle));
						if (removedMediaNum != 0) {
							System.out.println("Successfully delete the media(s) from the cart");
						}
						else {
							System.out.println("There's is no media with that name!");
						}
						Aims.promptEnterKey();
					}
					// Place an order
					else if (cartMenuOption == 4) {
						anOrder.print();
						System.out.println("Your order has been placed successfully!");
						menuOption = 0;
						stopCartMenu = true;
						anOrder = new Cart();
					}
					// Play a media in the cart
					else if (cartMenuOption == 5) {
						tempItemsOrdered = anOrder.display();
						for (int i = 0; i < tempItemsOrdered.size(); i++) {
							playableMedia = (tempItemsOrdered.get(i) instanceof Playable) ? " - Playble" : "";
							System.out.println(String.format("%02d", i + 1) + "." + tempItemsOrdered.get(i).toString() + playableMedia);
						}
						System.out.println("----------------------------------------------------------------------------------");
						System.out.println("Please enter the title of the media in the cart to play:");
						tempMedia = store.searchByTitle(sc.nextLine());
						if (tempMedia == null) {
							System.out.println("There's no matching media in the store!");
						}
						else if (tempMedia instanceof Playable){
							((Playable) tempMedia).play();
						}
						else {
							System.out.println("Can't play this media!");
						}
						Aims.promptEnterKey();
					}
					// Go back to menu
					else if (cartMenuOption == 0) {
						stopCartMenu = true;
					}
				}
			}
			if (menuOption == 0) {
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("--------------------------------Application closed--------------------------------");
				System.out.println("----------------------------------------------------------------------------------");
				stopMenu = true;
			}
		}
		MemoryDaemon md = new MemoryDaemon();
		md.setDaemon(true);
		md.start();
	}
	
		// Show all menu options
		public static void showMenu() {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
		}
		
		// Show all store options
		public static void storeMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. See current cart");
			System.out.println("4. Play a media in the store");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
		}
		
		// Show all cart options
		public static void cartMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Place order");
			System.out.println("5. Play a media in the cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
		
		// Show all update store options
		public static void updateStore() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add media(s) to the store");
			System.out.println("2. Remove media(s) from the store");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		
		// Show all add media options
		public static void addMediaMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add a DVD to the store");
			System.out.println("2. Add a CD to the store");
			System.out.println("3. Add a Book to the store");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
		}
		
		// Show all filter cart options
		public static void filterCart() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter media(s) by id");
			System.out.println("2. Filter media(s) by title");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		
		// Show all sort cart options
			public static void sortCart() {
				System.out.println("Options: ");
				System.out.println("--------------------------------");
				System.out.println("1. Sort media(s) by title");
				System.out.println("2. Sort media(s) by cost");
				System.out.println("0. Back");
				System.out.println("--------------------------------");
				System.out.println("Please choose a number: 0-1-2");
			}
		
		// Take input from user 
		public static int input(int optionNum) {
			Scanner sc = new Scanner(System.in);
			int option = 0;
			boolean checkMenuOption = false;
			while(!checkMenuOption) {
				try {
					option = sc.nextInt();
			        if(option >= 0 && option <= optionNum){
			        	checkMenuOption = true;
			        } 
			        else {
			        	System.out.println("Please type a number from 0 to " + optionNum);
			        }
			    } 
				catch (InputMismatchException e) {
			        System.out.println("Not a valid number!");
			        sc.next();
			    }
		     }
			return option;
		}
		
		// Enter to continue
		public static void promptEnterKey(){
		    System.out.println("Press \"ENTER\" to continue...");
		    try {
		        System.in.read();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
}
