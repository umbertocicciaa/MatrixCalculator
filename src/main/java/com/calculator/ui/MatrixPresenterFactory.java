package com.calculator.ui;

import com.calculator.matrix.MatrixInterface;

public interface MatrixPresenterFactory {
    static <T extends Number> MatrixPresenter createPresenter(MatrixInterface<T> firstMatrix,MatrixInterface<T> secondMatrix ,MatrixView view) {
        return new MatrixConcretePresenter(firstMatrix,secondMatrix, view);
    }
}
