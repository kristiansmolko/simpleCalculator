package personal.simplecalculator.graphics;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import personal.simplecalculator.functions.Function;
import personal.simplecalculator.functions.Functions;

public class FunctionalCalculatorButton extends CalculatorButton{
    protected FunctionalCalculatorButton(String value, Text text) {
        super(value, text);
        setStyle();
        setActionEvent();
    }

    private void setStyle(){
        button.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(5.0), new Insets(0))));
    }

    private void setActionEvent(){
        if (!button.getText().equals("C") && !button.getText().equals("=")) {
            button.setOnAction(functionalActionEvent());
        } else if (button.getText().equals("C"))
            button.setOnAction(clearDisplay());
        else {
            button.setOnAction(calculate());
        }
    }

    private void addAction(){
        switch(button.getText()){
            case "+" -> action.addFunction(Function.ADDING);
            case "-" -> action.addFunction(Function.SUBSTRACT);
            case "*" -> action.addFunction(Function.MULTIPLY);
            case "/" -> action.addFunction(Function.DIVIDE);
        }
    }

    private EventHandler<ActionEvent> functionalActionEvent(){
        addAction();
        return actionEvent -> text.setText(text.getText() + button.getText());
    }

    private EventHandler<ActionEvent> clearDisplay(){
        return actionEvent -> text.setText("");
    }

    private EventHandler<ActionEvent> calculate(){
        return actionEvent -> {
            Functions functions = new Functions(action);
            functions.setExercise(text.getText());
            var result = functions.getResult();
            text.setText(String.valueOf(result));
            action.resetFunctions();
        };
    }
}
