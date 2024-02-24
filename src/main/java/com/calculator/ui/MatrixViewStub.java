package com.calculator.ui;

import java.net.URL;
import java.util.ResourceBundle;

public class MatrixViewStub extends MatrixViewAbstract{

    private String dataDisplayed;

    @Override
    public void displayMatrix() {
        this.dataDisplayed=presenter.getFirstMatrix().toString();
    }

    @Override
    public String getDisplayedData() {
        return dataDisplayed;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
