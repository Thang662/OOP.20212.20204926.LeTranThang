package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;
	FilteredList<Media> filteredMedia;
	
	// Constructor with cart
	public CartController(Store store, Cart cart) {
		super();
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
    private TextField tfFilter;

	@FXML
    private RadioButton radioBtnFilterId;
	
	@FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Button buttonPlay;

    @FXML
    private Button buttonRemove;
    
    @FXML
    private Label costLabel;

    @FXML
    private void initialize() {
    	filteredMedia = new FilteredList<Media>(cart.getItemsOrdered());
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if (filteredMedia != null) {
    		tblMedia.setItems(filteredMedia);
    	}
    	
    	buttonPlay.setVisible(false);
    	buttonRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						// TODO Auto-generated method stub
						if (newValue != null) {
							updateButtonBar(newValue);
						}
						costLabel.setText(String.format("$%.2f", cart.totalCost()));
					}
				});
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				showFilteredMedia(newValue);
			}
		});
    	costLabel.setText(String.format("$%.2f", cart.totalCost()));
    }
    
    void showFilteredMedia(String newValue) {
		// TODO Auto-generated method stub
		if (radioBtnFilterId.isSelected()) {
			filteredMedia.setPredicate(s -> String.valueOf(s.getId()).contains(newValue.replaceAll("[^0-9]", "")));
		}
		else {
			filteredMedia.setPredicate(s -> s.isMatch(newValue.replaceAll("^[ \t]+|[ \t]+$", "")));
		}
		if (newValue == "" || newValue.length() == 0) filteredMedia.setPredicate(s -> true);
	}

	void updateButtonBar(Media media) {
    	buttonRemove.setVisible(true);
    	if (media instanceof Playable) {
    		buttonPlay.setVisible(true);
    	}
    	else {
    		buttonPlay.setVisible(false);
    	}
    }
    
    @FXML
    void buttonRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	JOptionPane.showMessageDialog(null, media.toString());
    }
    
    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
    		fxmlLoader.setController(viewStoreController);
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	}
    	catch (IOException e){
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void placeOrder(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(null);
    	alert.setHeaderText(null);
    	if (cart.getItemsOrdered().size() < 5) alert.setContentText(String.format("Total cost: %.3f", cart.totalCost()));
		else alert.setContentText(String.format("Congratulation!!!! You got an discount item\n Total cost: %.3f", cart.totalCost((cart.getALuckyItem()))));
    	alert.showAndWait();
    	cart = new Cart();
    	filteredMedia = new FilteredList<Media>(cart.getItemsOrdered());
    	tblMedia.setItems(filteredMedia);
    	costLabel.setText(String.format("$%.2f", cart.totalCost()));
    }
}


