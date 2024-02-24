package com.calculator.ui;

import com.calculator.matrix.MatrixInterface;

public class MatrixConcretePresenter extends MatrixAbstractPresenter{
    public MatrixConcretePresenter(MatrixInterface firstMatrix,MatrixInterface secondMatrix ,MatrixView view) {
        super(firstMatrix,secondMatrix,view);
    }

}
