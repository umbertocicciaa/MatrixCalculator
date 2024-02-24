package com.calculator.ui;

import com.calculator.matrix.MatrixInterface;

public interface MatrixPresenter {

    <T extends Number>void setFirstMatrix(MatrixInterface<T> matrix);

    <T extends Number>MatrixInterface<T> getFirstMatrix();

    <T extends Number>void setSecondMatrix(MatrixInterface<T> matrix);

    <T extends Number>MatrixInterface<T> getSecondMatrix();

    void setView(MatrixView view);

    void createFirstMatrix(String tex);

    void createSecondMatrix(String tex);

}
