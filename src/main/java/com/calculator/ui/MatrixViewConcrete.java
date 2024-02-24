package com.calculator.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class MatrixViewConcrete extends MatrixViewAbstract {

    public TextArea firstMatrixTexArea;

    public TextArea secondMatrixTexArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void displayMatrix() {

    }

    @Override
    public String getDisplayedData() {
        return null;
    }


    public void calcoloDeterminantePrima() {
        String text="";
        try {
            Number determinant = presenter.getFirstMatrix().determinant();
            text = determinant.toString();
        }catch (UnsupportedOperationException e){
            text="Matrice non quadrata";
        }finally {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Determinant Calculation");
            alert.setHeaderText(null);
            alert.setContentText("The determinant of the matrix is: " + text);
            alert.showAndWait();
        }
    }

    public void calcoloInversaPrima(ActionEvent actionEvent) {

    }

    public void calcoloTraspostaPrima(ActionEvent actionEvent) {

    }

    public void calcoloRangoPrima(ActionEvent actionEvent) {

    }

    public void calcoloDeterminanteSeconda() {
        String text="";
        try {
            Number determinant = presenter.getSecondMatrix().determinant();
            text = determinant.toString();
        }catch (UnsupportedOperationException e){
            text="Matrice non quadrata";
        }finally {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Determinant Calculation");
            alert.setHeaderText(null);
            alert.setContentText("The determinant of the matrix is: " + text);
            alert.showAndWait();
        }
    }

    public void calcoloInversaSeconda(ActionEvent actionEvent) {

    }

    public void calcoloTraspostaSeconda(ActionEvent actionEvent) {

    }

    public void calcoloRangoSeconda(ActionEvent actionEvent) {

    }

    public void firstMatrixOnKeyReleased() {
        String text = firstMatrixTexArea.getText();
        presenter.createFirstMatrix(text);
    }

    public void secondMatrixOnKeyReleased() {
        String text = secondMatrixTexArea.getText();
        presenter.createSecondMatrix(text);
    }

}
