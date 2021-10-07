package personal.simplecalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import personal.simplecalculator.graphics.Graphics;

public class App extends Application {
    Graphics graphics = new Graphics();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(graphics.getBoard(), 800, 800));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
