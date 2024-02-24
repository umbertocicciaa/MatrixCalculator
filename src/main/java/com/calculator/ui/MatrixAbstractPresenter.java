package com.calculator.ui;

import com.calculator.matrix.MatrixFactoryInterface;
import com.calculator.matrix.MatrixInterface;

public abstract class MatrixAbstractPresenter implements MatrixPresenter{

    protected MatrixInterface firstMatrix,secondMatrix;
    protected MatrixView view;
    public MatrixAbstractPresenter(MatrixInterface firstMatrix, MatrixInterface secondMatrix, MatrixView view) {
        setFirstMatrix(firstMatrix);
        setSecondMatrix(secondMatrix);
        setView(view);
    }

    @Override
    public <T extends Number> void setFirstMatrix(MatrixInterface<T> matrix) {
        this.firstMatrix=matrix;
    }

    @Override
    public <T extends Number> void setSecondMatrix(MatrixInterface<T> matrix) {
        this.secondMatrix=matrix;
    }

    @Override
    public <T extends Number> MatrixInterface<T> getFirstMatrix() {
        return firstMatrix;
    }

    @Override
    public <T extends Number> MatrixInterface<T> getSecondMatrix() {
        return secondMatrix;
    }

    @Override
    public void createFirstMatrix(String text){
        firstMatrix= MatrixFactoryInterface.createMatrixFromText(text);
    }

    @Override
    public void createSecondMatrix(String text){
        secondMatrix=MatrixFactoryInterface.createMatrixFromText(text);
    }

    @Override
    public void setView(MatrixView view) {
        this.view=view;
    }
}
