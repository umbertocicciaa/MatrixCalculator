package com.calculator.matrix;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public abstract class MatrixAbstract<T extends Number> implements MatrixInterface<T> {

    protected final Number[][] matrix;
    protected final int row, column;

    public MatrixAbstract(int row, int column) {
        if (row <= 0 || column <= 0)
            throw new IllegalArgumentException("Dimension error");
        this.row = row;
        this.column = column;
        this.matrix = new Number[row][column];
        for(int i=0;i<row;++i)
            for (int j=0;j<column;++j)
                matrix[i][j]=NullMatrixElement.getInstance();
    }

    @Override
    public void setValueAt(@NotNull CoordinateInterface coordinate, T value) {
        matrix[coordinate.x()][coordinate.y()] = value;
    }

    @Override
    public Number getValueAt(@NotNull CoordinateInterface coordinate) {
        return matrix[coordinate.x()][coordinate.y()];
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public Number[][] getMatrix() {
        return matrix;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MatrixInterface<?> that)) return false;
        if (row != that.getRow()) return false;
        if (column != that.getColumn()) return false;
        return Arrays.deepEquals(matrix, that.getMatrix());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Arrays.deepHashCode(matrix);
        result = 31 * result + row;
        result = 31 * result + column;
        return result;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrix);
    }
}
