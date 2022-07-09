package hust.soict.dsai.aims.screen.customer.controller;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ItemController {
	private Media media;
	private Cart cart;
	public void setData(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost() + " $");
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 110));
		}
	}
	
    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(null);
    	alert.setHeaderText(null);
    	if (JOptionPane.showOptionDialog(null, "Do you want to add this media to cart ?", "Confirm",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"YES", "NO"}, "YES") == JOptionPane.OK_OPTION) {
        	try {
				cart.addMedia(media);
			} catch (LimitExceededException e) {
				alert.setContentText("You have reached the maximum number of items ordered");
				alert.showAndWait();
				e.printStackTrace();
			} catch (NullPointerException e) {
				alert.setContentText("Can't add a null object");
				alert.showAndWait();
				e.printStackTrace();
			} 	
        	alert.setContentText("Media has been added to the cart");
        	alert.showAndWait();
    	}
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(null);
    	alert.setHeaderText(null);
    	alert.setContentText(media.toString());
    	alert.showAndWait();
    }

}

