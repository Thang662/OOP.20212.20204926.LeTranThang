package hust.soict.program.test.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	private static Store store;
	private static Cart cart;
	
	@Override 
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store :");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		String content = "The seeds for the eventual rise of the evil Empire are sown in a seemingly routine place: a trade dispute between the Republic and the Trade Federation. Two Jedi, the keepers of peace and justice, are dispatched to negotiate the dispute, but (wait for it) it's a trap! They end up barely escaping with their lives, though they do meet R2-D2, who saves their lives. They end up on remote Tatooine, where they meet slave boy Anakin Skywalker and his protocol droid C3PO. Jedi Qui-Gon Jinn senses the Force in Anakin - and believes he's the \"Chosen One\" who will bring balance to the Force. There's a podrace and Anakin is freed. Qui-Gon wants to train Anakin, but the Jedi Council knows something is up with this boy and rejects it. But he helps the Republic win a battle against the Trade Federation so the Council lets Obi-Wan Kenobi take him as his apprentice.";
		String content1 = "Some people believe that technology has made man more social. To what extent do you agree or disagree with this opinion?\r\n"
				+ "\r\n"
				+ "Experts throughout both the developing and developed world have debated whether the advent of sophisticated modern technology such as mobile phones, laptops and iPad have helped to enhance and improve people's social lives or whether the opposite has become the case.\r\n"
				+ "\r\n"
				+ "Personally, I strongly advocate the former view. This essay will discuss both sides using examples from the UK government and Oxford University to demonstrate points and prove arguments.\r\n"
				+ "\r\n"
				+ "On the one hand there is ample, powerful, almost daily evidence that such technology can be detrimental especially to the younger generation who are more easily affected by it�s addictive nature and which can result in people feeling more isolated from the society.\r\n"
				+ "\r\n"
				+ "The central reason behind this is twofold, firstly, the invention of online social media sites and apps, such as Twitter and Facebook have reduced crucial face-to-face interactions dramatically. Through use of these appealing and attractive mediums, people feel in touch and connected yet lack key social skills and the ability to communicate.\r\n"
				+ "\r\n"
				+ "Secondly, dependence on such devices is built up frighteningly easily which may have a damaging effect on mental health and encourage a sedentary lifestyle. For example, recent scientific research by the UK government demonstrated that 90% of people in their 30s spend over 20 hours per week on Messenger and similar applications to chat with their friends instead of meeting up and spending quality time together or doing sport. As a result, it is conclusively clear that these technology advancements have decreased and diminished our real life interactions.\r\n"
				+ "\r\n"
				+ "On the other hand, although there are significant downsides to technological developments, its� multifold advantages cannot be denied. This is largely because the popularity of technology such as cellphones allows people to connect freely and easily with no geographical barriers.\r\n"
				+ "\r\n"
				+ "People are able to share any type of news, information, photos and opinions with their loved ones whenever and wherever they want therefore keeping a feeling of proximity and closeness. For example, an extensive study by Oxford University illustrated that people who work, or study abroad and use applications like Facetime and WhatsApp to chat with their families, are less likely to experience loneliness and feel out of the loop than those who do not.\r\n"
				+ "\r\n"
				+ "Consistent with this line of thinking is that businessmen are also undoubtedly able to benefit from these advances by holding virtual real-time meetings using Skype which may increase the chance of closing business deals without the need to fly.\r\n"
				+ "\r\n"
				+ "From the arguments and examples given I firmly believe that overall communication and mans� sociability has been advanced enormously due to huge the huge technological progress of the past twenty years and despite some potentially serious health implications which governments should not fail to address, it is predicted that its popularity will continue to flourish in the future.";
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
		cart = new Cart();
		launch(args);
	}
}
