package com.calculator.matrixcalculator;

import com.calculator.matrix.MatrixFactoryInterface;
import com.calculator.ui.MatrixPresenter;
import com.calculator.ui.MatrixPresenterFactory;
import com.calculator.ui.MatrixView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);


        MatrixView view = fxmlLoader.getController();

        MatrixPresenter presenter= MatrixPresenterFactory.createPresenter(
                MatrixFactoryInterface.createMatrixFromText(""),
                MatrixFactoryInterface.createMatrixFromText(""),
                view);

        view.setPresenter(presenter);

        stage.setTitle("Test!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
