module personal.simplecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens personal.simplecalculator to javafx.fxml;
    exports personal.simplecalculator;
}