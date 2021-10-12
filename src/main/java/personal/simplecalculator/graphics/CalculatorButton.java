package personal.simplecalculator.graphics;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

public abstract class CalculatorButton {
    protected final Button button;
    protected final Text text;

    protected CalculatorButton(int number, Text text){
        button = new Button(String.valueOf(number));
        this.text = text;
        setupButton();
    }

    protected CalculatorButton(String value, Text text){
        button = new Button(value);
        this.text = text;
        setupButton();
    }

    private void setupButton(){
        button.setPrefSize(30, 30);
        setStyleForButton();
    }

    private void setStyleForButton(){
        button.setStyle("-fx-border-radius: 5px");
    }

    public Button getButton(){
        return button;
    }
}
