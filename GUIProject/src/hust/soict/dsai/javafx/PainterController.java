package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

public class PainterController {
	private Color color = Color.BLACK;
	
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penOption;

    @FXML
    private RadioButton eraserOption;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void selectPen(ActionEvent event) {
    	eraserOption.setSelected(false);
    	if(color.equals(Color.WHITE)) {
    		color = Color.BLACK;
    	}
    }
   
    @FXML
    void selectEraser(ActionEvent event) {
    	penOption.setSelected(false);
    	if(color.equals(Color.BLACK)) {
    		color = Color.WHITE;
    	}
    }
   
    @FXML
    void clearButtonPressed(ActionEvent event) {

    }
}

