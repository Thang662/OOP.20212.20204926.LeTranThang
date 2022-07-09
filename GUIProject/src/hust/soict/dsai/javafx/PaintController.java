package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaintController {
	boolean draw = true;
	
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (draw && event.getX() > 0) {
    		drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 4, Color.BLACK));
    	}
    	else if (event.getX() > 0){
    		drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 4, Color.WHITE));
    	}
    }

    @FXML
    void eraserAreaMouseDragged(ActionEvent event) {
    	draw = false;
    }

    @FXML
    void penButtonPressed(ActionEvent event) {
    	draw = true;
    }

}

