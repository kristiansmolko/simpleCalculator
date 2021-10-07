package personal.simplecalculator.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class Graphics {
    public BorderPane getBoard() {
        var root = new BorderPane();

        var stack = new StackPane();

        var background = new Rectangle();
        background.setWidth(200);
        background.setHeight(250);
        background.setArcWidth(20);
        background.setArcHeight(20);
        background.setFill(Color.BEIGE);

        var displayBackground = new Label();
        displayBackground.setTranslateY(-85);
        displayBackground.setPrefSize(180, 30);
        displayBackground.setBackground(new Background(new BackgroundFill(Color.OLIVE, new CornerRadii(5.0), new Insets(0))));

        var text = new Text("2+2*40+60+50+50");

        var flow = new TextFlow();
        flow.setMaxSize(180,30);
        flow.setTranslateX(-10);
        flow.setTranslateY(-80);
        flow.getChildren().add(text);
        flow.setTextAlignment(TextAlignment.RIGHT);

        var display = new StackPane();
        display.getChildren().addAll(displayBackground, flow);

        stack.getChildren().addAll(background, display);

        root.setCenter(stack);

        return root;
    }
}
