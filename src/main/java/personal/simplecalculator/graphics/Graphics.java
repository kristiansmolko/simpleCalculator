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

        Text text = new Text("2+2*40+60+50+50");

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

        var button1 = new NumberCalculatorButton(1, text).getButton();
        var button2 = new NumberCalculatorButton(2, text).getButton();
        var button3 = new NumberCalculatorButton(3, text).getButton();
        var button4 = new NumberCalculatorButton(4, text).getButton();
        var button5 = new NumberCalculatorButton(5, text).getButton();
        var button6 = new NumberCalculatorButton(6, text).getButton();
        var button7 = new NumberCalculatorButton(7, text).getButton();
        var button8 = new NumberCalculatorButton(8, text).getButton();
        var button9 = new NumberCalculatorButton(9, text).getButton();
        var button0 = new NumberCalculatorButton(0, text).getButton();

        var add = new FunctionalCalculatorButton("+", text).getButton();
        var substract = new FunctionalCalculatorButton("-", text).getButton();
        var multiply = new FunctionalCalculatorButton("*", text).getButton();
        var divide = new FunctionalCalculatorButton("/", text).getButton();
        var equals = new FunctionalCalculatorButton("=", text).getButton();
        var clear = new FunctionalCalculatorButton("C", text).getButton();

        buttons.addRow(0, button1, button2, button3, divide);
        buttons.addRow(1, button4, button5, button6, multiply);
        buttons.addRow(2, button7, button8, button9, substract);
        buttons.addRow(3, clear, button0, equals, add);

        stack.getChildren().addAll(background, display, buttons);
        root.setCenter(stack);

        return root;
    }
}
