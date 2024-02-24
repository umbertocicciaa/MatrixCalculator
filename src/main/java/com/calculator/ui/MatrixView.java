package com.calculator.ui;

import javafx.fxml.Initializable;

public interface MatrixView extends Initializable {
    void displayMatrix();
    String getDisplayedData();
    void setPresenter(MatrixPresenter presenter);
    MatrixPresenter getPresenter();
}
