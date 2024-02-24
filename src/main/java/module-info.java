module com.calculator.matrixcalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens com.calculator.matrixcalculator to javafx.fxml;
    opens com.calculator.ui to javafx.fxml;
    exports com.calculator.matrixcalculator;
    exports com.calculator.ui;
}