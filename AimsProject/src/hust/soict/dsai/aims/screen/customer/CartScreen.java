//package hust.soict.dsai.aims.screen.customer;
//
//import java.io.IOException;
//
//import javax.swing.JFrame;
//
//import hust.soict.dsai.aims.cart.Cart;
//import hust.soict.dsai.aims.screen.customer.controller.CartController;
//import javafx.application.Platform;
//import javafx.embed.swing.JFXPanel;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//
//public class CartScreen extends JFrame{
//	private Cart cart;
//	
//	public CartScreen(Cart cart) {
//		super();
//		
//		this.cart = cart;
//		
//		JFXPanel fxPanel = new JFXPanel();
//		this.add(fxPanel);
//		
//		this.setTitle("Cart");
//		this.setVisible(true);
////		setSize(1024, 768);
////		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
////		this.setLocation((int) ((dimension.getWidth() - this.getWidth()) / 2), (int) ((dimension.getHeight() - this.getHeight()) / 2));
//		Platform.runLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
//					CartController controller = new CartController(store, cart);
//					loader.setController(controller);
//					Parent root = loader.load();
//					fxPanel.setScene(new Scene(root));
//				}
//				catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//}
