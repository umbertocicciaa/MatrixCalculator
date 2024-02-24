package com.calculator.ui;

public abstract class MatrixViewAbstract implements MatrixView {

    protected MatrixPresenter presenter;

    @Override
    public void setPresenter(MatrixPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public MatrixPresenter getPresenter() {
        return presenter;
    }

}
