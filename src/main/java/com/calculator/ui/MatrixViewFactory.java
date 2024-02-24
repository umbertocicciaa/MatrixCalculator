package com.calculator.ui;


public interface MatrixViewFactory {
    static <T extends Number> MatrixView createMatrixViewStub() {
        return new MatrixViewStub();
    }

    static <T extends Number> MatrixView createMatrixView(){ return new MatrixViewConcrete(); }

}
