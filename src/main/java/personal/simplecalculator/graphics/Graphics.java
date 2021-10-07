package personal.simplecalculator.graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
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

        var buttons = new GridPane();
        buttons.setTranslateX(10);
        buttons.setTranslateY(30);
        buttons.setMaxSize(170, 150);
        buttons.setVgap(10);
        buttons.setHgap(10);

        var button1 = numberButton(1);
        var button2 = numberButton(2);
        var button3 = numberButton(3);
        var button4 = numberButton(4);
        var button5 = numberButton(5);
        var button6 = numberButton(6);
        var button7 = numberButton(7);
        var button8 = numberButton(8);
        var button9 = numberButton(9);
        var button0 = numberButton(0);

        var add = functionalButton("+");
        var substract = functionalButton("-");
        var multiply = functionalButton("*");
        var divide = functionalButton("/");
        var equals = functionalButton("=");
        var clear = functionalButton("C");

        buttons.addRow(0, button1, button2, button3, divide);
        buttons.addRow(1, button4, button5, button6, multiply);
        buttons.addRow(2, button7, button8, button9, substract);
        buttons.addRow(3, clear, button0, equals, add);

        stack.getChildren().addAll(background, display, buttons);
        root.setCenter(stack);

        return root;
    }

    private Button numberButton(int number){
        var button = new Button(String.valueOf(number));
        button.setPrefSize(30, 30);
        button.setBackground(new Background(new BackgroundFill(Color.NAVAJOWHITE, new CornerRadii(5.0), new Insets(0))));
        button.setStyle("-fx-border-radius: 5px");
        return button;
    }

    private Button functionalButton(String display){
        var button = new Button(display);
        button.setPrefSize(30, 30);
        button.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(5.0), new Insets(0))));
        button.setStyle("-fx-border-radius: 5px");
        return button;
    }
}
