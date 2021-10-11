package personal.simplecalculator.graphics;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class NumberCalculatorButton extends CalculatorButton{

    protected NumberCalculatorButton(int number, Text text) {
        super(number, text);
        setStyle();
        setActionEvent();
    }

    private void setStyle(){
        button.setBackground(new Background(new BackgroundFill(Color.NAVAJOWHITE, new CornerRadii(5.0), new Insets(0))));
    }

    private void setActionEvent(){
        button.setOnAction(numberButtonClickEvent(Integer.parseInt(button.getText())));
    }

    private EventHandler<ActionEvent> numberButtonClickEvent(int number){
        return actionEvent -> text.setText(text.getText() + number);
    }
}
