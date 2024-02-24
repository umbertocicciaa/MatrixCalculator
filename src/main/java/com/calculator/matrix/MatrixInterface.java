package com.calculator.matrix;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public interface MatrixInterface<T extends Number> {
    void setValueAt(CoordinateInterface coordinate, T value);

    Number getValueAt(CoordinateInterface coordinate);

    int getRow();

    int getColumn();

    Number[][] getMatrix();

    @SuppressWarnings("unchecked")
    default MatrixInterface<T> sum(@NotNull MatrixInterface<T> addend) {
        if (getRow() != addend.getRow() || getColumn() != addend.getColumn())
            throw new IllegalArgumentException("Dimension error");
        MatrixInterface<T> sum = MatrixFactoryInterface.createMatrix(getRow(), getColumn());
        for (int i = 0; i < getRow(); ++i)
            for (int j = 0; j < getColumn(); ++j)
                sum.setValueAt(CoordinateFactory.createCoordinate(i, j), (T) (BigDecimal.valueOf(getMatrix()[i][j].doubleValue() + addend.getValueAt(CoordinateFactory.createCoordinate(i, j)).doubleValue())));
        return sum;
    }

    @SuppressWarnings("unchecked")
    default MatrixInterface<T> subtract(@NotNull MatrixInterface<T> subtrahend) {
        if (getRow() != subtrahend.getRow() || getColumn() != subtrahend.getColumn())
            throw new IllegalArgumentException("Dimension error");
        MatrixInterface<T> difference = MatrixFactoryInterface.createMatrix(getRow(), getColumn());
        for (int i = 0; i < getRow(); ++i)
            for (int j = 0; j < getColumn(); ++j)
                difference.setValueAt(CoordinateFactory.createCoordinate(i, j), (T) (BigDecimal.valueOf(getMatrix()[i][j].doubleValue() - subtrahend.getValueAt(CoordinateFactory.createCoordinate(i, j)).doubleValue())));
        return difference;
    }

    @SuppressWarnings({"ReassignedVariable", "unchecked"})
    default MatrixInterface<T> multiply(@NotNull MatrixInterface<T> multiplicand) {
        if (getColumn() != multiplicand.getRow())
            throw new IllegalArgumentException("Dimension error");
        MatrixInterface<T> product = MatrixFactoryInterface.createMatrix(getRow(), multiplicand.getColumn());
        for (int i = 0; i < getRow(); ++i) {
            for (int j = 0; j < multiplicand.getColumn(); ++j) {
                double valueAtIJ = 0.0;
                for (int k = 0; k < getColumn(); ++k)
                    valueAtIJ += getValueAt(CoordinateFactory.createCoordinate(i, k)).doubleValue() * multiplicand.getValueAt(CoordinateFactory.createCoordinate(k, j)).doubleValue();
                product.setValueAt(CoordinateFactory.createCoordinate(i, j), (T) BigDecimal.valueOf(valueAtIJ));
            }
        }
        return product;
    }

    default MatrixInterface<T> transposeMatrix() {
        MatrixInterface<T> transpose = MatrixFactoryInterface.createMatrix(getColumn(), getRow());
        for(int i=0;i<getColumn();++i)
            for (int j=0;j<getRow();++j)
                transpose.setValueAt(CoordinateFactory.createCoordinate(i,j),(T)getValueAt(CoordinateFactory.createCoordinate(j,i)));
        return transpose;
    }

    default Number determinant() {
        if (getColumn() != getRow())
            throw new UnsupportedOperationException("Operazione determinante consentita solo con matrici quadrate");
        return determinant(getMatrix());
    }

    private Number determinant(Number[][] matrix) {
        int n = matrix.length;
        if (n == 1)
            return matrix[0][0];
        double det = 0;
        for (int j = 0; j < n; j++) {
            det += Math.pow(-1, j) * (Double) matrix[0][j] * (Double) determinant(getSubMatrix(matrix, j));
        }
        return det;
    }

    private Number[][] getSubMatrix(Number[][] matrix, int colToRemove) {
        int n = matrix.length;
        Number[][] subMatrix = new Number[n - 1][n - 1];
        int newRow = 0, newCol;
        for (int i = 0; i < n; i++) {
            if (i == 0)
                continue;
            newCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove)
                    continue;
                subMatrix[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }
        return subMatrix;
    }

}
