package com.calculator.matrix;

public final class NullMatrixElement extends Number {

    private static final NullMatrixElement instance = new NullMatrixElement();

    private NullMatrixElement() {
    }

    public static NullMatrixElement getInstance() {
        return instance;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public String toString(){
        return "NullObject";
    }

}
